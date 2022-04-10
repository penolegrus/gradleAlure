package Kinopoisk;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class SearchResultPage extends MainSearchBarPage{

    @FindBy(xpath = "//div[@class='element most_wanted']//span[@class='year']")
    private WebElement firstSuggestFilmYear;

    @FindBy(xpath = "//div[@class='search_results search_results_last']//p[@class='name']/a")
    private List<WebElement> filmNames;

    public SearchResultPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public String getFirstYear(){
        return firstSuggestFilmYear.getText();
    }

    public int getFoundFilmsCount(){
        return filmNames.size();
    }

    public List<String> getFoundFilmNames(){
        List<String> names = new ArrayList<>();
        filmNames.forEach(x->names.add(x.getText()));
        return names;
    }

    public SearchResultPage showFilmNames(){
        filmNames.forEach(x-> System.out.println(x.getText()));
        return this;
    }

}
