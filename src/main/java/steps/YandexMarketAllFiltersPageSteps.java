package steps;

import pages.YandexMarketAllFiltersPage;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class YandexMarketAllFiltersPageSteps {

    @Step("поле {0} заполнено значением {1}")
    public void stepFillTextField(String fieldName, String value){
        new YandexMarketAllFiltersPage().fillTextField(fieldName, value);
    }

    @Step("выбраны производители: {0}")
    public void stepSelectProducers(List<String> values){
        new YandexMarketAllFiltersPage().selectProducers(values);
    }

    @Step("выполнено нажатие на кнопку - Показать подходящие")
    public void stepClickButtonShowFiltered() {
        new YandexMarketAllFiltersPage().clickButtonShowFiltered();
    }

}
