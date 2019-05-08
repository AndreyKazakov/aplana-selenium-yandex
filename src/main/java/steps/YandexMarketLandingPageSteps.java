package steps;

import pages.YandexMarketLandingPage;
import ru.yandex.qatools.allure.annotations.Step;

public class YandexMarketLandingPageSteps {

    @Step("выбран пункт верхнего меню категорий товаров: {0}")
    public void stepSelectCategoriesTopMenuItem(String menuItem){
        new YandexMarketLandingPage().selectCategoriesTopMenuItem(menuItem);
    }

}



