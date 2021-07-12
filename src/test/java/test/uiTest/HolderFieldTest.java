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

public class HolderFieldTest {
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
    void emptyHolderField() {
        salesPage.buyByDebit().buyWithCardInfo(
                "APPROVED",
                "en",
                "future",
                "future",
                "empty",
                "random"
        );
        paymentForm.getWrongFormatNotification().shouldBe(Condition.visible);
    }

    @Test
    void badNameInHolderField() {
        salesPage.buyByDebit().buyWithCardInfo(
                "APPROVED",
                "en",
                "future",
                "future",
                "badName",
                "random"
        );
        paymentForm.getWrongFormatNotification().shouldBe(Condition.visible);
    }

}
