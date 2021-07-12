package test.apiTest;

import com.codeborne.selenide.logevents.SelenideLogger;
import data.APIHelper;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.val;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class APITest {

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @Test
    void debitBuyingByApprovedCard() {
        val response = APIHelper.debitBuying(
                "APPROVED",
                "en",
                "future",
                "future",
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
                "future",
                "future",
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
                "future",
                "future",
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
                "future",
                "future",
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
                "future",
                "future",
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
                "future",
                "future",
                "goodName",
                "random"
        )
                .then()
                .statusCode(500)
                .extract().asString();
        assertTrue(response.contains("Bad Request"));
    }

}
