package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;
import util.TestProperties;

import java.time.Duration;
import java.util.List;

public class YandexMarketAllFiltersPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class,'headline')]//h1[contains(@class,'title')]")
    WebElement pageHeader;

    @FindBy(xpath = "//input[@id='glf-pricefrom-var']")
    WebElement priceFrom;

    @FindBy(xpath = "//input[@id='glf-priceto-var']")
    WebElement priceTo;

    @FindBy(xpath = "//span[text()='Производитель']/ancestor::div[contains(@class,'block__header')]/following-sibling::div//div[contains(@class,'list-items')]//label")
    List<WebElement> producersList;

    @FindBy(xpath = "//a[contains(@class,'show-filtered')]")
    WebElement btnShowFiltered;

    public YandexMarketAllFiltersPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
        WebDriverWait wait = new WebDriverWait(BaseSteps.getDriver(), Integer.parseInt(TestProperties.getInstance().getProperties().getProperty("defaultTimeout")));
        wait.pollingEvery(Duration.ofSeconds(1));
        wait.withMessage("Заголовок не появился на странице Все фильтры");
        wait.until(ExpectedConditions.visibilityOf(pageHeader));
    }

    public void fillTextField(String fieldName, String value) {
        switch (fieldName) {
            case "Цена От":
                fillTextField(priceFrom, value);
                break;
            case "Цена До":
                fillTextField(priceTo, value);
                break;
            default: throw new AssertionError("Поле '"+fieldName+"' не объявлено на странице");
        }
    }

    public void selectProducers(List<String> values) {
        for (String value: values){
            boolean isChecked = false;
            for (WebElement element : producersList){
                if (element.getText().toLowerCase().equals(value.trim().toLowerCase())) {
                    WebElement checkbox = element.findElement(By.xpath("./preceding-sibling::span/input[@type='checkbox']"));
                    JavascriptExecutor js = (JavascriptExecutor)BaseSteps.getDriver();
                    js.executeScript("arguments[0].click();", checkbox);
                    isChecked = true;
                    break;
                }
            }
            if (!isChecked) {
                Assert.fail(String.format("Не найдено значение [%s] в списке производителей", value));
            }
        }
    }

    public void clickButtonShowFiltered() {
        moveToElementByJS(btnShowFiltered);
        btnShowFiltered.click();
    }

}
