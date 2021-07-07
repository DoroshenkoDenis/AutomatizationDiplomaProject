package test.uiTest;

import com.codeborne.selenide.Condition;
import data.DataBaseHelper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import page.SalesPage;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
        assertEquals("APPROVED",DataBaseHelper.getDebitBuyingStatus());
        DataBaseHelper.dropDataBase();

    }

    @Test
    void debitBuyingByDeclinedCard() {
        salesPage.buyByDebit().buyWithCardInfo(
                "DECLINED",
                "en",
                "getDate",
                "future",
                "no",
                "no",
                "ok",
                "ok"
        );
        salesPage.getErrorNotification().shouldBe(Condition.visible, Duration.ofMillis(15000));
        assertEquals("DECLINED",DataBaseHelper.getDebitBuyingStatus());
        DataBaseHelper.dropDataBase();
    }

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
        assertEquals("APPROVED",DataBaseHelper.getCreditBuyingStatus());
        DataBaseHelper.dropDataBase();
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
        assertEquals("DECLINED",DataBaseHelper.getCreditBuyingStatus());
        DataBaseHelper.dropDataBase();
    }
}
