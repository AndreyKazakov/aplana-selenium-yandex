package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import steps.BaseSteps;

public class BasePage {

    public void fillTextField(WebElement element, String value){
        element.clear();
        element.sendKeys(value);
    }

    public void moveToElementByJS(WebElement element){
        ((JavascriptExecutor) BaseSteps.getDriver()).executeScript("return arguments[0].scrollIntoView(true);", element);
    }
}
