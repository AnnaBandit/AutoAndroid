package com.kmehohsoft.dev;

import com.kmehohsoft.dev.androidpages.LoginActivity;
import com.kmehohsoft.dev.androidpages.MainApplicationPageActivity;
import com.kmehohsoft.dev.framework.BaseTest;
import com.kmehohsoft.dev.framework.Settings;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static com.kmehohsoft.dev.framework.AndroidBasePage.androiddriver;
import static com.kmehohsoft.dev.framework.AndroidBasePage.settings;
import static org.fest.assertions.Assertions.assertThat;
import static com.kmehohsoft.dev.framework.AndroidBasePage.initPage;
import static org.testng.Assert.assertTrue;

public class MainApplicationPageTest  extends BaseTest {

    private LoginActivity loginactivity;
    private MainApplicationPageActivity mainapplicationpageactivity;

    @BeforeSuite(alwaysRun = true)
    public void openMainApplicationPage() {
        loginactivity = initPage(LoginActivity.class);
        mainapplicationpageactivity = initPage(MainApplicationPageActivity.class);
    }

    @Test(priority = 1,groups= {"MainPage"})
    public void downloadDatabase(){
        loginactivity.clickLoginButton();
        loginactivity.downloadDatabase();
        assertTrue(loginactivity.scanWithoutRegistrationIsVisible());
    }

    @Test(priority = 2,groups = {"MainPage"})
    public void watchUserAgreement(){
        mainapplicationpageactivity.openApplicationMenu();
        mainapplicationpageactivity.openLicenceView();
        assertTrue(mainapplicationpageactivity.checkIfLicenceViewVisible());
    }

    @Test(priority = 3,groups = {"MainPage"})
    public void backToPatientsPage(){
         mainapplicationpageactivity.openApplicationMenu();
         mainapplicationpageactivity.openPatientsList();
         assertTrue(mainapplicationpageactivity.checkIfMainPagePresent());
     }

    @Test(priority = 4,enabled = true,groups = {"MainPage"})
    public void downloadOrOpenManual(){
        mainapplicationpageactivity.openApplicationMenu();
        mainapplicationpageactivity.clickManualItem();
        mainapplicationpageactivity.downloadManual();
        mainapplicationpageactivity.postponeManualOpening();
        assertTrue(mainapplicationpageactivity.checkIfMainPagePresent());
    }

    @Test(priority = 5,groups = {"MainPage"})
    public void checkApplicationData(){
        mainapplicationpageactivity.openApplicationMenu();
        mainapplicationpageactivity.clickAboutItem();
        assertTrue(mainapplicationpageactivity.checkApplicationVersion());
        assertTrue(mainapplicationpageactivity.checkUserAccountLink(Integer.parseInt(settings.getUserId())));
    }

    @AfterMethod(alwaysRun= true)
    public void closeApp() {
        androiddriver.resetApp();
    }
}
