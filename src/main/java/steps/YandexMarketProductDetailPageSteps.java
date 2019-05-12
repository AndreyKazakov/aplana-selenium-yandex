package steps;

import pages.YandexMarketProductDetailPage;
import ru.yandex.qatools.allure.annotations.Step;

public class YandexMarketProductDetailPageSteps {

    @Step("заголовок Детальной страницы продукта содержит текст {0}")
    public void stepCheckHeaderContainsText(String text){
        new YandexMarketProductDetailPage().checkHeaderContainsText(text);
    }
}
