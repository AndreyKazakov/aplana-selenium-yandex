package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

import java.util.List;

public class YandexMarketProductsListPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class,'headline__header')]/h1[contains(@class,'title')]")
    WebElement pageHeader;

    @FindBy(xpath = "//div[contains(@class,'view-switcher')]//span[contains(@class,'view-switcher__item_type_list')]")
    WebElement buttonListView;

    @FindBy(xpath = "//span[text()='Все фильтры']/parent::a")
    WebElement buttonAllFilters;

    @FindBy(xpath = "//div[contains(@class,'search-results')]//div[contains(@class,'n-snippet-list')]/child::div//div[contains(@class,'title')]/a")
    List<WebElement> productsTitlesList;

    public YandexMarketProductsListPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

}
