package test.uiTest;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import page.SalesPage;

import static com.codeborne.selenide.Selenide.open;

public class CardNumberFieldTest {
    SalesPage salesPage = new SalesPage();

    @BeforeAll
    static void setUp() {
        open("http://localhost:8080");
    }

//    @Test
//    void debitBuyingByApprovedCard() {
//        salesPage.buyByDebit().buyWithCardInfo(
//                "short",
//                "en",
//                "getDate",
//                "future",
//                "no",
//                "no",
//                "ok",
//                "ok"
//        );
//        .shouldBe(Condition.visible);
//    }
}
