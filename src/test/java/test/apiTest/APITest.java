package test.apiTest;

import data.APIHelper;
import lombok.val;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class APITest {

    @Test
    void debitBuyingByApprovedCard() {
        val response = APIHelper.debitBuying(
                "APPROVED",
                "en",
                "getDate",
                "future",
                "no",
                "no",
                "goodName",
                "random"
        )
                .then()
                .statusCode(200)
                .extract().asString();
        assertTrue(response.contains("APPROVED"));
    }

    @Test
    void debitBuyingByDeclinedCard() {
        val response = APIHelper.debitBuying(
                "DECLINED",
                "en",
                "getDate",
                "future",
                "no",
                "no",
                "goodName",
                "random"
        )
                .then()
                .statusCode(200)
                .extract().asString();
        assertTrue(response.contains("DECLINED"));
    }

    @Test
    void creditBuyingByApprovedCard() {
        val response = APIHelper.creditBuying(
                "APPROVED",
                "en",
                "getDate",
                "future",
                "no",
                "no",
                "goodName",
                "random"
        )
                .then()
                .statusCode(200)
                .extract().asString();
        assertTrue(response.contains("APPROVED"));
    }

    @Test
    void creditBuyingByDeclinedCard() {
        val response = APIHelper.creditBuying(
                "DECLINED",
                "en",
                "getDate",
                "future",
                "no",
                "no",
                "goodName",
                "random"
        )
                .then()
                .statusCode(200)
                .extract().asString();
        assertTrue(response.contains("DECLINED"));
    }

    @Test
    void debitBuyingByAnotherCard() {
        val response = APIHelper.debitBuying(
                "random",
                "en",
                "getDate",
                "future",
                "no",
                "no",
                "goodName",
                "random"
        )
                .then()
                .statusCode(500)
                .extract().asString();
        assertTrue(response.contains("Bad Request"));
    }

    @Test
    void creditBuyingByAnotherCard() {
        val response = APIHelper.creditBuying(
                "random",
                "en",
                "getDate",
                "future",
                "no",
                "no",
                "goodName",
                "random"
        )
                .then()
                .statusCode(500)
                .extract().asString();
        assertTrue(response.contains("Bad Request"));
    }

}
