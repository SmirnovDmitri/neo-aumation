package ru.neoflex;

import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.ElementsCollection;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class SearchCollectionOn5Page {

    @Test
    void searchOn5PageHabr() {
            // 1 зайти на сайт habr
        open("https://habr.com/ru/feed/");
            // 2 кликнуть по значку поиска, чтобы отобразилась строка ввода
        $("[data-test-id='search-button']").click();
            // 3 ввести значение в строку поиска и нажать enter
        $("input[name=q]").setValue("selenide").pressEnter();
            // 4 в поле навигации по странице кликнуть на кнопку "Туда" последовательно два раза
        $("#pagination-next-page").click();
        $("#pagination-next-page").click();
            // 5 перейти с помощью клика на страницу №5
        $("div[data-test-id='pagination']").$(byTagAndText("a", "5")).click();
            // 6 создать element collection
        ElementsCollection hrefs = $$(".tm-title__link a[href]");
        List<String> links = new ArrayList<>();
        for (int i=0; i< hrefs.size(); i++) {
            links.add(hrefs.get(i).getAttribute("href"));
        }
//         ElementsCollection links = $$("h2.tm-title_h2");
//        int count = $$("h2[]").size();
//        System.out.println(count);
//
//       for (int i = 0; i < links.size(); i++) {
//            String href = links.get(i).getAttribute("href");
//            System.out.println(href);
//        }
        // System.out.println(hrefs);


        //List<String> links = new ArrayList<>();

    }
}
