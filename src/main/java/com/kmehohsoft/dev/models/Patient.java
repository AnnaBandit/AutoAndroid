package com.kmehohsoft.dev.models;


import java.util.Random;

public class Patient {

     private String title;
     private String firstName;
     private String middleName;
     private String lastName;
     private String birthday;
     private boolean gender;
     private String insuranceNumber;
     private String address;
     private String phone;
     private String email;
     private String bloodTypeGroup;
     private boolean bloodTypeRhesus;
     private String allergies;
     private String familyDiseases;
     private String complaints;
     private String classOfDisease;
     private String groupOfDisease ;
     private String analysisOfDiease;
     private String reasonForRecord;
     private final String charList = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
     private final String digitsList = "1234567890";


    public Patient(){
        title = "";
        firstName = "";
        middleName = "";
        lastName = "";
        birthday = "";
        gender = false;
        insuranceNumber = "";
        address = "";
        phone = "";
        email = "";
        bloodTypeGroup = "";
        bloodTypeRhesus = false;
        allergies = "";
        familyDiseases = "";
        complaints = "";
        classOfDisease = "";
        groupOfDisease = "";
        analysisOfDiease = "";
        reasonForRecord = "";
    }

    private int getRandomNumber(String charlist) {
        int randomInt = 0;
        Random randomGenerator = new Random();
        randomInt = randomGenerator.nextInt(charlist.length());
        if (randomInt - 1 == -1) {
            return randomInt;
        } else {
            return randomInt - 1;
        }
    }

    private String generateRandomString(int randomStringLength,String charlist){

        StringBuffer randStr = new StringBuffer();
        for(int i=0; i< randomStringLength; i++){
            int number = getRandomNumber(charlist);
            char ch = charlist.charAt(number);
            randStr.append(ch);
        }
        return randStr.toString();
    }

    private String generateRandomDate(){
        StringBuffer randDate = new StringBuffer();
        Random random = new Random();

        randDate.append(random.nextInt(30 - 1 + 1) + 1);
        randDate.append(".");
        randDate.append(random.nextInt(12 - 1 + 1) + 1);
        randDate.append(".");
        randDate.append(random.nextInt(2015 - 1900 + 1900) + 1900);
        return randDate.toString();
    }

    private String generatePatientBloodTypeGroup(){
        String bloodTypes[] = {"0","A","B","AB"};
        int idx = new Random().nextInt(bloodTypes.length);
        return bloodTypes[idx];
    }

    public void generatePatientPersonalData(){
        Random randomBooleanValue = new Random();
        Random randomIntValue = new Random();
        title = generateRandomString(5,charList);
        firstName = generateRandomString(15,charList);
        middleName = generateRandomString(15,charList);
        lastName = generateRandomString(15, charList);
       // birthday = generateRandomDate();
        gender = randomBooleanValue.nextBoolean();
        insuranceNumber = generateRandomString(10, digitsList);
        address = generateRandomString(30,charList);
        phone = generateRandomString(10,digitsList);
        email = generateRandomString(10,charList) + "@" + generateRandomString(5,charList) + "." + "com";
        bloodTypeGroup = generatePatientBloodTypeGroup();
        bloodTypeRhesus = randomBooleanValue.nextBoolean();
        allergies = generateRandomString(30, charList);
        familyDiseases = generateRandomString(30,charList);
        complaints = generateRandomString(30,charList);
        reasonForRecord = generateRandomString(30,charList);
    }

    public  String getTitle(){
        return title;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getMiddleName(){
        return middleName;
    }

    public String getLastName(){
        return lastName;
    }

    public  boolean getGender(){
        return gender;
    }

    public String getInsuranceNumber(){
        return insuranceNumber;
    }

    public String getAddress(){
        return address;
    }

    public String getPhone(){
        return phone;
    }

    public String getEmail(){
        return email;
    }

    public String getBloodTypeGroup(){
        return bloodTypeGroup;
    }

    public boolean getBloodTypeRhesus(){
        return bloodTypeRhesus;
    }

    public  String getAllergies(){
        return allergies;
    }

    public String getFamilyDiseases(){
        return familyDiseases;
    }

    public String getComplaints(){
        return complaints;
    }

    public String getReasonForRecord(){
        return reasonForRecord;
    }

    public String getClassOfDisease(){
        return classOfDisease;
    }

    public String getGroupOfDisease(){
        return groupOfDisease;
    }

    public String getAnalysisOfDiease(){
        return analysisOfDiease;
    }

    public void setClassOfDisease(String classDisease){
        classOfDisease = classDisease;
    }

    public void setGroupOfDisease(String groupDisease){
        groupOfDisease = groupDisease;
    }

    public void setAnalysisOfDiease(String analysisDiease){
        analysisOfDiease = analysisDiease;
    }

    public void setBirthday(String birthday){
        this.birthday = birthday;
    }

    public void setGender(boolean gender){
        this.gender = gender;
    }

    public String getBirthday(){
        return birthday;
    }

}
