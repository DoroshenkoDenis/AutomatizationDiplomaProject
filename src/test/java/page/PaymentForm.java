package page;

import com.codeborne.selenide.SelenideElement;
import data.DataHelper;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PaymentForm {
    private final SelenideElement cardNumberField = $("[placeholder='0000 0000 0000 0000']");
    private final SelenideElement monthField = $("[placeholder='08']");
    private final SelenideElement yearField = $("[placeholder='22']");
    private final SelenideElement holderField = $$(".input__control").get(3);
    private final SelenideElement cvcField = $("[placeholder='999'");
    private final SelenideElement continueButton = $(byText("Продолжить"));
    private final SelenideElement wrongFormatNotification = $(".input__sub");

    public void buyWithCardInfo(String cardStatus, String requiredLocale, String dateMethod, String dateStatus, String badMonthStatus, String badYearStatus, String holderStatus, String cvcStatus) {
        cardNumberField.setValue(DataHelper.getCardInfo(cardStatus, requiredLocale, dateMethod, dateStatus, badMonthStatus, badYearStatus, holderStatus, cvcStatus)
                .getNumber());
        monthField.setValue(DataHelper.getCardInfo(cardStatus, requiredLocale, dateMethod, dateStatus, badMonthStatus, badYearStatus, holderStatus, cvcStatus)
                .getMonth());
        yearField.setValue(DataHelper.getCardInfo(cardStatus, requiredLocale, dateMethod, dateStatus, badMonthStatus, badYearStatus, holderStatus, cvcStatus)
                .getYear());
        holderField.setValue(DataHelper.getCardInfo(cardStatus, requiredLocale, dateMethod, dateStatus, badMonthStatus, badYearStatus, holderStatus, cvcStatus)
                .getCardHolder());
        cvcField.setValue(DataHelper.getCardInfo(cardStatus, requiredLocale, dateMethod, dateStatus, badMonthStatus, badYearStatus, holderStatus, cvcStatus)
                .getCvc());
        continueButton.click();
    }
}
