package com.kmehohsoft.dev.androidpages;

import com.kmehohsoft.dev.framework.AndroidBasePage;
import com.kmehohsoft.dev.framework.Utils;
import com.kmehohsoft.dev.models.User;
import com.kmehohsoft.dev.serverside.ERIDataBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

public class LoginActivity extends AndroidBasePage {

    private String downloadDBDialogID = "eri.kmehohsoft.android.tablet:id/download_db_message_textview";
    private final String loginButtonID = "eri.kmehohsoft.android.tablet:id/login_button";
    private String languageListID = "android:id/text1";
    private String languageLabelID = "eri.kmehohsoft.android.tablet:id/lang_label";
    private String rememberPasswordCheckbox = "eri.kmehohsoft.android.tablet:id/save_pass";
    private String userAgreementDialogOkButtonID = "android:id/button1";
    private String acceptanceAgreementCheckboxID = "eri.kmehohsoft.android.tablet:id/acceptance_checkbox";

    @FindBy(id="eri.kmehohsoft.android.tablet:id/new_user_button")
    WebElement newUserButton;
    @FindBy(id="eri.kmehohsoft.android.tablet:id/activation_code_edittext")
    WebElement activationCodeField;
    @FindBy(id="eri.kmehohsoft.android.tablet:id/button")
    WebElement requestUserButton;
    @FindBy(id="eri.kmehohsoft.android.tablet:id/login_edit_text")
    WebElement userLoginField;
    @FindBy(id="eri.kmehohsoft.android.tablet:id/pass_edit_text")
    WebElement userPasswordField;
    @FindBy(id=loginButtonID)
    WebElement loginButton;
    @FindBy(id="eri.kmehohsoft.android.tablet:id/left_button")
    WebElement downloadDatabaseButton;
    @FindBy(id="eri.kmehohsoft.android.tablet:id/scan_without_registration")
    WebElement scanWithoutRegistrationButton;

    public LoginActivity(){
        eriDataBase = new ERIDataBase(settings.getAzureServerName(),settings.getAzureServerDBName(),settings.getAzureServerUserLogin(),settings.getAzureServerUserPassword());
    }

    public void openActivationCodeDialog(){
        newUserButton.click();
    }

    public void enterActivationCode(String userid) {
        eriDataBase.resetActivationCodeData(Integer.parseInt(userid));
        activationCodeField.click();
        activationCodeField.sendKeys(eriDataBase.getUserActivationCode(Integer.parseInt(userid)));
    }

    public void clickRequestUserButton(){
        requestUserButton.click();
    }

    public void enterUserPassword(String password){
        userPasswordField.sendKeys(password);
    }

    public boolean checkIfUserLoginIsRight(String userid){
        new WebDriverWait(androiddriver, 30).until(ExpectedConditions.textToBePresentInElement(userLoginField, eriDataBase.getUserLoginName(Integer.parseInt(userid))));
        return userLoginField.getText().contains(eriDataBase.getUserLoginName(Integer.parseInt(userid)));
    }

    public void clickLoginButton(){
        loginButton.click();
    }

    public boolean checkIfDBDownloadDialogIsVisible(){
        return Utils.isElementPresent(By.id(downloadDBDialogID));
    }

    public boolean checkIfLicenceAgreementChecked(){
        MobileElement LicenceAgreementCheckbox = (MobileElement)AndroidBasePage.androiddriver.findElementsById(acceptanceAgreementCheckboxID).get(0);
        return LicenceAgreementCheckbox.isEnabled();
    }

    public void clickAuthorization(){
        MobileElement agreement = (MobileElement)AndroidBasePage.androiddriver.findElementsByClassName("android.widget.TextView").get(0);
        agreement.tap(1,10);
    }

    public boolean checkIfAuthorizationPageVisible(){
        return Utils.isElementPresent(By.id(loginButtonID));
    }

    public void clickLanguageList(){
        MobileElement languagelist = (MobileElement)AndroidBasePage.androiddriver.findElementsById(languageListID).get(0);
        languagelist.tap(1, 10);
    }

    public void selectLanguage(String languageNumber){
        MobileElement language  = (MobileElement)AndroidBasePage.androiddriver.findElementsByClassName("android.widget.TextView").get((Integer.parseInt(languageNumber) - 1));
        language.tap(1, 10);
    }

    public boolean checkIfLanguageWasSwitched(String languageSpelling){
        MobileElement languagelabel = (MobileElement)AndroidBasePage.androiddriver.findElementsById(languageLabelID).get(0);
        return languagelabel.getText().contains(languageSpelling);
    }

    public void clickRememberPasswordCheckbox(){
        MobileElement savepasscheckbox = (MobileElement)AndroidBasePage.androiddriver.findElementsById(rememberPasswordCheckbox).get(0);
        savepasscheckbox.click();
    }

    public void clickUserAgreementDialogOKButton(){
        MobileElement UserAgreementDialogOKButton = (MobileElement)AndroidBasePage.androiddriver.findElementsById(userAgreementDialogOkButtonID).get(0);
        UserAgreementDialogOKButton.tap(1, 50);
    }

    public void setAcceptanceAgreementCheckbox(){
        MobileElement AcceptanceAgreementCheckbox = (MobileElement)AndroidBasePage.androiddriver.findElementsById(acceptanceAgreementCheckboxID).get(0);
        AcceptanceAgreementCheckbox.tap(1,50);
    }

    public void reloadApplication(){
        Utils.closeApplication();
        Utils.openApplication();
    }

    public void downloadDatabase() {
        downloadDatabaseButton.click();
        new WebDriverWait(androiddriver, 180).until(ExpectedConditions.elementToBeClickable(scanWithoutRegistrationButton));
    }

    public boolean scanWithoutRegistrationIsVisible() {
        return scanWithoutRegistrationButton.isEnabled();
    }

    public void loginWith(String login, String password){
        userLoginField.sendKeys(login);
        userPasswordField.sendKeys(password);
        clickLoginButton();
    }
}
