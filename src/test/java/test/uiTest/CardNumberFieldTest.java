package test.uiTest;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.PaymentForm;
import page.SalesPage;

import static com.codeborne.selenide.Selenide.open;

public class CardNumberFieldTest {
    PaymentForm paymentForm = new PaymentForm();
    SalesPage salesPage = new SalesPage();

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @BeforeEach
    void setUp() {
        open("http://localhost:8080");
    }

    @Test
    void emptyCardNumberField() {
        salesPage.buyByDebit().buyWithCardInfo(
                "empty",
                "en",
                "future",
                "future",
                "goodName",
                "random"
        );
        paymentForm.getWrongFormatNotification().shouldBe(Condition.visible);
    }

    @Test
    void shortNumberInCardNumberField() {
        salesPage.buyByDebit().buyWithCardInfo(
                "short",
                "en",
                "future",
                "future",
                "goodName",
                "random"
        );
        paymentForm.getWrongFormatNotification().shouldBe(Condition.visible);
    }

    @Test
    void oneNumberInCardNumberField() {
        salesPage.buyByDebit().buyWithCardInfo(
                "one",
                "en",
                "future",
                "future",
                "goodName",
                "random"
        );
        paymentForm.getWrongFormatNotification().shouldBe(Condition.visible);
    }
}
