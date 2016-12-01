package com.kmehohsoft.dev;


import com.kmehohsoft.dev.androidpages.LoginActivity;
import com.kmehohsoft.dev.androidpages.PatientsActivity;
import com.kmehohsoft.dev.framework.BaseTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


import static com.kmehohsoft.dev.framework.AndroidBasePage.initPage;
import static org.fest.assertions.Assertions.assertThat;
import static org.testng.Assert.assertTrue;

@Test(priority=4)
public class PatientsTest extends BaseTest {

    private LoginActivity loginactivity;
    private PatientsActivity patientsactivity;

    @BeforeSuite(alwaysRun = true)
    public void openMainApplicationPage() {
        loginactivity = initPage(LoginActivity.class);
        patientsactivity = initPage(PatientsActivity.class);
    }
/*
        @Test(dataProvider = "UserID",priority = 1)
        public void checkListOfPatients(String userid){
            loginactivity.clickLoginButton();
            assertThat(patientsactivity.checkListOFPatients(userid)).isTrue();
        }

        @Test(dataProvider = "UserIDAndPatientWithVisits",priority = 2)
        public void checkPatientVisitsNumber(String userid,String patientName){
            patientsactivity.clickPatientWithVisits(userid, patientName);
            assertThat(patientsactivity.checkPatientVisitsNumber(userid,patientName));
        }

        @Test(dataProvider = "UserIDAndPatientWithVisits",priority = 3)
        public void checkPatientLastVisitDate(String userid,String patientName){
            patientsactivity.clickPatientWithVisits(userid, patientName);
            assertThat(patientsactivity.checkPatientLastVisitDate(userid,patientName)).isTrue();
        }

        @Test(dataProvider = "UserIDAndPatientWithVisits",priority = 4)
        public void checkNumberOfPreviousVisits(String userid,String patientName){
            patientsactivity.clickPatientWithVisits(userid, patientName);
            assertThat(patientsactivity.checkPatientPreviousListItemsNumber(userid,patientName)).isTrue();
        }

        @Test(dataProvider = "UserIDAndPatientWithVisits",priority = 5)
        public void checkIfAnalysisButtonEnabledAfterPreviousVisitClick(String userid,String patientName){
            patientsactivity.clickPatientWithVisits(userid, patientName);
            patientsactivity.clickFirstItemInPreviousVisitsList();
            assertThat(patientsactivity.checkIfAnalysisButtonEnabled()).isTrue();
        }
*/
        @Test(dataProvider = "NewPatientDisease",priority = 6)
        public void addNewPatient(String disease,String userid){
            patientsactivity.openNewPatientPage();
            patientsactivity.fillNewPatientPersonalData(disease);
            patientsactivity.clickUserAgreementCheckBox();
            patientsactivity.clickSavePatientButton();
            assertThat(patientsactivity.checkIfNewPatientPresentInList(userid)).isTrue();
        }

        @Test(priority = 7)
        public void checkIfNewPatientPersonalInfoWasSaved(){
            patientsactivity.clickPatientEditButton();
            assertTrue(patientsactivity.compareUserTitle());
            assertTrue(patientsactivity.comparePatientFirstName());
            assertTrue(patientsactivity.comparePatientMiddleName());
            assertTrue(patientsactivity.comparePatientLastName());
            assertTrue(patientsactivity.comparePatientBirthday());
            assertTrue(patientsactivity.comparePatientGender());
            assertTrue(patientsactivity.comparePatientInsuranceNumber());
            patientsactivity.swipeToAddress(35);
            assertTrue(patientsactivity.comparePatientAddress());
            assertTrue(patientsactivity.comparePatientPhone());
            assertTrue(patientsactivity.comparePatientEmail());
            patientsactivity.swipeToAnalysis(35);
            assertTrue(patientsactivity.compareBloodTypeGroup());
            assertTrue(patientsactivity.comparePatientRhesus());
            assertTrue(patientsactivity.comparePatientAllergies());
            assertTrue(patientsactivity.comparePatientFamilyDisease());
            assertTrue(patientsactivity.comparePatientComplaints());
            patientsactivity.swipeToShowTheAgreementButton(35);
            patientsactivity.swipeToDiscardButton(5);
            patientsactivity.clickDiscardButton();
        }

        @Test(priority = 8)
        public void checkIfSaveAndCloseButtonEnabledAfterAgreedWithTerms(){
            patientsactivity.openNewPatientPage();
            patientsactivity.swipeToSaveAndCloseButton();
            patientsactivity.clickUserAgreementCheckBox();
            assertThat(patientsactivity.checkIfSavaAndCloseButtonEnabled()).isTrue();
        }

        @Test(priority = 9)
        public void checkIfAgreementDialogOpened(){
            patientsactivity.clickShowAgreementButton();
            assertThat(patientsactivity.checkIfUserAgreementPresentAndCloseIt()).isTrue();
        }

        @Test(dataProvider = "UserID",priority = 10)
        public void checkIfNewPatientWasDiscarded(String userid){
            patientsactivity.openNewPatientPage();
            patientsactivity.fillNewPatientMandatoryFields();
            patientsactivity.swipeToSaveAndCloseButton();
            patientsactivity.clickDiscardButton();
            assertThat(patientsactivity.checkIfNewPatientPresentInList(userid)).isFalse();
        }

        @Test(dataProvider = "UserID",priority = 11)
        public void checkIfPatientPersonalInfoIsSavedAfterEdit(String userid){
            patientsactivity.clickFirstInListPatientWithName(patientsactivity.getPatientLastName());
            patientsactivity.clickPatientEditButton();
            patientsactivity.editExistingPatientPersonalData();
            patientsactivity.clickSavePatientButton();
            patientsactivity.clickFirstInListPatientWithName(patientsactivity.getPatientLastName());
            patientsactivity.clickPatientEditButton();
            assertTrue(patientsactivity.compareUserTitle());
            assertTrue(patientsactivity.comparePatientFirstName());
            assertTrue(patientsactivity.comparePatientMiddleName());
            assertTrue(patientsactivity.comparePatientLastName());
            //assertTrue(patientsactivity.comparePatientBirthday());
            assertTrue(patientsactivity.comparePatientGender());
            assertTrue(patientsactivity.comparePatientInsuranceNumber());
            patientsactivity.swipeToAddress(35);
            assertTrue(patientsactivity.comparePatientAddress());
            assertTrue(patientsactivity.comparePatientPhone());
            assertTrue(patientsactivity.comparePatientEmail());
            patientsactivity.swipeToAnalysis(35);
            assertTrue(patientsactivity.compareBloodTypeGroup());
            assertTrue(patientsactivity.comparePatientRhesus());
            assertTrue(patientsactivity.comparePatientAllergies());
            assertTrue(patientsactivity.comparePatientFamilyDisease());
            assertTrue(patientsactivity.comparePatientComplaints());
            patientsactivity.swipeToShowTheAgreementButton(35);
            patientsactivity.swipeToDiscardButton(5);
            patientsactivity.clickDiscardButton();
        }
}
