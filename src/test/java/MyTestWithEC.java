import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class MyTestWithEC {

    private String YA_URL = "https://ya.ru/",
            siteName = "Кинопоиск",
            checkTextYa = "kinopoisk.ru",
            filterByText = "Кинопоиск — Википедия",
            checkFilter = "ru.wikipedia.org";
    private SelenideElement inputYa = $("[name=text]"),
            searchResaltYa = $("[data-cid='0']");
    private ElementsCollection searchYaRes = $$("[data-fast='1'] b");

    @Test
    void successfulSearchTestGoogle() {
        openSite(YA_URL);
        search(inputYa, siteName);
        checkResult(searchResaltYa, checkTextYa);
        checkFilter(searchYaRes, siteName);
        checkFind(searchYaRes, filterByText, checkFilter);
    }

    private void openSite(String url) {
        open(url);
    }

    private void search(SelenideElement locator, String value) {
        locator.setValue(value).pressEnter();
    }

    private void checkResult(SelenideElement locator, String checkText) {
        locator.shouldHave(text(checkText));
    }

    private void checkFilter(ElementsCollection locator, String text) {
        locator.filterBy(text(text)).shouldHave(CollectionCondition.sizeNotEqual(0));
    }

    private void checkFind(ElementsCollection locator, String find, String text) {
        locator.findBy(text(find)).shouldHave(text(text));
    }
}
