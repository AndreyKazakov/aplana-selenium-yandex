package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

import java.util.List;

public class YandexMarketElectronicsPage extends BasePage {

    @FindBy(xpath = "//div[@data-apiary-widget-name='@MarketNode/NavigationTree']//div[contains(@class,'section')]/div/div/div/div[1]/a")
    List<WebElement> leftMenu;

    public YandexMarketElectronicsPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }


    public void selectLeftSubMenuItem(String menuItem, String subMenuItem) {
        for (WebElement element: leftMenu){
            if (menuItem.equals(element.getText())) {
                List<WebElement> subMenu = element.findElements(By.xpath("./parent::div/following-sibling::div//a"));
                for (WebElement subElement: subMenu) {
                    if (subMenuItem.equals(subElement.getText())) {
                        subElement.click();
                        return;
                    }
                }
                Assert.fail(String.format("В подменю [%s] не найден пункт [%s]", element.getText(), subMenuItem));;
            }
        }
        Assert.fail(String.format("В боковом левом меню не найден пункт [%s]", menuItem));
    }


}
