package test.guiTest;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.PaymentForm;
import page.SalesPage;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

public class GUITest {
    SalesPage salesPage = new SalesPage();
    PaymentForm paymentForm = new PaymentForm();

    @BeforeEach
    void setUp() {
        open("http://localhost:8080");
    }


    @Test
    void headTitleTest() {
        salesPage.getHeadTitle().shouldHave(attribute("text", "Путешествие дня"));
    }

    @Test
    void debitHeadingTitleTest() {
        salesPage.getDebitBuyingButton().click();
        salesPage.getBody().shouldHave(text("Оплата по карте"));
    }

    @Test
    void creditHeadTitleTest() {
        salesPage.getCreditBuyingButton().click();
        salesPage.getBody().shouldHave(text("Кредит по данным карты"));
    }

    @Test
    void sendingVisualizationTest() {
        salesPage.buyByDebit().buyWithCardInfo(
                "APPROVED",
                "en",
                "future",
                "future",
                "goodName",
                "random"
        );
        paymentForm.getLoadingSpinOnContinueButton().shouldBe(Condition.visible);
    }
}
