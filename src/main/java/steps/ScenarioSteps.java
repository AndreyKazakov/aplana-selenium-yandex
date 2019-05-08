package steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.YandexMainPage;

public class ScenarioSteps {

    BaseSteps baseSteps = new BaseSteps();
    YandexMainPageSteps yandexMainPageSteps = new YandexMainPageSteps();
    YandexMarketLandingPageSteps yandexMarketLandingPageSteps = new YandexMarketLandingPageSteps();
    YandexMarketElectronicsPageSteps yandexMarketElectronicsPageSteps = new YandexMarketElectronicsPageSteps();

    @When("^выполнен переход на главную страницу$")
    public void stepGoToMainPage(){
        baseSteps.stepGoToMainPage();
    }

    @When("^выбирается пункт верхнего меню Яндекс сервисов: \"(.*)\"$")
    public void stepSelectSubServicesMenuItem(String menuItem) {
        yandexMainPageSteps.stepSelectSubServicesMenuItem(menuItem);
    }

    @When("^выбирается пункт верхнего меню категорий товаров: \"(.*)\"$")
    public void stepSelectCategoriesTopMenuItem(String menuItem) {
        yandexMarketLandingPageSteps.stepSelectCategoriesTopMenuItem(menuItem);
    }

    @When("^в боковом левом меню для пункта \"(.*)\" выбран подпункт \"(.*)\"$")
    public void stepSelectLeftSubMenuItem(String menuItem, String subMenuItem){
        yandexMarketElectronicsPageSteps.stepSelectLeftSubMenuItem(menuItem, subMenuItem);
    }

    @Then("^выполнен скриншот текущего окна$")
    public void stepTakeScreenshot() {
        baseSteps.stepTakeScreenshot();
    }

    @When("^приостановлено выполнение на \"(.*)\" секунд$")
    public void stepStopExecution(int timeout) {
        baseSteps.stepStopExecution(timeout);
    }

}
