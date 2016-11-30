package com.kmehohsoft.dev;

import com.kmehohsoft.dev.androidpages.LoginActivity;
import com.kmehohsoft.dev.framework.BaseTest;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static com.kmehohsoft.dev.framework.AndroidBasePage.initPage;
import static org.fest.assertions.Assertions.assertThat;
import static org.testng.asserts.Assertion.*;

public class LoginPageTest extends BaseTest {

    private LoginActivity loginactivity;

    @BeforeSuite(alwaysRun = true)
    public void openLoginPage() {
        loginactivity = initPage(LoginActivity.class);
    }

    @Test(priority = 4,groups = {"AuthorizationAndLogin"})
    public void userActivation() {
        loginactivity.enterActivationCode(System.getProperty("user"));
        loginactivity.openActivationCodeDialog();
        assertThat(loginactivity.checkIfUserLoginIsRight(System.getProperty("user"))).isTrue();
    }

    @Test(priority = 1,groups = {"AuthorizationAndLogin"})
    public void switchToUserAgreementPage(){
        loginactivity.clickUserAgreementDialogOKButton();
        loginactivity.setAcceptanceAgreementCheckbox();
        assertThat(loginactivity.checkIfLicenceAgreementChecked()).isTrue();
    }

    @Test(priority = 2,groups = {"AuthorizationAndLogin"})
    public void switchToAuthorizationPage(){
        loginactivity.clickAuthorization();
        assertThat(loginactivity.checkIfAuthorizationPageVisible()).isTrue();
    }

    @Test(dataProvider = "Languages",priority = 3,groups = {"AuthorizationAndLogin"})
    public void switchLanguage(String languageNumber,String languageSpelling){
        loginactivity.clickLanguageList();
        loginactivity.selectLanguage(languageNumber);
        assertThat(loginactivity.checkIfLanguageWasSwitched(languageSpelling)).isTrue();
    }
}
