package ru.yandex.samokat;

        import org.openqa.selenium.By;
        import org.openqa.selenium.Keys;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.support.ui.ExpectedConditions;
        import org.openqa.selenium.support.ui.WebDriverWait;
        import ru.yandex.samokat.datafortests.Order;

        import java.util.concurrent.TimeUnit;

public class OrderDetailsFormPage
        extends MainPage
{
    public OrderDetailsFormPage(WebDriver driver) {
        super(driver);
    }
    //Кнопка согласия для cookie
    private final By cookieButton = By.xpath(".//button[text() = 'да все привыкли']");

    //Форма 1. Поле "Имя"
    private final By customerName = By.xpath(".//input[@placeholder = '* Имя']");

    //Форма 1. Поле "Фамилия"
    private final By customerLastName = By.xpath(".//input[@placeholder = '* Фамилия']");

    //Форма 1. Поле "Адрес"
    private final By customerAddress = By.xpath(".//input[@placeholder = '* Адрес: куда привезти заказ']");

    //Форма 1. Поле "Станция метро"
    private final By whenMetroStation = By.xpath(".//input[@class='select-search__input']");

    // Форма 1. Кнопка "Далее"/Форма 2. Кнопка "Заказать"
    private final By furtherButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    //Форма 2. Кнопка "Назад"
    private final By backButton = By.xpath(".//[@class=Button_Button__ra12g Button_Middle__1CSJM Button_Inverted__3IF-i]");
    // Форма 2. Поле "Телефон"
    private final By customerPhone = By.xpath(".//input[@placeholder = '* Телефон: на него позвонит курьер']");
    // Форма 2. Поле "Когда привезти самокат"
    private final By whenOrderDate = By.xpath(".//input[@placeholder = '* Когда привезти самокат']");

    // Форма 2. Поле "Срок аренды"
    private final By customerRentalPeriod = By.xpath(".//div[@class='Dropdown-placeholder' and text()='* Срок аренды']");

    // Форма 2. Список в поле "Срок аренды"
    private String customerRentalPeriodDrop = "//div[@class='Dropdown-option' and text()='%s']";
    //Блок подтверждения заказа
    private final By orderConfirmationBlock = By.xpath(".//div[@class='Order_Modal__YZ-d3']");
    //Кнопка подтверждения заказа
    private final By orderConfirmationButton = By.xpath(".//div[@class='Order_Modal__YZ-d3']/div/button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text() = 'Да']");
    //Блок с оповещением об успешном оформлении заказа
    private final By orderSuccessfullyMade = By.xpath(".//div[text()='Заказ оформлен']");

    //Заполнение форм заказа
    public OrderDetailsFormPage fillOrderDetailsForm(Order order) {
        fillName(order.getName());
        fillLastName(order.getLastName());
        fillAddress(order.getAddress());
        fillMetroStation(order.getMetroStation());
        fillPhone(order.getPhone());
        clickFurtherButton();
        fillOrderDate(order.getOrderDate());
        fillRentalPeriod(order.getRentalPeriod());
        clickFurtherButton();
        waitForConfirmingBlock();
        clickConfirmationButton();
        waitForClickingButton();
        return this;
    }

    //метод заполнения поля "Имя"
    private OrderDetailsFormPage fillName(String name) {
        driver.findElement(customerName).sendKeys(name);
        return this;
    }

    //метод заполнения поля "Фамилия"
    private OrderDetailsFormPage fillLastName(String lastName) {
        driver.findElement(customerLastName).sendKeys(lastName);
        return this;
    }

    //метод заполнения поля "Адрес"
    private OrderDetailsFormPage fillAddress(String address) {
        driver.findElement(customerAddress).sendKeys(address);
        return this;
    }

    //метод заполнения поля "Станция метро"
    private OrderDetailsFormPage fillMetroStation(String metroStation) {
        driver.findElement(whenMetroStation).sendKeys(metroStation + Keys.ARROW_DOWN + Keys.ENTER);
        return this;
    }

    //метод заполнения поля "Телефон"
    private OrderDetailsFormPage fillPhone(String phone) {
        driver.findElement(customerPhone).sendKeys(phone);
        return this;
    }
    //метод кликает по кнопке "Далее"/"Заказать"
    private OrderDetailsFormPage clickFurtherButton() {
        driver.findElement(furtherButton).click();
        return this;
    }
    //метод выбирает дату
    private OrderDetailsFormPage fillOrderDate(String orderDate) {
        driver.findElement(whenOrderDate).click();
        driver.findElement(whenOrderDate).sendKeys(orderDate + Keys.ENTER);
        return this;
    }
    //метод выбирает период аренды
    private OrderDetailsFormPage fillRentalPeriod(String rentalPeriod) {
        driver.findElement(customerRentalPeriod).click();
        driver.findElement(By.xpath(String.format(customerRentalPeriodDrop, rentalPeriod))).click();
        return this;
    }

    //метод кликает по кнопке подтверждения заказа
    private OrderDetailsFormPage clickConfirmationButton() {
        driver.findElement(orderConfirmationButton).click();
        return this;
    }

    //метод ожидает появления блока подтверждения заказа
    private OrderDetailsFormPage waitForConfirmingBlock() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(orderConfirmationBlock));
        return this;
    }
    //метод ожидания прогрузки страницы
    private void waitForClickingButton() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    //метод кликает на кнопку принятия cookie
    public void acceptCoockie(){
        driver.findElement(cookieButton).click();
    }
    //метод извлекает текст из блока об успешном оформлении заказа
    public String getSuccessText(){
        String successText = driver.findElement(orderSuccessfullyMade).getText();
        return successText;
    }
}


