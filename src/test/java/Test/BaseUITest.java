package Test;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseUITest {

    protected WebDriver driver;

    @Before
    public void setUp(){
//        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Human being\\WebDriver\\bin\\geckodriver.exe");
//        driver = new FirefoxDriver();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Human being\\WebDriverbin\\bin\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();

    }

    @After
    public void teardown() {
        // Закрыть браузер
        driver.quit();
    }

}