package com.gmail.igorvodinov;

import com.codeborne.selenide.Configuration;
import com.gmail.igorvodinov.pages.RegistrationPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationWithPageObjectsTests {

    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void BrowserSize() {
        Configuration.browserSize = "1920x3072";
    }

    @Test
    void fillFormTest() {
        registrationPage.openPage();

        registrationPage.typeFirstName("Alex");
        registrationPage.typeLastName("Egorov");
        $("#userEmail").setValue("alex@egorov.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("1231231231");
//        registrationPage.calendarComponent.setDate("30", "July", "2008");
        registrationPage.setBirthDate("30", "July", "2008");
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();

        $("#uploadPicture").uploadFile(new File("src/test/resources/img/1.png"));
        $("#uploadPicture").uploadFromClasspath("img/1.png");

        $("#currentAddress").setValue("Some street 1");

        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Noida")).scrollTo().click();


        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        registrationPage.checkResultsValue("Student Name" , "Alex Egorov")
                .checkResultsValue("Student Name" , "Alex Egorov")
                .checkResultsValue("Student Name" , "Alex Egorov")
                .checkResultsValue("Student Name" , "Alex Egorov");
    }
}

