package com.kmehohsoft.dev;


import com.kmehohsoft.dev.androidpages.LoginActivity;
import com.kmehohsoft.dev.framework.BaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.kmehohsoft.dev.framework.AndroidBasePage.androiddriver;
import static org.fest.assertions.Assertions.assertThat;
import static com.kmehohsoft.dev.framework.AndroidBasePage.initPage;

public class LoginAfterActivationTest extends BaseTest {

    private LoginActivity loginactivity;

    @BeforeMethod(alwaysRun = true)
    public void openLoginPage() {
        loginactivity = initPage(LoginActivity.class);
    }

    @Test(dataProvider = "UsersPassword",groups = {"AuthorizationAndLogin"})
    public void userLoginAfterActivation(String userpassword){
        //loginactivity.reloadApplication();
        loginactivity.enterUserPassword(userpassword);
        loginactivity.clickRememberPasswordCheckbox();
        loginactivity.clickLoginButton();
        assertThat(loginactivity.checkIfDBDownloadDialogIsVisible()).isTrue();
    }

   /* @AfterMethod(alwaysRun= true)
    public void closeApp() {
        androiddriver.resetApp();
    }*/

}
