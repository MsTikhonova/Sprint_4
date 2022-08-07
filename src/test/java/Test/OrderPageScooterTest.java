package Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.samokat.OrderDetailsFormPage;
import ru.yandex.samokat.datafortests.Order;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.*;


public class OrderPageScooterTest extends BaseUITest {

    @Test
    public void orderScooter() {

        Order order = new Order("Антон", "Смирнов", "Москва, улица Красносельская, дом 5", "Красносельская", "89607779485", "07.08.2022", "сутки");
//        Order order = new Order ()
        OrderDetailsFormPage isInputDataBlockDisplayed = new OrderDetailsFormPage(driver);
        isInputDataBlockDisplayed.open();
        isInputDataBlockDisplayed.acceptCoockie();
        isInputDataBlockDisplayed.ClickOrderButtonInHeader();
        isInputDataBlockDisplayed.fillOrderDetailsForm(order);
        String actual = isInputDataBlockDisplayed.getSuccessText();
        Assert.assertThat(actual,startsWith("Заказ оформлен"));


    }

    @Test
    public void orderScooterTwo() {

        Order order = new Order("Юлия", "Ян", "Москва, улица Автозаводская, д 13", "Автозаводская", "79117779485", "18.07.2022", "двое суток");

        OrderDetailsFormPage isInputDataBlockDisplayed = new OrderDetailsFormPage(driver);
        isInputDataBlockDisplayed.open();
        isInputDataBlockDisplayed.acceptCoockie();
        isInputDataBlockDisplayed.ClickOrderButtonInHeader();
        isInputDataBlockDisplayed.fillOrderDetailsForm(order);
        String actual = isInputDataBlockDisplayed.getSuccessText();
        Assert.assertThat(actual,startsWith("Заказ оформлен"));


    }
}