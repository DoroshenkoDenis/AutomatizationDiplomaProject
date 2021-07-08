package test.uiTest;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.PaymentForm;
import page.SalesPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class CardNumberFieldTest {
    PaymentForm paymentForm = new PaymentForm();
    SalesPage salesPage = new SalesPage();

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
