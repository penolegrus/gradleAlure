package Kinopoisk;

import Base.BaseSelenideTest;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class KinoSelenideTest extends BaseSelenideTest {
    @Test
    public void checkFilms(){
        Selenide.open("https://www.kinopoisk.ru/s/");
        $x("//*[@id='find_film']").sendKeys("Сумерки");
        $x("//form[@id='formSearchMain']//input[@value='поиск']").click();
        $$x("//div[@class='search_results search_results_last']//p[@class='name']/a")
                .forEach(x-> System.out.println(x.getText()));
        $x("//div[@class='element most_wanted']//span[@class='year']")
                .shouldHave(Condition.text("2000"));

    }
}
