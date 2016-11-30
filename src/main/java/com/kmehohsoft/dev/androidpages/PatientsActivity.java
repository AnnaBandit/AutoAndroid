package com.kmehohsoft.dev.androidpages;

import com.kmehohsoft.dev.framework.AndroidBasePage;
import com.kmehohsoft.dev.models.Patient;
import com.kmehohsoft.dev.serverside.ERIDataBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.SwipeElementDirection;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PatientsActivity extends AndroidBasePage {

    private Patient patient;

    private String listOfPatientsID = "eri.kmehohsoft.android.tablet:id/patients_listview";
    private String classNameForPatientTextView = "android.widget.TextView";
    private String totalVisitsTextViewID = "eri.kmehohsoft.android.tablet:id/total_visits_text_view";
    private String lastVisitTestViewID = "eri.kmehohsoft.android.tablet:id/last_visit_text_view";
    private String previousVisitsSpinnerID = "eri.kmehohsoft.android.tablet:id/previous_visits_spinner";
    private String listOfPreviousVisitsClass = "android.widget.ListView";
    private String itemOfPreviousVisitsListID = "android:id/text1";
    private String analysisButtonID = "eri.kmehohsoft.android.tablet:id/analysis_button";
    private String addUserTextViewID = "eri.kmehohsoft.android.tablet:id/add";
    private String titleEditTextID = "eri.kmehohsoft.android.tablet:id/title_edit_text";
    private String patientFirstNameTextViewID = "eri.kmehohsoft.android.tablet:id/first_name_text_view";
    private String patientMiddleNameTextViewID = "eri.kmehohsoft.android.tablet:id/middle_name_text_view";
    private String patientLastNameTextViewID = "eri.kmehohsoft.android.tablet:id/last_name_text_view";
    private String patientBirthdayButtonID = "eri.kmehohsoft.android.tablet:id/bday_button";
    private String calendarPickButtonID = "android:id/button1";
    private String radioButtonMaleID = "eri.kmehohsoft.android.tablet:id/radioMale";
    private String radioButtonFemaleID = "eri.kmehohsoft.android.tablet:id/radioFemale";
    private String insuranceEditTextID = "eri.kmehohsoft.android.tablet:id/insurance_edit_text";
    private String addressEditTextID = "eri.kmehohsoft.android.tablet:id/address_1_edit_text";
    private String phoneEditTextID = "eri.kmehohsoft.android.tablet:id/phone_edit_text";
    private String address3EditTextWrapperID = "eri.kmehohsoft.android.tablet:id/address_3_wrapper";
    private String emailEditTextID = "eri.kmehohsoft.android.tablet:id/email_edit_text";
    private String bloodTypeSpinnerID = "eri.kmehohsoft.android.tablet:id/blood_type_spinner";
    private String bloodTypeListClass = "android.widget.ListView";
    private String bloodTypeTextViewID = "android:id/text1";
    private String rhesusTypeSpinnerID = "eri.kmehohsoft.android.tablet:id/rh_type_spinner";
    private String rhesusTypeListViewClass = "android.widget.ListView";
    private String rhesusTextViewID = "android:id/text1";
    private String allergiesEditTextID = "eri.kmehohsoft.android.tablet:id/allergies_edit_text";
    private String familyDiseasesEditTextID = "eri.kmehohsoft.android.tablet:id/family_deases_edit_text";
    private String complaintsEditTextID = "eri.kmehohsoft.android.tablet:id/complaint_edit_text";
    private String diseaseClassImageButtonID = "eri.kmehohsoft.android.tablet:id/expand_class_button";
    private String diseaseBlockFirstItemID = "eri.kmehohsoft.android.tablet:id/disease_block";
    private String diseaseEditTextID = "eri.kmehohsoft.android.tablet:id/disease_class";
    private String diseaseGroupButtonID = "eri.kmehohsoft.android.tablet:id/expand_block_button";
    private String diseaseCodeEditTextID = "eri.kmehohsoft.android.tablet:id/disease_code";
    private String diseaseCodeBlockTextEditID = "eri.kmehohsoft.android.tablet:id/disease_block";
    private String analysisEditTextID = "eri.kmehohsoft.android.tablet:id/disease_code";
    private String reasonEditTextID = "eri.kmehohsoft.android.tablet:id/diagnosis_comment";
    private String addDiagnosisButtonID = "eri.kmehohsoft.android.tablet:id/add_diagnosis_button";
    private String userAgreementCheckBoxID = "eri.kmehohsoft.android.tablet:id/agreement_checkbox";
    //private String analysisLabelID = "eri.kmehohsoft.android.tablet:id/diagnosis_label";
    private String savePatientButtonID = "eri.kmehohsoft.android.tablet:id/btn_save";
    private String showagreementButtonID = "eri.kmehohsoft.android.tablet:id/show_agreement_button";
    private String userAgreementTitleID = "android:id/alertTitle";
    private String closeAgreementButtonID = "android:id/button1";
    private String discardButtonID = "eri.kmehohsoft.android.tablet:id/btn_discard";
    private String editPatientButtonID = "eri.kmehohsoft.android.tablet:id/edit";
    private String patientNameListItemID = "eri.kmehohsoft.android.tablet:id/list_patient_name";
    private String patientBloodTypeTextViewID = "android:id/text1";
    private String patientRhesusTextViewID = "android:id/text1";
    private String patientDiseaseNameTextViewID = "eri.kmehohsoft.android.tablet:id/diagnosis_code_name";
    private String patientDiseaseCommentTextViewID = "eri.kmehohsoft.android.tablet:id/diagnosis_comment_text";

    private String insuranceNumberLabelID = "eri.kmehohsoft.android.tablet:id/insurance_label";
    private String emailLabelID = "eri.kmehohsoft.android.tablet:id/email_label";
    private String analysisLabelID = "eri.kmehohsoft.android.tablet:id/diagnosis_label";
    private String printAndAcknowledgeLabelID = "eri.kmehohsoft.android.tablet:id/agreement_label";

    public PatientsActivity(){
        eriDataBase = new ERIDataBase(settings.getAzureServerName(),settings.getAzureServerDBName(),settings.getAzureServerUserLogin(),settings.getAzureServerUserPassword());
        patient = new Patient();
    }

    private List<String> getListOFPatientsFromApplication(){
        List<String> listofpatientsnames = new ArrayList<String>();

        MobileElement patientslist = (MobileElement)AndroidBasePage.androiddriver.findElementsById(listOfPatientsID).get(0);
        List<MobileElement> listofpatientsitems = patientslist.findElementsByClassName(classNameForPatientTextView);

        for (MobileElement mob: listofpatientsitems){
            listofpatientsnames.add(mob.getText());
        }

        for(String s: listofpatientsnames){
            System.out.println(s);
        }

        return listofpatientsnames;
    }

    private int getOrdinalNumberOfPatientWithVisitsInPatientList(String patientName){
        List<String> listfromapplication = getListOFPatientsFromApplication();
        for (int i = 0; i < listfromapplication.size(); i++){
            if (listfromapplication.get(i).contains(patientName)) return i;
        }

        return 0;
    }
/*
    public boolean checkListOFPatients(String userid){
        List<String> listfromapplication = getListOFPatientsFromApplication();
        List<String> listfromdb = eriDataBase.getListOFUserPatients(Integer.parseInt(userid));
        boolean patientnamepresent = false;

        for (int i = 0; i < listfromdb.size(); i++){
            for (int j = 0; j < listfromapplication.size(); j++){
                if (listfromdb.get(i).contains(listfromapplication.get(j))){
                    patientnamepresent = true;

                }
            }

            if (!patientnamepresent) return false;
            patientnamepresent = false;
        }

         return true;
    }*/

    public boolean checkListOFPatients(String userid){
        List<String> listfromapplication = getListOFPatientsFromApplication();
        List<String> listfromdb = eriDataBase.getListOFUserPatients(Integer.parseInt(userid));

        if (listfromdb.size()!=listfromapplication.size()) {
            return false;
        }

        for (String patientFromApp: listfromapplication) {
            if (!elementContainsInList(patientFromApp, listfromdb)){
                return false;
            }
        }
        return true;
    }

    private boolean elementContainsInList(String s, List<String> listOfPatients){
        for (String patient: listOfPatients) {
            if (patient.contains(s)){
                return true;
            }
        }
        return false;
    }


    private String getFirstInListPatientWithVisitsName(int userid,String patientName){
        if (eriDataBase.checkIfUserHasPatients(userid)) {
            MobileElement patientslist = (MobileElement) AndroidBasePage.androiddriver.findElementsById(listOfPatientsID).get(0);
            return patientslist.findElementsByClassName(classNameForPatientTextView).get(getOrdinalNumberOfPatientWithVisitsInPatientList(patientName)).getText();
        }

        return "";
    }

    private int getFirstInListPatientVisitsNumberInApplication(){
        MobileElement totalvisits = (MobileElement) AndroidBasePage.androiddriver.findElementsById(totalVisitsTextViewID).get(0);
        return Integer.parseInt(totalvisits.getText());
    }

    public boolean checkPatientVisitsNumber(String userid,String patientName){
        if (eriDataBase.checkIfUserHasPatients(Integer.parseInt(userid))) {
            if (eriDataBase.getFirstPatientVisitsNumber(Integer.parseInt(userid), getFirstInListPatientWithVisitsName(Integer.parseInt(userid), patientName)) == getFirstInListPatientVisitsNumberInApplication())
                return true;
        }

        return false;
    }

    public void clickPatientWithVisits(String userid,String patientName){
        if (eriDataBase.checkIfUserHasPatients(Integer.parseInt(userid))){
            MobileElement patientslist = (MobileElement) AndroidBasePage.androiddriver.findElementsById(listOfPatientsID).get(0);
            patientslist.findElementsByClassName(classNameForPatientTextView).get(getOrdinalNumberOfPatientWithVisitsInPatientList(patientName)).tap(1,500);

        }
    }

    public void clickFirstInListPatientWithVisits(String userid){
        if (eriDataBase.checkIfUserHasPatients(Integer.parseInt(userid))){
            MobileElement patientslist = (MobileElement) AndroidBasePage.androiddriver.findElementsById(listOfPatientsID).get(0);
            patientslist.findElementsByClassName(classNameForPatientTextView).get(4).tap(1,500);
        }
    }

    public void clickFirstInListPatientWithName(String name){
        List<MobileElement> patientslist = AndroidBasePage.androiddriver.findElementsById(listOfPatientsID);
        for (MobileElement mob: patientslist) {
            if (mob.getText().contains(name)) {
                mob.click();
            }
        }
    }

    public String getPatientLastName(){
        return patient.getLastName();
    }

    private String getFirstInListPatientLastDateInApplication(){
        MobileElement lastvisit = (MobileElement) AndroidBasePage.androiddriver.findElementsById(lastVisitTestViewID).get(0);
        return lastvisit.getText();
    }

    public boolean checkPatientLastVisitDate(String userid,String patientName){
        if (eriDataBase.checkIfUserHasPatients(Integer.parseInt(userid))){
            if (eriDataBase.getFirstPatientLastVisitDate(Integer.parseInt(userid),getFirstInListPatientWithVisitsName(Integer.parseInt(userid), patientName)).contains(getFirstInListPatientLastDateInApplication()))
                return true;
        }
        return false;
    }

    private int openPreviousVisitsListAndGetNumberOfItems(String userid){
        int numberOfPreviousListItems = 0;
        MobileElement previousvisits = (MobileElement) AndroidBasePage.androiddriver.findElementsById(previousVisitsSpinnerID).get(0);
        previousvisits.tap(1,5);
        MobileElement previousvisitslist = (MobileElement)AndroidBasePage.androiddriver.findElementsByClassName(listOfPreviousVisitsClass).get(0);
        numberOfPreviousListItems = previousvisitslist.findElementsById(itemOfPreviousVisitsListID).size();
        previousvisitslist = (MobileElement)AndroidBasePage.androiddriver.findElementsByClassName(listOfPreviousVisitsClass).get(0);
        previousvisitslist.findElementsById(itemOfPreviousVisitsListID).get(0).tap(1,5);
        return numberOfPreviousListItems;
    }

    public boolean checkPatientPreviousListItemsNumber(String userid,String patientName){
        if (eriDataBase.checkIfUserHasPatients(Integer.parseInt(userid))){
            if (eriDataBase.getFirstPatientVisitsNumber(Integer.parseInt(userid), getFirstInListPatientWithVisitsName(Integer.parseInt(userid),patientName)) == openPreviousVisitsListAndGetNumberOfItems(userid))
                return true;
        }

        return false;
    }

    public void clickFirstItemInPreviousVisitsList(){
        MobileElement previousvisits = (MobileElement) AndroidBasePage.androiddriver.findElementsById(previousVisitsSpinnerID).get(0);
        previousvisits.tap(1,5);
        MobileElement previousvisitslist = (MobileElement)AndroidBasePage.androiddriver.findElementsByClassName(listOfPreviousVisitsClass).get(0);
        previousvisitslist.findElementsById(itemOfPreviousVisitsListID).get(0).tap(1,5);
    }

    public boolean checkIfAnalysisButtonEnabled(){
        MobileElement analysisButton = (MobileElement) AndroidBasePage.androiddriver.findElementsById(analysisButtonID).get(0);
        return analysisButton.isEnabled();
    }

    public void openNewPatientPage(){
        MobileElement newPatient = (MobileElement) AndroidBasePage.androiddriver.findElementsById(addUserTextViewID).get(0);
        newPatient.tap(1,200);
    }

    private void chooseGender(boolean gender){
        if (gender){
            MobileElement maleradio  = (MobileElement) AndroidBasePage.androiddriver.findElementsById(radioButtonMaleID).get(0);
            maleradio.tap(1, 5);
        }else{
            MobileElement femaleradio  = (MobileElement) AndroidBasePage.androiddriver.findElementsById(radioButtonFemaleID).get(0);
            femaleradio.tap(1,5);
        }
    }

    private void swipeToAnalysisOfDisease(int swipeTimes){
        MobileElement address3  = (MobileElement) AndroidBasePage.androiddriver.findElementsById(address3EditTextWrapperID).get(0);
        for (int i =0; i < swipeTimes; i++)
            address3.swipe(SwipeElementDirection.UP, 2000);
    }

    public void swipeToAddress(int swipeTimes){
        MobileElement analysislabel  = (MobileElement) AndroidBasePage.androiddriver.findElementsById(insuranceNumberLabelID).get(0);
        for (int i= 0; i< swipeTimes; i++)
            analysislabel.swipe(SwipeElementDirection.UP, 2000);
    }

    public void swipeToAnalysis(int swipeTimes){
        MobileElement analysislabel  = (MobileElement) AndroidBasePage.androiddriver.findElementsById(emailLabelID).get(0);
        for (int i= 0; i< swipeTimes; i++)
            analysislabel.swipe(SwipeElementDirection.UP, 2000);
    }

    public void swipeToShowTheAgreementButton(int swipeTimes){
        MobileElement analysislabel  = (MobileElement) AndroidBasePage.androiddriver.findElementsById(analysisLabelID).get(0);
        for (int i= 0; i< swipeTimes; i++)
            analysislabel.swipe(SwipeElementDirection.UP, 2000);
    }

    public void swipeToDiscardButton(int swipeTimes){
        MobileElement reasonTextField  = (MobileElement) AndroidBasePage.androiddriver.findElementsById(reasonEditTextID).get(0);
        for (int i= 0; i< swipeTimes; i++)
            reasonTextField.swipe(SwipeElementDirection.UP, 2000);
    }

    private void setBloodType(String bloodType){
        MobileElement bloodtype  = (MobileElement) AndroidBasePage.androiddriver.findElementsById(bloodTypeSpinnerID).get(0);
        bloodtype.tap(1, 5);
        MobileElement bloodtypelist  = (MobileElement) AndroidBasePage.androiddriver.findElementsByClassName(bloodTypeListClass).get(0);
        List<MobileElement> test = bloodtypelist.findElementsById(bloodTypeTextViewID);
        for (MobileElement mob: test) {
            if (mob.getText().equals(bloodType)){
                mob.tap(1, 5);
            }
        }
    }

    private void chooseRhesusType(int rhesus){
        MobileElement rhesustype  = (MobileElement) AndroidBasePage.androiddriver.findElementsById(rhesusTypeSpinnerID).get(0);
        rhesustype.tap(1, 5);
        MobileElement rhesustypelist  = (MobileElement) AndroidBasePage.androiddriver.findElementsByClassName(rhesusTypeListViewClass).get(0);
        rhesustypelist.findElementsById(rhesusTextViewID).get(rhesus).tap(1, 5);
    }

    private int boolToInt(Boolean b) {
        return b.compareTo(false);
    }

    private void enterPatientTitle(String Title){
        MobileElement title = (MobileElement) AndroidBasePage.androiddriver.findElementsById(titleEditTextID).get(0);
        title.clear();
        title.sendKeys(Title);
    }

    private void enterPatientFirstName(String fname){
        MobileElement firstname = (MobileElement) AndroidBasePage.androiddriver.findElementsById(patientFirstNameTextViewID).get(0);
        firstname.clear();
        firstname.sendKeys(fname);
    }

    private void enterPatientMiddleName(String mname){
        MobileElement middlename = (MobileElement) AndroidBasePage.androiddriver.findElementsById(patientMiddleNameTextViewID).get(0);
        middlename.clear();
        middlename.sendKeys(mname);
    }

    private void enterPatientLastName(String lname){
        MobileElement lastname = (MobileElement) AndroidBasePage.androiddriver.findElementsById(patientLastNameTextViewID).get(0);
        lastname.clear();
        lastname.sendKeys(lname);
    }

    private void choosePatientBirthday(){
        MobileElement birthdaybutton  = (MobileElement) AndroidBasePage.androiddriver.findElementsById(patientBirthdayButtonID).get(0);
        birthdaybutton.tap(1, 5);
        MobileElement calendar  = (MobileElement) AndroidBasePage.androiddriver.findElementsById(calendarPickButtonID).get(0);
        calendar.tap(1, 5);
    }

    private String getSetPatientBirthday(){
        MobileElement birthdaybutton  = (MobileElement) AndroidBasePage.androiddriver.findElementsById(patientBirthdayButtonID).get(0);
        return birthdaybutton.getText();
    }

    private void enterPatientInsuranceNumber(String Insurance){
        MobileElement insurance  = (MobileElement) AndroidBasePage.androiddriver.findElementsById(insuranceEditTextID).get(0);
        insurance.clear();
        insurance.sendKeys(Insurance);
    }

    private void enterPatientAddress(String Address){
        MobileElement address  = (MobileElement) AndroidBasePage.androiddriver.findElementsById(addressEditTextID).get(0);
        address.clear();
        address.sendKeys(Address);
    }

    private void enterPatientPhone(String Phone){
        MobileElement phone  = (MobileElement) AndroidBasePage.androiddriver.findElementsById(phoneEditTextID).get(0);
        phone.clear();
        phone.sendKeys(Phone);
    }

    private void enterPatientEmail(String Email){
        MobileElement email  = (MobileElement) AndroidBasePage.androiddriver.findElementsById(emailEditTextID).get(0);
        email.clear();
        email.sendKeys(Email);
    }

    private void enterPatientAllergies(String Allergies){
        MobileElement allergy  = (MobileElement) AndroidBasePage.androiddriver.findElementsById(allergiesEditTextID).get(0);
        allergy.clear();
        allergy.sendKeys(Allergies);
    }

    private void enterPatientFamilyDiseases(String Disease){
        MobileElement disease  = (MobileElement) AndroidBasePage.androiddriver.findElementsById(familyDiseasesEditTextID).get(0);
        disease.clear();
        disease.sendKeys(Disease);
    }

    private void enterPatientComplaints(String Complaints){
        MobileElement complaint  = (MobileElement) AndroidBasePage.androiddriver.findElementsById(complaintsEditTextID).get(0);
        complaint.clear();
        complaint.sendKeys(Complaints);
    }

    private String chooseClassOfPatientDisease(){
        MobileElement classdisease = (MobileElement) AndroidBasePage.androiddriver.findElementsById(diseaseClassImageButtonID).get(0);
        classdisease.tap(1, 5);
        MobileElement diseaseblock = (MobileElement) AndroidBasePage.androiddriver.findElementsById(diseaseBlockFirstItemID).get(0);
        diseaseblock.tap(1,5);
        MobileElement diseasetext = (MobileElement) AndroidBasePage.androiddriver.findElementsById(diseaseEditTextID).get(0);
        return diseasetext.getText();
    }

    private String choosePatientDiseaseGroup(){
        MobileElement diseaseblock = (MobileElement) AndroidBasePage.androiddriver.findElementsById(diseaseGroupButtonID).get(0);
        diseaseblock.tap(1, 5);
        MobileElement diseaselist = (MobileElement) AndroidBasePage.androiddriver.findElementsById(diseaseCodeEditTextID).get(0);
        diseaselist.tap(1,5);
        MobileElement diseaseblocktext = (MobileElement) AndroidBasePage.androiddriver.findElementsById(diseaseCodeBlockTextEditID).get(0);
        return diseaseblocktext.getText();
    }

    private void enterPatientDisease(String Disease){
        MobileElement diseasetext = (MobileElement) AndroidBasePage.androiddriver.findElementsById(analysisEditTextID).get(0);
        diseasetext.sendKeys(Disease);
    }

    private String getPatientDisease(){
        MobileElement diseasetext = (MobileElement) AndroidBasePage.androiddriver.findElementsById(analysisEditTextID).get(0);
        return diseasetext.getText();
    }

    private void enterReasonForRecord(String Reason){
        MobileElement reason  = (MobileElement) AndroidBasePage.androiddriver.findElementsById(reasonEditTextID).get(0);
        reason.clear();
        reason.sendKeys(Reason);
    }

    private void clickAddDiagnosisButton(){
        MobileElement diagnosis  = (MobileElement) AndroidBasePage.androiddriver.findElementsById(addDiagnosisButtonID).get(0);
        diagnosis.tap(1, 5);
    }

    public void clickUserAgreementCheckBox(){
        MobileElement agreement  = (MobileElement) AndroidBasePage.androiddriver.findElementsById(userAgreementCheckBoxID).get(0);
        agreement.tap(1, 5);
    }

   /* private void swipeToDiscardButton(int swipeTimes){
        MobileElement analysislabel  = (MobileElement) AndroidBasePage.androiddriver.findElementsById(analysisLabelID).get(0);
        for (int i= 0; i< swipeTimes; i++)
            analysislabel.swipe(SwipeElementDirection.UP, 2000);
    }*/

    public void clickSavePatientButton(){
        MobileElement save  = (MobileElement) AndroidBasePage.androiddriver.findElementsById(savePatientButtonID).get(0);
        save.tap(1, 5);
    }

    public void fillNewPatientPersonalData(String patientdisease) {
        patient.generatePatientPersonalData();
        enterPatientTitle(patient.getTitle());
        enterPatientFirstName(patient.getFirstName());
        enterPatientMiddleName(patient.getMiddleName());
        enterPatientLastName(patient.getLastName());
        choosePatientBirthday();
        patient.setBirthday(getSetPatientBirthday());
        chooseGender(patient.getGender());
        enterPatientInsuranceNumber(patient.getInsuranceNumber());
        swipeToAddress(35);
        enterPatientAddress(patient.getAddress());
        System.out.println(getPatientGender());
        System.out.println(patient.getGender());
        enterPatientPhone(patient.getPhone());
        enterPatientEmail(patient.getEmail());
        swipeToAnalysis(35);
        setBloodType(patient.getBloodTypeGroup());
        chooseRhesusType(Math.abs(boolToInt(patient.getBloodTypeRhesus())));
        enterPatientAllergies(patient.getAllergies());
        enterPatientFamilyDiseases(patient.getFamilyDiseases());
        enterPatientComplaints(patient.getComplaints());
        swipeToShowTheAgreementButton(35);
        patient.setClassOfDisease(chooseClassOfPatientDisease());
        patient.setGroupOfDisease(choosePatientDiseaseGroup());
        enterPatientDisease(patientdisease);
        enterReasonForRecord(patient.getReasonForRecord());
        patient.setAnalysisOfDiease(getPatientDisease());
        clickAddDiagnosisButton();
        swipeToDiscardButton(10);
    }

    public boolean checkIfNewPatientPresentInList(String  userid){
        if (eriDataBase.checkIfUserHasPatients(Integer.parseInt(userid))) {
            MobileElement patientslist = (MobileElement) AndroidBasePage.androiddriver.findElementsById(listOfPatientsID).get(0);
            List<MobileElement> patientsnames = new ArrayList<MobileElement>();
            patientsnames = patientslist.findElementsByClassName(classNameForPatientTextView);
            for (int i = 0; i < patientsnames.size(); i++) {
                if (patientsnames.get(i).getText().equalsIgnoreCase(patient.getLastName() + " " + patient.getFirstName())) {
                    patientsnames.get(i).tap(1,200);
                    return true;
                }
            }
        }
        return false;
    }

    public void swipeToSaveAndCloseButton(){
        swipeToAddress(35);
        swipeToAnalysis(35);
        swipeToShowTheAgreementButton(35);
        swipeToDiscardButton(10);
    }

    public boolean checkIfSavaAndCloseButtonEnabled(){
        MobileElement save  = (MobileElement) AndroidBasePage.androiddriver.findElementsById(savePatientButtonID).get(0);
        return save.isEnabled();
    }

    public void clickShowAgreementButton(){
        MobileElement agreement  = (MobileElement) AndroidBasePage.androiddriver.findElementsById(showagreementButtonID).get(0);
        agreement.tap(1,5);
    }

    public void clickDiscardButton(){
        MobileElement discardbutton  = (MobileElement) AndroidBasePage.androiddriver.findElementsById(discardButtonID).get(0);
        discardbutton.tap(1, 5);
    }

    public boolean checkIfUserAgreementPresentAndCloseIt(){
        boolean presentAgreement = false;
        MobileElement agreementtitle  = (MobileElement) AndroidBasePage.androiddriver.findElementsById(userAgreementTitleID).get(0);
        MobileElement closeagreement  = (MobileElement) AndroidBasePage.androiddriver.findElementsById(closeAgreementButtonID).get(0);
        presentAgreement = agreementtitle.isDisplayed();
        closeagreement.tap(1, 5);
        clickDiscardButton();
        return presentAgreement;
    }

    public void fillNewPatientMandatoryFields(){
        patient.generatePatientPersonalData();
        enterPatientFirstName(patient.getFirstName());
        enterPatientLastName(patient.getLastName());
        choosePatientBirthday();
    }

    public void clickPatientEditButton(){
        MobileElement editpatient  = (MobileElement) AndroidBasePage.androiddriver.findElementsById(editPatientButtonID).get(0);
        editpatient.tap(1, 200);
    }

    private String getPatientTitle(){
        MobileElement title = (MobileElement)AndroidBasePage.androiddriver.findElementsById(titleEditTextID).get(0);
        return title.getText();
    }

    private String getPatientFirstName(){
        MobileElement firstname = (MobileElement) AndroidBasePage.androiddriver.findElementsById(patientFirstNameTextViewID).get(0);
        return firstname.getText();
    }

    private String getPatientMiddleName(){
        MobileElement middlename = (MobileElement) AndroidBasePage.androiddriver.findElementsById(patientMiddleNameTextViewID).get(0);
        return middlename.getText();
    }
/*
    private String getPatientLastName(){
        MobileElement lastname = (MobileElement) AndroidBasePage.androiddriver.findElementsById(patientLastNameTextViewID).get(0);
        return lastname.getText();
    }
*/
    private String getPatientBirthday(){
        MobileElement birthdaybutton  = (MobileElement) AndroidBasePage.androiddriver.findElementsById(patientBirthdayButtonID).get(0);
        return birthdaybutton.getText();
    }

    private boolean getPatientGender(){
        MobileElement maleradio  = (MobileElement) AndroidBasePage.androiddriver.findElementsById(radioButtonMaleID).get(0);
        return maleradio.isSelected();
    }

    private String getPatientInsuranceNumber(){
        MobileElement insurance  = (MobileElement) AndroidBasePage.androiddriver.findElementsById(insuranceEditTextID).get(0);
        return insurance.getText();
    }

    private String getPatientAddress(){
        MobileElement address  = (MobileElement) AndroidBasePage.androiddriver.findElementsById(addressEditTextID).get(0);
        return address.getText();
    }

    private String getPatientPhone(){
        MobileElement phone  = (MobileElement) AndroidBasePage.androiddriver.findElementsById(phoneEditTextID).get(0);
        return phone.getText();
    }

    private String getPatientEmail(){
        MobileElement email  = (MobileElement) AndroidBasePage.androiddriver.findElementsById(emailEditTextID).get(0);
        return email.getText();
    }

    /*private byte getPatientBloodTypeGroup(){
        String bloodTypes[] = {"0","A","B","AB"};
        MobileElement bloodtype  = (MobileElement) AndroidBasePage.androiddriver.findElementsById(patientBloodTypeTextViewID).get(0);
        String bloodType = bloodtype.getText();
        byte i = 0;
        for (; i < bloodTypes.length; i++) {
            if (bloodTypes[i].equalsIgnoreCase(bloodType)) return i;
        }
        return i;
    }*/

    private String getPatientBloodTypeGroup(){
        String bloodTypes[] = {"0","A","B","AB"};
        Random myRandom = new Random();
        return bloodTypes[myRandom.nextInt(bloodTypes.length)];
    }

    private boolean getPatientRhesus(){
        MobileElement rhesustype  = (MobileElement) AndroidBasePage.androiddriver.findElementsById(patientRhesusTextViewID).get(1);
        return (rhesustype.getText().equalsIgnoreCase("Negative"));
    }

    private String getPatientAllergies(){
        MobileElement allergy  = (MobileElement) AndroidBasePage.androiddriver.findElementsById(allergiesEditTextID).get(0);
        return allergy.getText();
    }

    private String getPatientFamilyDiseases(){
        MobileElement disease  = (MobileElement) AndroidBasePage.androiddriver.findElementsById(familyDiseasesEditTextID).get(0);
        return disease.getText();
    }

    private String getPatientComplaints(){
        MobileElement complaint  = (MobileElement) AndroidBasePage.androiddriver.findElementsById(complaintsEditTextID).get(0);
        return complaint.getText();
    }

    private String getPatientDiseaseName(){
        MobileElement disease  = (MobileElement) AndroidBasePage.androiddriver.findElementsById(patientDiseaseNameTextViewID).get(0);
        return disease.getText();
    }

    private String getPatientDiseaseComment(){
        MobileElement comment  = (MobileElement) AndroidBasePage.androiddriver.findElementsById(patientDiseaseCommentTextViewID).get(0);
        return comment.getText();
    }

    public boolean comparePatientDiseaseComment(){
        return (patient.getReasonForRecord().equalsIgnoreCase(getPatientDiseaseComment()));
    }

    public boolean comparePatientDisease(){
        return (getPatientDiseaseName().contains(patient.getAnalysisOfDiease()));
    }

    public boolean comparePatientComplaints(){
        return (patient.getComplaints().equalsIgnoreCase(getPatientComplaints()));
    }

    public boolean comparePatientFamilyDisease(){
        return (patient.getFamilyDiseases().equalsIgnoreCase(getPatientFamilyDiseases()));
    }

    public boolean comparePatientAllergies(){
        return (patient.getAllergies().equalsIgnoreCase(getPatientAllergies()));
    }

    public boolean comparePatientRhesus(){
        return (patient.getBloodTypeRhesus() == getPatientRhesus());
    }

    public boolean compareBloodTypeGroup(){
        System.out.println(patient.getBloodTypeGroup());
        System.out.println(getPatientBloodTypeGroup());
        return patient.getBloodTypeGroup().equals(getPatientBloodTypeGroup());
    }

    public boolean comparePatientEmail(){
        return patient.getEmail().equalsIgnoreCase(getPatientEmail());
    }

    public boolean comparePatientPhone(){
        return patient.getPhone().equalsIgnoreCase(getPatientPhone());
    }

    public boolean comparePatientAddress(){
        return patient.getAddress().equalsIgnoreCase(getPatientAddress());
    }

    public boolean comparePatientInsuranceNumber(){
        return patient.getInsuranceNumber().equalsIgnoreCase(getPatientInsuranceNumber());
    }

    public boolean comparePatientGender(){
        System.out.println("сгенерированый гендер " + patient.getGender() + "; в приложении");
        return patient.getGender() == getPatientGender();
    }

    public boolean comparePatientBirthday(){
        System.out.println(patient.getBirthday() + getPatientBirthday());
        return patient.getBirthday().equalsIgnoreCase(getPatientBirthday());
    }

    public boolean comparePatientMiddleName(){
        return patient.getMiddleName().equalsIgnoreCase(getPatientMiddleName());
    }

    public boolean comparePatientLastName(){
        return patient.getLastName().equalsIgnoreCase(getPatientLastName());
    }

    public boolean comparePatientFirstName(){
        return patient.getFirstName().equalsIgnoreCase(getPatientFirstName());
    }

    public boolean compareUserTitle(){
        return patient.getTitle().equalsIgnoreCase(getPatientTitle());
    }

    public void editExistingPatientPersonalData(){
        patient.generatePatientPersonalData();
        enterPatientTitle(patient.getTitle());
        enterPatientFirstName(patient.getFirstName());
        enterPatientMiddleName(patient.getMiddleName());
        enterPatientLastName(patient.getLastName());
        enterPatientInsuranceNumber(patient.getInsuranceNumber());
        swipeToAddress(35);
        enterPatientAddress(patient.getAddress());
        enterPatientPhone(patient.getPhone());
        enterPatientEmail(patient.getEmail());
        swipeToAnalysis(35);
        enterPatientAllergies(patient.getAllergies());
        enterPatientFamilyDiseases(patient.getFamilyDiseases());
        enterPatientComplaints(patient.getComplaints());
        swipeToShowTheAgreementButton(35);
        swipeToDiscardButton(10);
    }

}
