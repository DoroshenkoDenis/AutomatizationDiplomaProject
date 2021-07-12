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

import java.time.Duration;

import static com.codeborne.selenide.Selenide.open;

public class MonthFieldTest {
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
    void currentDateInMonthAndYearFields() {
        salesPage.buyByDebit().buyWithCardInfo(
                "APPROVED",
                "en",
                "current",
                "current",
                "goodName",
                "random"
        );
        salesPage.getSuccessNotification().shouldBe(Condition.visible, Duration.ofMillis(15000));
    }

    @Test
    void futureDateInMonthFieldAndCurrentDateInYearField() {
        salesPage.buyByDebit().buyWithCardInfo(
                "APPROVED",
                "en",
                "future",
                "current",
                "goodName",
                "random"
        );
        salesPage.getSuccessNotification().shouldBe(Condition.visible, Duration.ofMillis(15000));
    }

    @Test
    void pastDateInMonthFieldAndCurrentDateInYearField() {
        salesPage.buyByDebit().buyWithCardInfo(
                "APPROVED",
                "en",
                "past",
                "current",
                "goodName",
                "random"
        );
        paymentForm.getWrongFormatNotification().shouldBe(Condition.visible);
    }

    @Test
    void emptyMonthField() {
        salesPage.buyByDebit().buyWithCardInfo(
                "APPROVED",
                "en",
                "empty",
                "current",
                "goodName",
                "random"
        );
        paymentForm.getWrongFormatNotification().shouldBe(Condition.visible);
    }

    @Test
    void zeroDigitInMonthField() {
        salesPage.buyByDebit().buyWithCardInfo(
                "APPROVED",
                "en",
                "zero",
                "current",
                "goodName",
                "random"
        );
        paymentForm.getWrongFormatNotification().shouldBe(Condition.visible);
    }

    @Test
    void doubleZeroDigitInMonthField() {
        salesPage.buyByDebit().buyWithCardInfo(
                "APPROVED",
                "en",
                "doubleZero",
                "current",
                "goodName",
                "random"
        );
        paymentForm.getWrongFormatNotification().shouldBe(Condition.visible);
    }

    @Test
    void badRandomDigitInMonthField() {
        salesPage.buyByDebit().buyWithCardInfo(
                "APPROVED",
                "en",
                "badRandom",
                "current",
                "goodName",
                "random"
        );
        paymentForm.getWrongFormatNotification().shouldBe(Condition.visible);
    }

}
