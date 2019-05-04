package steps;

import pages.YandexMainPage;
import ru.yandex.qatools.allure.annotations.Step;

public class YandexMainPageSteps {

    @Step("выбран пункт верхнего меню Яндекс сервисов: {0}")
    public void stepSelectSubServicesMenuItem(String menuItem){
        new YandexMainPage().selectSubServicesMenuItem(menuItem);
    }

}
