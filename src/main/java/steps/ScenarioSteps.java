package steps;

import cucumber.api.java.en.When;
import pages.YandexMainPage;

public class ScenarioSteps {

    BaseSteps baseSteps = new BaseSteps();
    YandexMainPageSteps yandexMainPageSteps = new YandexMainPageSteps();

    @When("^выполнен переход на главную страницу$")
    public void stepGoToMainPage(){
        baseSteps.stepGoToMainPage();
    }

    @When("^выбирается пункт верхнего меню Яндекс сервисов: \"(.*)\"$")
    public void stepSelectSubServicesMenuItem(String menuItem) {
        yandexMainPageSteps.stepSelectSubServicesMenuItem(menuItem);
    }

}
