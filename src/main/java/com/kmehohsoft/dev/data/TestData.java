package com.kmehohsoft.dev.data;
import org.testng.annotations.DataProvider;

public class TestData {

    @DataProvider(name = "UserIDToGetActivationCode")
    public static Object[][] UserIDToGetActivationCode() {

        return new Object[][] {{"3408"}};

    }

    @DataProvider(name = "UserID")
    public static Object[][] UserID() {

        return new Object[][] {{"3408"}};

    }

    @DataProvider(name = "UserIDAndPatientWithVisits")
    public static Object[][] UserIDAndPatientWithVisits() {

        return new Object[][] {{"3408","Richardson Tom"}};

    }

    @DataProvider(name = "UsersPassword")
    public static Object[][] UsersPassword() {

        return new Object[][] {{"1234qwer"}};

    }

    @DataProvider(name = "Languages")
    public static Object[][] Languages() {

        return new Object[][] {{"1","Язык:"},{"2","Language:"},{"3","Sprache:"},{"4","Jazyk:"},{"5","Langue:"},{"2","Language:"}};

    }

    @DataProvider(name = "NewPatientDisease")
    public static Object[][] NewPatientDisease() {

        return new Object[][] {{"Cholera","3408"}};

    }
}
