package ru.yandex.samokat;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {

    public static final String URL = "https://qa-scooter.praktikum-services.ru/";

    public final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    //Кнопка "Закать" в  заголовке
    private  final By orderButtonInHeader = By.xpath("//*[@id=\"root\"]/div/div/div[1]/div[2]/button[1]");

    // Кнопка "Закать" в середине
    private final By orderButtonInMiddle = By.xpath("//*[@id=\"root\"]/div/div/div[4]/div[2]/div[5]/button");

    // Заголовок с вопросами
    private final By questionTitle = By.xpath("//*[@id=\"root\"]/div/div/div[5]/div[1]");

    //Кнопка согласия для cookie
    private final By buttonAcceptCookies = By.id("rcc-confirm-button");

    //Метод кликает на кнопку принятия файлов куки
    public void ClickButtonAcceptCookies() {
        driver.findElement(buttonAcceptCookies).click();
    }

    //Метод скроллит до заголовка с вопросами
    public void scrollToTheQuestionsSection() {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[5]/div[1]"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    //Метод кликает по кнопке заказа в заголовке
    public void ClickOrderButtonInHeader() {
        driver.findElement(orderButtonInHeader).click();

    }

    //Метод кликает по кнопке заказа в середине
    public void ClickOrderButtonInMiddle() {
        driver.findElement(orderButtonInMiddle).click();

    }
    //Метод кликает по вопросу
    public void clickQuestion(String number) {
        driver.findElement(By.id(String.format("accordion__heading-%s", number))).click();
    }

    //Метод получает текст ответа
    public String getAnswer(String number) {
        return  driver.findElement(By.id(String.format("accordion__panel-%s", number))).getText();
    }

    public void open(){
        driver.get(URL);
    }

}