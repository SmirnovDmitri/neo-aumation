import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SearchTestYa {
    private String yaUrl = "https://ya.ru/";
    private String siteName = "кинопоиск";
    private SelenideElement inputYa = $("[name=text]");
    private SelenideElement searchResaltYa = $("[data-cid='0']");
    private String checkTextYa = "kinopoisk.ru";

    @Test
    void successfulSearchTestGoogle() {
        openSite(yaUrl);
        search(inputYa, siteName);
        checkResult(searchResaltYa, checkTextYa);
    }

    void openSite(String url) {
        open(url);
    }

    void search(SelenideElement locator, String value) {
        locator.setValue(value).pressEnter();
    }

    void checkResult (SelenideElement locator, String checkText) {
        locator.shouldHave(text(checkText));
    }
}
