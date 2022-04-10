package Kinopoisk;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainSearchBarPage extends BasePage {

    @FindBy(xpath = "//a[@aria-label='advanced-search']")
    private WebElement advancedSearchButton;

    public MainSearchBarPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public MainSearchBarPage openMainPage(){
        driver.get("https://www.kinopoisk.ru/");
        return this;
    }

    public AdvancedSearchPage openSearchPage(){
        advancedSearchButton.click();
        return new AdvancedSearchPage(driver);
    }
}
