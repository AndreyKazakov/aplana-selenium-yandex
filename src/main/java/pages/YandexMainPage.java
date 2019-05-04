package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

public class YandexMainPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class,'home-tabs') and @role='navigation']")
    WebElement subServicesMenu;

    public YandexMainPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void selectSubServicesMenuItem(String menuItem) {
        subServicesMenu.findElement(By.xpath("./a[text()='"+menuItem+"']")).click();
    }

}
