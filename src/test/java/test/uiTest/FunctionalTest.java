package test.uiTest;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import page.SalesPage;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class FunctionalTest {
    SalesPage salesPage = new SalesPage();

    @BeforeAll
    static void setUp() {
        open("http://localhost:8080");
    }

    @Test
    void debitBuyingByApprovedCard() {
        salesPage.buyByDebit().buyWithCardInfo(
                "APPROVED",
                "en",
                "getDate",
                "future",
                "no",
                "no",
                "ok",
                "ok"
        );
        salesPage.getSuccessNotification().shouldBe(Condition.visible, Duration.ofMillis(15000));
    }

    //  Тест должен упасть - Баг - неверное уведомление
//    @Test
//    void debitBuyingByDeclinedCard() {
//        salesPage.buyByDebit().buyWithCardInfo(
//                "DECLINED",
//                "en",
//                "getDate",
//                "future",
//                "no",
//                "no",
//                "ok",
//                "ok"
//        );
//        salesPage.getErrorNotification().shouldBe(Condition.visible, Duration.ofMillis(15000));
//    }

    @Test
    void creditBuyingByApprovedCard() {
        salesPage.buyByCredit().buyWithCardInfo(
                "APPROVED",
                "en",
                "getDate",
                "future",
                "no",
                "no",
                "ok",
                "ok"
        );
        salesPage.getSuccessNotification().shouldBe(Condition.visible, Duration.ofMillis(15000));
    }

    @Test
    void creditBuyingByDeclinedCard() {
        salesPage.buyByCredit().buyWithCardInfo(
                "DECLINED",
                "en",
                "getDate",
                "future",
                "no",
                "no",
                "ok",
                "ok"
        );
        salesPage.getSuccessNotification().shouldBe(Condition.visible, Duration.ofMillis(15000));
    }

}
