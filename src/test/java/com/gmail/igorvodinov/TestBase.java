package com.gmail.igorvodinov;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    @BeforeAll
    static void BrowserSize() {
        Configuration.browserSize = "1920x3072";
    }

}
