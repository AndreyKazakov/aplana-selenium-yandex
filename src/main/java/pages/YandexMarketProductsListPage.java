package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;
import util.TestProperties;

import java.time.Duration;
import java.util.List;

import static steps.AbstractStepHolder.setVariable;

public class YandexMarketProductsListPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class,'headline__header')]/h1[contains(@class,'title')]")
    WebElement pageHeader;

    @FindBy(xpath = "//div[contains(@class,'view-switcher')]//span[contains(@class,'view-switcher__item_type_list')]/parent::label")
    WebElement btnListView;

    @FindBy(xpath = "//span[text()='Все фильтры']/parent::a")
    WebElement btnAllFilters;

    @FindBy(xpath = "//div[contains(@class,'search-results')]//div[contains(@class,'n-snippet-list')]/child::div//div[contains(@class,'title')]/a")
    List<WebElement> productsTitlesList;

    public YandexMarketProductsListPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void checkHeaderContainsText(String text) {
        Assert.assertTrue(String.format("Заголовок - [%s] - не содержит текст - [%s]", pageHeader.getText(), text), pageHeader.getText().contains(text));
    }

    public void clickButtonAllFilters() {
        moveToElementByJS(btnAllFilters);
        btnAllFilters.click();
    }

    public void clickButtonListView() {
        btnListView.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void checkCountOfProductsMoreThanValue(String value) {
        new WebDriverWait(BaseSteps.getDriver(), Integer.parseInt(TestProperties.getInstance().getProperties().getProperty("defaultTimeout")))
                .until(ExpectedConditions.visibilityOfAllElements(productsTitlesList));
        try {
            Assert.assertTrue(String.format("Количество продуктов не больше [%s]. Получено [%s]", Integer.parseInt(value), productsTitlesList.size()), productsTitlesList.size() > Integer.parseInt(value));
        } catch (NumberFormatException e) {
            Assert.fail("Введено некорректное значение для сравнения с количеством продуктов");
        }
    }

    public void checkCountOfProductsEqualToValue(String value) {
        new WebDriverWait(BaseSteps.getDriver(), Integer.parseInt(TestProperties.getInstance().getProperties().getProperty("defaultTimeout")))
                .until(ExpectedConditions.visibilityOfAllElements(productsTitlesList));
        try {
            Assert.assertTrue(String.format("Количество продуктов не равно [%s]. Получено [%s]", Integer.parseInt(value), productsTitlesList.size()), productsTitlesList.size() == Integer.parseInt(value));
        } catch (NumberFormatException e) {
            Assert.fail("Введено некорректное значение для сравнения с количеством продуктов");
        }
    }

    public void saveProductTitleIntoVariable(String number, String variable) {
        try {
            String title = productsTitlesList.get(Integer.parseInt(number) - 1).getText();
            setVariable(variable, title);
        } catch (NumberFormatException e) {
            Assert.fail("Введено некорректное значение номера продукта");
        }

    }

    public void checkFirstProductTitle(String text) {
        Assert.assertTrue(String.format("Имя первого продукта в списке - [%s] - не содержит текст [%s]", productsTitlesList.get(0).getText(), text), productsTitlesList.get(0).getText().contains(text));
    }
}
