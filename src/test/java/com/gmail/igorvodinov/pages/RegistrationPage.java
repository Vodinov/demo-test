package com.gmail.igorvodinov.pages;

import com.codeborne.selenide.SelenideElement;
import com.gmail.igorvodinov.pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            resultsTable = $(".table-responsive");

    public CalendarComponent calendarComponent = new CalendarComponent();


    public RegistrationPage openPage() {
        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Registration Form"));

        return this;
    }

    public RegistrationPage typeFirstName(String value){
        firstNameInput.setValue(value);

        return this;
    }
    public RegistrationPage typeLastName(String value){
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setBirthDate(String day , String month , String year){
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage checkResultsValue(String key, String value) {
        resultsTable.$(byText(key))
                .parent().shouldHave(text(value));

        return this;
    }
}