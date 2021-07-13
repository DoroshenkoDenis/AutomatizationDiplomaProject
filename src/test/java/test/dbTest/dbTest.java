package test.dbTest;

import com.codeborne.selenide.logevents.SelenideLogger;
import data.APIHelper;
import data.DataBaseHelper;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Тестирование базы данных")
public class dbTest {

    @BeforeEach
    void resetAll() {
        new DataBaseHelper().dropAll();
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
    @DisplayName("Проверка заполнения полей таблиц при покупке картой со статусом APPROVED")
    void shouldFillInFieldsIfDebitBuyingByApprovedCard() {
        APIHelper.debitBuying(
                "APPROVED",
                "en",
                "future",
                "future",
                "goodName",
                "random"
        );
        assertEquals(4500000, DataBaseHelper.getPaymentEntityInfo().getAmountFromPaymentEntity());
        assertNotNull(DataBaseHelper.getPaymentEntityInfo().getCreatedDateFromPaymentEntity());
        assertEquals("APPROVED", DataBaseHelper.getPaymentEntityInfo().getStatusFromPaymentEntity());
        assertNotNull(DataBaseHelper.getPaymentEntityInfo().getTransactionIdFromPaymentEntity());
        assertNotNull(DataBaseHelper.getOrderEntityInfo().getCreatedDateFromOrderEntity());
        assertNotNull(DataBaseHelper.getOrderEntityInfo().getPaymentIdFromOrderEntity());
    }

    @Test
    @DisplayName("Проверка заполнения полей таблиц при покупке картой со статусом DECLINED")
    void shouldFillInFieldsIfDebitBuyingByDeclinedCard() {
        APIHelper.debitBuying(
                "DECLINED",
                "en",
                "future",
                "future",
                "goodName",
                "random"
        );
        assertEquals(4500000, DataBaseHelper.getPaymentEntityInfo().getAmountFromPaymentEntity());
        assertNotNull(DataBaseHelper.getPaymentEntityInfo().getCreatedDateFromPaymentEntity());
        assertEquals("DECLINED", DataBaseHelper.getPaymentEntityInfo().getStatusFromPaymentEntity());
        assertNotNull(DataBaseHelper.getPaymentEntityInfo().getTransactionIdFromPaymentEntity());
        assertNotNull(DataBaseHelper.getOrderEntityInfo().getCreatedDateFromOrderEntity());
        assertNotNull(DataBaseHelper.getOrderEntityInfo().getPaymentIdFromOrderEntity());
    }

    @Test
    @DisplayName("Проверка заполнения полей таблиц при покупке в кредит картой со статусом APPROVED")
    void shouldFillInFieldsIfCreditBuyingByApprovedCard() {
        APIHelper.creditBuying(
                "APPROVED",
                "en",
                "future",
                "future",
                "goodName",
                "random"
        );
        assertNotNull(DataBaseHelper.getCreditRequestEntity().getBankIdFromCreditRequestEntity());
        assertNotNull(DataBaseHelper.getCreditRequestEntity().getCreatedDateFromCreditRequestEntity());
        assertEquals("APPROVED", DataBaseHelper.getCreditRequestEntity().getStatusFromCreditRequestEntity());
        assertNotNull(DataBaseHelper.getOrderEntityInfo().getCreatedDateFromOrderEntity());
        assertNotNull(DataBaseHelper.getOrderEntityInfo().getCreditIdFromOrderEntity());
    }

    @Test
    @DisplayName("Проверка заполнения полей таблиц при покупке в кредит картой со статусом DECLINED")
    void shouldFillInFieldsIfCreditBuyingByDeclinedCard() {
        APIHelper.creditBuying(
                "DECLINED",
                "en",
                "future",
                "future",
                "goodName",
                "random"
        );
        assertNotNull(DataBaseHelper.getCreditRequestEntity().getBankIdFromCreditRequestEntity());
        assertNotNull(DataBaseHelper.getCreditRequestEntity().getCreatedDateFromCreditRequestEntity());
        assertEquals("DECLINED", DataBaseHelper.getCreditRequestEntity().getStatusFromCreditRequestEntity());
        assertNotNull(DataBaseHelper.getOrderEntityInfo().getCreatedDateFromOrderEntity());
        assertNotNull(DataBaseHelper.getOrderEntityInfo().getCreditIdFromOrderEntity());
    }
}
