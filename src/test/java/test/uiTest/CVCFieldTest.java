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

public class CVCFieldTest {
    PaymentForm paymentForm = new PaymentForm();
    SalesPage salesPage = new SalesPage();

    @BeforeEach
    void setUp() {
        open("http://localhost:8080");
    }

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @Test
    void emptyCVCNumberField() {
        salesPage.buyByDebit().buyWithCardInfo(
                "APPROVED",
                "en",
                "future",
                "future",
                "goodName",
                "empty"
        );
        paymentForm.getWrongFormatNotification().shouldBe(Condition.visible);
    }

    @Test
    void tripleZeroInCVCNumberField() {
        salesPage.buyByDebit().buyWithCardInfo(
                "APPROVED",
                "en",
                "future",
                "future",
                "goodName",
                "tripleZero"
        );
        paymentForm.getWrongFormatNotification().shouldBe(Condition.visible);
    }

    @Test
    void shortNumberInCVCNumberField() {
        salesPage.buyByDebit().buyWithCardInfo(
                "APPROVED",
                "en",
                "future",
                "future",
                "goodName",
                "short"
        );
        paymentForm.getWrongFormatNotification().shouldBe(Condition.visible);
    }

}
