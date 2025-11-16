package ru.neoflex;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class SearchTests {

    @Test
    void successfulSearchTest() {
        open("https://duckduckgo.com/");
        $("[id=searchbox_input]").setValue("yandex").pressEnter();
        $("[id=r1-1]").shouldHave(text("yandex.com"));
    }
}