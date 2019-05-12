package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

import java.util.List;

public class YandexMarketLandingPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class,'interaction_click-navigation-menu')]/following-sibling::div[contains(@class,'tab_type_navigation-menu')]")
    List<WebElement> categoriesTopMenu;

    @FindBy(xpath = "//input[@id='header-search']")
    WebElement searchBar;

    @FindBy(xpath = "//span[text()='Найти']/parent::button[@type='submit']")
    WebElement btnSearch;


    public YandexMarketLandingPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void selectCategoriesTopMenuItem(String menuItem) {
        for (WebElement element: categoriesTopMenu){
            if (menuItem.equals(element.getText())) {
                element.click();
                return;
            }
        }
        Assert.fail(String.format("В меню не найден пункт [%s]", menuItem));
    }

    public void searchByKeyword(String keyword){
        fillTextField(searchBar, keyword);
        btnSearch.click();
    }


}
