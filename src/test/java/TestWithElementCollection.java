import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;

public class TestWithElementCollection {
    private final static String URL = "https://ru.wikipedia.org/wiki/Java";

    @Test
    public void openAllHrefs() {
        Selenide.open(URL);
        ElementsCollection hrefs = $$x("//div[@id='toc']//a[@href]");
        List<String> links = new ArrayList<>();
        //Часть 1 создание списка ссылок в масиве
        // 1 первый способ через цикл FOR
//        for(int i=0; i< hrefs.size(); i++) {
//            links.add(hrefs.get(i).getAttribute("href"));
//        }
        //2 через FOREACH перебираются SelenidElement
//        for (SelenideElement element : hrefs) {
//            links.add(element.getAttribute("href"));
//        }
        //3 через stream API
        hrefs.stream().forEach(x->links.add(x.getAttribute("href")));

        // Часть 2 открытие последовательно всех ссылок из коллекции
        // 1
        links.forEach(Selenide::open); // links.forEach(x->Selenide.open(x));

        //2 открытие и сравнение
        for (int i=0; i< links.size(); i++) {
            String listUrl = links.get(i);
            Selenide.open(listUrl);
            String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
            Assertions.assertEquals(currentUrl,listUrl);
        }

        int a=0;
    }
}
