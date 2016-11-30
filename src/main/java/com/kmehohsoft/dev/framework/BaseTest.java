package com.kmehohsoft.dev.framework;

import com.kmehohsoft.dev.data.TestData;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.testng.annotations.*;

import java.io.IOException;
import java.net.URL;
import java.net.MalformedURLException;
import java.io.File;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.util.concurrent.TimeUnit;

public class BaseTest extends TestData{
    private static Settings settings = new Settings();

    @BeforeSuite(alwaysRun = true)
    public static void beforeSuite() throws IOException, InterruptedException{

        if (settings.getDebugMode()) {
            System.setProperty("user", settings.getDebugUserId());
            System.setProperty("appium.port", settings.getAppiumDebugPort());
        }
        AndroidBasePage.settings = settings;
        File appDir = new File(settings.getAndroidAppPath());
        File app = new File(appDir, settings.getAndroidAppName());
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "5.1");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, settings.getAndroidDeviceName());
        capabilities.setCapability(MobileCapabilityType.LAUNCH_TIMEOUT,"10000");
        capabilities.setCapability("noReset", true);
        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        capabilities.setCapability("unicodeKeyboard", "true");
        capabilities.setCapability("resetKeyboard", "true");
            try {
            AndroidBasePage.androiddriver = new AndroidDriver(new URL(settings.getAppiumServerURL() + ":" + System.getProperty("appium.port") + "/wd/hub"),capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        AndroidBasePage.androiddriver.manage().timeouts().implicitlyWait(settings.getAndroidActivityLoadTimeout(), TimeUnit.SECONDS);
    }

    @AfterSuite(alwaysRun = true)
    public static void afterClass() {
        if (AndroidBasePage.androiddriver != null) {
            AndroidBasePage.androiddriver.quit();
        }
    }
}
