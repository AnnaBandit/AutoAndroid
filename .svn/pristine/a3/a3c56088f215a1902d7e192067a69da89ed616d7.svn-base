package com.kmehohsoft.dev.framework;

import com.kmehohsoft.dev.serverside.ERIDataBase;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.PageFactory;

public class AndroidBasePage {
    public static AppiumDriver androiddriver;
    public static Settings settings;
    protected ERIDataBase eriDataBase;

    public static <T extends AndroidBasePage> T initPage(Class<T> pageClass) {
        return PageFactory.initElements(androiddriver, pageClass);
    }


}
