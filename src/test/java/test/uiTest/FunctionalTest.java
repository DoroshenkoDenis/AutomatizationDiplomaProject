package test.uiTest;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.PaymentForm;
import page.SalesPage;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class FunctionalTest {
    SalesPage salesPage = new SalesPage();
    PaymentForm paymentForm = new PaymentForm();

    @BeforeEach
    void setUp() {
        open("http://localhost:8080");
    }

    @Test
    void debitBuyingByApprovedCard() {
        salesPage.buyByDebit().buyWithCardInfo(
                "APPROVED",
                "en",
                "future",
                "future",
                "goodName",
                "random"
        );
        salesPage.getSuccessNotification().shouldBe(Condition.visible, Duration.ofMillis(15000));
    }

    @Test
    void debitBuyingByDeclinedCard() {
        salesPage.buyByDebit().buyWithCardInfo(
                "DECLINED",
                "en",
                "future",
                "future",
                "goodName",
                "random"
        );
        salesPage.getErrorNotification().shouldBe(Condition.visible, Duration.ofMillis(15000));
    }

    @Test
    void creditBuyingByApprovedCard() {
        salesPage.buyByCredit().buyWithCardInfo(
                "APPROVED",
                "en",
                "future",
                "future",
                "goodName",
                "random"
        );
        salesPage.getSuccessNotification().shouldBe(Condition.visible, Duration.ofMillis(15000));
    }

    @Test
    void creditBuyingByDeclinedCard() {
        salesPage.buyByCredit().buyWithCardInfo(
                "DECLINED",
                "en",
                "future",
                "future",
                "goodName",
                "random"
        );
        salesPage.getErrorNotification().shouldBe(Condition.visible, Duration.ofMillis(15000));
    }

    @Test
    void debitBuyingByAnotherCard() {
        salesPage.buyByDebit().buyWithCardInfo(
                "random",
                "en",
                "future",
                "future",
                "goodName",
                "random"
        );
        salesPage.getErrorNotification().shouldBe(Condition.visible, Duration.ofMillis(15000));
    }

    @Test
    void creditBuyingByAnotherCard() {
        salesPage.buyByCredit().buyWithCardInfo(
                "random",
                "en",
                "future",
                "future",
                "goodName",
                "random"
        );
        salesPage.getErrorNotification().shouldBe(Condition.visible, Duration.ofMillis(15000));
    }

    @Test
    void continueWithEmptyFields() {
        salesPage.buyByDebit().moveWhichContinueButton();
        paymentForm.getWrongFormatNotification().shouldBe(Condition.visible);
    }

}
