package steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.YandexMainPage;
import pages.YandexMarketAllFiltersPage;
import util.TestProperties;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static steps.AbstractStepHolder.evalVariable;

public class ScenarioSteps {

    BaseSteps baseSteps = new BaseSteps();
    YandexMainPageSteps yandexMainPageSteps = new YandexMainPageSteps();
    YandexMarketLandingPageSteps yandexMarketLandingPageSteps = new YandexMarketLandingPageSteps();
    YandexMarketElectronicsPageSteps yandexMarketElectronicsPageSteps = new YandexMarketElectronicsPageSteps();
    YandexMarketProductsListPageSteps yandexMarketProductsListPageSteps = new YandexMarketProductsListPageSteps();
    YandexMarketAllFiltersPageSteps yandexMarketAllFiltersPageSteps = new YandexMarketAllFiltersPageSteps();
    YandexMarketProductDetailPageSteps yandexMarketProductDetailPageSteps = new YandexMarketProductDetailPageSteps();

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

    @Then("^заголовок страницы Список продуктов содержит текст \"(.*)\"$")
    public void stepCheckHeaderContainsText(String text) {
        yandexMarketProductsListPageSteps.stepCheckHeaderContainsText(text);
    }

    @When("^выполнено нажатие на кнопку - Все фильтры$")
    public void stepClickButtonAllFilters(){
        yandexMarketProductsListPageSteps.stepClickButtonAllFilters();
    }

    @When("^поле \"(.*)\" заполняется значением \"(.*)\"$")
    public void stepFillTextField(String fieldName, String value){
        yandexMarketAllFiltersPageSteps.stepFillTextField(fieldName, value);
    }

    @When("^выбираются производители: \"(.*)\"$")
    public void stepSelectProducers(List<String> values){
        yandexMarketAllFiltersPageSteps.stepSelectProducers(values);
    }

    @When("^выполнено нажатие на кнопку - Показать подходящие$")
    public void stepClickButtonShowFiltered() {
        yandexMarketAllFiltersPageSteps.stepClickButtonShowFiltered();
    }

    @When("^выполнено нажатие на кнопку - Показывать списком$")
    public void stepClickButtonListView() {
        yandexMarketProductsListPageSteps.stepClickButtonListView();
    }

    @Then("^количество продуктов больше \"(.*)\"$")
    public void stepCheckCountOfProductsMoreThanValue(String value) {
        yandexMarketProductsListPageSteps.stepCheckCountOfProductsMoreThanValue(value);
    }

    @Then("^количество продуктов равно \"(.*)\"$")
    public void stepCheckCountOfProductsEqualToValue(String value) {
        yandexMarketProductsListPageSteps.stepCheckCountOfProductsEqualToValue(value);
    }

    @When("^выполнен поиск по ключевым словам \"(.*)\"$")
    public void stepSearchByKeyword(String keyword) {
        keyword = evalVariable(keyword);
        yandexMarketLandingPageSteps.stepSearchByKeyword(keyword);
    }

    @When("^имя \"(.*)\"-го продукта в списке сохранено в переменную \"(.*)\"$")
    public void stepSaveProductTitleIntoVariable(String number, String variable){
        yandexMarketProductsListPageSteps.stepSaveProductTitleIntoVariable(number, variable);
    }

    @Then("^заголовок Детальной страницы продукта содержит текст \"(.*)\"$")
    public void stepCheckDetailPageHeaderContainsText(String text) {
        text = evalVariable(text);
        yandexMarketProductDetailPageSteps.stepCheckHeaderContainsText(text);
    }

    @Then("^имя найденного продукта содержит текст \"(.*)\"$")
    public void stepCheckFoundProductHeaderContainsText(String text) {
        text = evalVariable(text);
        try {
            BaseSteps.getDriver().manage().timeouts().implicitlyWait(Integer.parseInt(TestProperties.getInstance().getProperties().getProperty("customTimeout")), TimeUnit.SECONDS);
            yandexMarketProductDetailPageSteps.stepCheckHeaderContainsText(text);
        } catch (Exception e) {
            BaseSteps.getDriver().manage().timeouts().implicitlyWait(Integer.parseInt(TestProperties.getInstance().getProperties().getProperty("defaultTimeout")), TimeUnit.SECONDS);
            yandexMarketProductsListPageSteps.stepCheckFirstProductTitle(text);
        } finally {
            BaseSteps.getDriver().manage().timeouts().implicitlyWait(Integer.parseInt(TestProperties.getInstance().getProperties().getProperty("defaultTimeout")), TimeUnit.SECONDS);
        }

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
