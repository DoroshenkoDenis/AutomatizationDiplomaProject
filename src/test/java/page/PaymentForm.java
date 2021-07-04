package page;

import com.codeborne.selenide.SelenideElement;
import data.DataHelper;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PaymentForm {
    private final SelenideElement cardNumberField = $("form > fieldset > div:nth-child(1) .input__control");
    private final SelenideElement monthField = $("form > fieldset > div:nth-child(2) .input__control");
    private final SelenideElement yearField = $("form > fieldset > div:nth-child(2) > span > span:nth-child(2) .input__control");
    private final SelenideElement holderField = $("form > fieldset > div:nth-child(3) .input__control");
    private final SelenideElement cvcField = $("form > fieldset > div:nth-child(3) > span > span:nth-child(2) .input__control");
    private final SelenideElement continueButton = $(byText("Продолжить"));
    private final SelenideElement wrongFormatNotification = $(".input__sub");

    public void buyWithCardInfo(String cardStatus, String requiredLocale, String dateMethod, String dateStatus, String badMonthStatus, String badYearStatus, String holderStatus, String cvcStatus) { ;
        cardNumberField.setValue(DataHelper.getCardInfo(cardStatus, requiredLocale, dateMethod, dateStatus, badMonthStatus, badYearStatus, holderStatus, cvcStatus).getNumber());
        monthField.setValue(DataHelper.getCardInfo(cardStatus, requiredLocale, dateMethod, dateStatus, badMonthStatus, badYearStatus, holderStatus, cvcStatus).getMonth());
        yearField.setValue(DataHelper.getCardInfo(cardStatus, requiredLocale, dateMethod, dateStatus, badMonthStatus, badYearStatus, holderStatus, cvcStatus).getYear());
        holderField.setValue(DataHelper.getCardInfo(cardStatus, requiredLocale, dateMethod, dateStatus, badMonthStatus, badYearStatus, holderStatus, cvcStatus).getCardHolder());
        cvcField.setValue(DataHelper.getCardInfo(cardStatus, requiredLocale, dateMethod, dateStatus, badMonthStatus, badYearStatus, holderStatus, cvcStatus).getCvc());
        continueButton.click();
    }
}
