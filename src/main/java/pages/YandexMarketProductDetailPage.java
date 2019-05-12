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

public class YandexMarketProductDetailPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class,'product-title')]//h1[contains(@class,'title')]")
    WebElement pageHeader;

    public YandexMarketProductDetailPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
        WebDriverWait wait = new WebDriverWait(BaseSteps.getDriver(), Integer.parseInt(TestProperties.getInstance().getProperties().getProperty("customTimeout")));
        wait.pollingEvery(Duration.ofSeconds(1));
        wait.withMessage("Заголовок не появился на детальной странице товара");
        wait.until(ExpectedConditions.visibilityOf(pageHeader));
    }

    public void checkHeaderContainsText(String text){
        Assert.assertTrue(String.format("Заголовок - [%s] - не содержит текст - [%s]", pageHeader.getText(), text), pageHeader.getText().contains(text));
    }
}
