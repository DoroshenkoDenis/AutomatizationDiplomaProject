package test.dbTest;

import com.codeborne.selenide.logevents.SelenideLogger;
import data.APIHelper;
import data.DataBaseHelper;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.val;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class dbTest {

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @BeforeEach
    void resetAll() {
        DataBaseHelper.dropDataBase();
    }

    @Test
    void shouldFillInFieldsIfDebitBuyingByApprovedCard() {
        val response = APIHelper.debitBuying(
                "APPROVED",
                "en",
                "future",
                "future",
                "goodName",
                "random"
        );
        assertEquals(4500000, DataBaseHelper.getAmountFromPaymentEntity());
        assertNotNull(DataBaseHelper.getCreatedDateFromPaymentEntity());
        assertEquals("APPROVED", DataBaseHelper.getStatusFromPaymentEntity());
        assertNotNull(DataBaseHelper.getTransactionIdFromPaymentEntity());
        assertNotNull(DataBaseHelper.getCreatedDateFromOrderEntity());
        assertNotNull(DataBaseHelper.getPaymentIdFromOrderEntity());
    }

    @Test
    void shouldFillInFieldsIfDebitBuyingByDeclinedCard() {
        val response = APIHelper.debitBuying(
                "DECLINED",
                "en",
                "future",
                "future",
                "goodName",
                "random"
        );
        assertEquals(4500000, DataBaseHelper.getAmountFromPaymentEntity());
        assertNotNull(DataBaseHelper.getCreatedDateFromPaymentEntity());
        assertEquals("DECLINED", DataBaseHelper.getStatusFromPaymentEntity());
        assertNotNull(DataBaseHelper.getTransactionIdFromPaymentEntity());
        assertNotNull(DataBaseHelper.getCreatedDateFromOrderEntity());
        assertNotNull(DataBaseHelper.getPaymentIdFromOrderEntity());
    }

    @Test
    void shouldFillInFieldsIfCreditBuyingByApprovedCard() {
        val response = APIHelper.creditBuying(
                "APPROVED",
                "en",
                "future",
                "future",
                "goodName",
                "random"
        );
        assertNotNull(DataBaseHelper.getBankIdFromCreditRequestEntity());
        assertNotNull(DataBaseHelper.getCreatedDateFromCreditRequestEntity());
        assertEquals("APPROVED", DataBaseHelper.getStatusFromCreditRequestEntity());
        assertNotNull(DataBaseHelper.getCreatedDateFromOrderEntity());
        assertNotNull(DataBaseHelper.getCreditIdFromOrderEntity());
    }

    @Test
    void shouldFillInFieldsIfCreditBuyingByDeclinedCard() {
        val response = APIHelper.creditBuying(
                "DECLINED",
                "en",
                "future",
                "future",
                "goodName",
                "random"
        );
        assertNotNull(DataBaseHelper.getBankIdFromCreditRequestEntity());
        assertNotNull(DataBaseHelper.getCreatedDateFromCreditRequestEntity());
        assertEquals("DECLINED", DataBaseHelper.getStatusFromCreditRequestEntity());
        assertNotNull(DataBaseHelper.getCreatedDateFromOrderEntity());
        assertNotNull(DataBaseHelper.getCreditIdFromOrderEntity());
    }
}
