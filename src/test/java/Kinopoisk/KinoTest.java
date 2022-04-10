package Kinopoisk;


import Base.BaseTest;
import Base.TestListener;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;

@ExtendWith(TestListener.class)
public class KinoTest extends BaseTest {

    @Test
    public void checkMovieChain(){
        MainSearchBarPage mainSearchBarPage = new MainSearchBarPage(driver);
        SearchResultPage searchResultPage = mainSearchBarPage.openMainPage()
                .openSearchPage()
                .fillName("Batman")
                .fillYear("2018")
                .fillCountry()
                .findFilm();
        String year = searchResultPage.getFirstYear();
        List<String> filmNames = searchResultPage.getFoundFilmNames();
        int count = searchResultPage.getFoundFilmsCount();
        filmNames.forEach(x-> System.out.println(x));

        Assertions.assertTrue(filmNames.size()!=0);
        Assertions.assertEquals("2018", year);
        Assertions.assertEquals(12, count);
    }

    @Test
    public void bigChain(){
        new MainSearchBarPage(driver).openMainPage()
                .openSearchPage().fillName("Матрица").findFilm().showFilmNames()
                .openSearchPage().fillName("Ёлки").findFilm().showFilmNames()
                .openSearchPage().fillName("Наруто").findFilm().showFilmNames();

    }

    @Test
    @Owner("Олег ThreadQA")
    @Description("Выполняется поиск фильма с заданными параметрами и проверяется что фильмы найдены")
    public void checkMovie(){
        MainSearchBarPage mainSearchBarPage = new MainSearchBarPage(driver);
        mainSearchBarPage.openMainPage();
        mainSearchBarPage.openSearchPage();

        AdvancedSearchPage advancedSearchPage = new AdvancedSearchPage(driver);
        advancedSearchPage.fillName("Spider man");
        advancedSearchPage.fillYear("2019");
        advancedSearchPage.findFilm();

        SearchResultPage searchResultPage = new SearchResultPage(driver);
        List<String> filmNames = searchResultPage.getFoundFilmNames();

        filmNames.forEach(System.out::println);
        Assertions.assertTrue(filmNames.size()!=0);
    }

    @Test
    public void shortTest(){
        Assertions.assertEquals("2018", new MainSearchBarPage(driver).openMainPage()
                .openSearchPage().fillName("Batman").fillYear("2018").fillCountry()
                .findFilm().getFirstYear());

    }
}
