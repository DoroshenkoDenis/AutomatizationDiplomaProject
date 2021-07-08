package test.dbTest;

import data.APIHelper;
import data.DataBaseHelper;
import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class dbTest {

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
