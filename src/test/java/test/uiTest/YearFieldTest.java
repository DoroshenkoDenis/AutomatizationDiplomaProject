package test.uiTest;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.PaymentForm;
import page.SalesPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class YearFieldTest {

    PaymentForm paymentForm = new PaymentForm();
    SalesPage salesPage = new SalesPage();

    @BeforeEach
    void setUp() {
        open("http://localhost:8080");
    }

    @Test
    void pastDateInYearFieldAndCurrentDateInMonthField() {
        salesPage.buyByDebit().buyWithCardInfo(
                "APPROVED",
                "en",
                "current",
                "past",
                "goodName",
                "random"
        );
        paymentForm.getWrongFormatNotification().shouldBe(Condition.visible);
    }

    @Test
    void emptyYearField() {
        salesPage.buyByDebit().buyWithCardInfo(
                "APPROVED",
                "en",
                "current",
                "empty",
                "goodName",
                "random"
        );
        paymentForm.getWrongFormatNotification().shouldBe(Condition.visible);
    }

    @Test
    void zeroDigitInYearField() {
        salesPage.buyByDebit().buyWithCardInfo(
                "APPROVED",
                "en",
                "current",
                "zero",
                "goodName",
                "random"
        );
        paymentForm.getWrongFormatNotification().shouldBe(Condition.visible);
    }

    @Test
    void doubleZeroDigitInYearField() {
        salesPage.buyByDebit().buyWithCardInfo(
                "APPROVED",
                "en",
                "current",
                "doubleZero",
                "goodName",
                "random"
        );
        paymentForm.getWrongFormatNotification().shouldBe(Condition.visible);
    }

    @Test
    void badRandomDigitInYearField() {
        salesPage.buyByDebit().buyWithCardInfo(
                "APPROVED",
                "en",
                "current",
                "badRandom",
                "goodName",
                "random"
        );
        paymentForm.getWrongFormatNotification().shouldBe(Condition.visible);
    }
}
