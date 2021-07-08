package test.uiTest;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.PaymentForm;
import page.SalesPage;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class MonthFieldTest {
    PaymentForm paymentForm = new PaymentForm();
    SalesPage salesPage = new SalesPage();

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
