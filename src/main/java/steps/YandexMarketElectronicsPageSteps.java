package steps;

import pages.YandexMarketElectronicsPage;
import ru.yandex.qatools.allure.annotations.Step;

public class YandexMarketElectronicsPageSteps {

    @Step("в боковом левом меню для пункта {0} выбран подпункт {1}")
    public void stepSelectLeftSubMenuItem(String menuItem, String subMenuItem){
        new YandexMarketElectronicsPage().selectLeftSubMenuItem(menuItem, subMenuItem);
    }

}
