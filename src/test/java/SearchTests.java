import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class SearchTests {

    @Test
    void successfulSearchTest() {
        open("https://duckduckgo.com/");
        $("[id=searchbox_input]").setValue("yandex").pressEnter();
        $("[id=r1-1]").shouldHave(text("yandex.com"));
        System.out.println();

    }

    @Test
    void successfulSearchTestGoogle() {
        openSite();
        $("[name=text]").setValue("duckduckgo").pressEnter();
        checkResult();
        System.out.println();
    }

    void openSite() {
        open("https://ya.ru/");
    }

    void checkResult() {
        $("[data-fast=1]").shouldHave(text("duckduckgo.com"));
    }

}

