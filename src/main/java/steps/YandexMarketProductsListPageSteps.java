package steps;

import pages.YandexMarketProductsListPage;
import ru.yandex.qatools.allure.annotations.Step;

public class YandexMarketProductsListPageSteps {

    @Step("заголовок страницы Список продуктов содержит текст {0}")
    public void stepCheckHeaderContainsText(String text){
        new YandexMarketProductsListPage().checkHeaderContainsText(text);
    }

    @Step("выполнено нажатие на кнопку - Все фильтры")
    public void stepClickButtonAllFilters(){
        new YandexMarketProductsListPage().clickButtonAllFilters();
    }

    @Step("выполнено нажатие на кнопку - Показывать списком")
    public void stepClickButtonListView() {
        new YandexMarketProductsListPage().clickButtonListView();
    }

    @Step("количество продуктов больше {0}")
    public void stepCheckCountOfProductsMoreThanValue(String value){
        new YandexMarketProductsListPage().checkCountOfProductsMoreThanValue(value);
    }

    @Step("количество продуктов равно {0}")
    public void stepCheckCountOfProductsEqualToValue(String value){
        new YandexMarketProductsListPage().checkCountOfProductsEqualToValue(value);
    }

    @Step("имя {0}-го продукта в списке сохранено в переменную {1}")
    public void stepSaveProductTitleIntoVariable(String number, String variable){
        new YandexMarketProductsListPage().saveProductTitleIntoVariable(number, variable);
    }

    @Step("имя первого продукта в списке содержит текст {0}")
    public void stepCheckFirstProductTitle(String text){
        new YandexMarketProductsListPage().checkFirstProductTitle(text);
    }
}
