#language: ru

Функционал: Поиск
  Структура сценария: Поиск товара по расширенному фильтру

    Дано выполнен переход на главную страницу
    Когда выбирается пункт верхнего меню Яндекс сервисов: "Маркет"
    И выбирается пункт верхнего меню категорий товаров: "Электроника"
    И в боковом левом меню для пункта "<leftMenuItem>" выбран подпункт "<leftMenuSubItem>"
    Тогда заголовок страницы Список продуктов содержит текст "<leftMenuSubItem>"

    Когда выполнено нажатие на кнопку - Все фильтры
    И поле "Цена От" заполняется значением "<PriceFrom>"
    И выбираются производители: "<Producers>"
    И выполнен скриншот текущего окна
    И выполнено нажатие на кнопку - Показать подходящие
    Тогда заголовок страницы Список продуктов содержит текст "<leftMenuSubItem>"
    Когда выполнено нажатие на кнопку - Показывать списком

    # также предусмотрен шаг "Количество продкуктов равно" - если точно известно ожидаемое количество
    Тогда количество продуктов больше "0"
    И выполнен скриншот текущего окна

    Когда имя "1"-го продукта в списке сохранено в переменную "productTitle"
    Когда выполнен поиск по ключевым словам "#{productTitle}"

    # поскольку в качестве результата поиска может быть открыта либо детальная страница продукта, либо список продуктов -
    # в шаге это было учтено, и поэтому сначала делается попытка дождаться тайтла детальной страницы,
    # если не дожидаемся, то валидация идет по тайтлу первого в списке найденного товара
    Тогда имя найденного продукта содержит текст "#{productTitle}"
    И выполнен скриншот текущего окна

  Примеры:
  |leftMenuItem|leftMenuSubItem|PriceFrom|Producers|
  |Аудио- и видеотехника|Телевизоры|20000|Samsung, LG|
  |Портативная техника|Наушники и Bluetooth-гарнитуры|5000|Beats|




