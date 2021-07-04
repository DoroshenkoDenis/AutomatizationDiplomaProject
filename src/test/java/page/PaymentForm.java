package page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PaymentForm {
    private SelenideElement cardNumberField = $("form > fieldset > div:nth-child(1) .input__control");
    private SelenideElement monthField = $("form > fieldset > div:nth-child(2) .input__control");
    private SelenideElement yearField = $("form > fieldset > div:nth-child(2) > span > span:nth-child(2) .input__control");
    private SelenideElement holderField = $("form > fieldset > div:nth-child(3) .input__control");
    private SelenideElement cvcField = $("form > fieldset > div:nth-child(3) > span > span:nth-child(2) .input__control");
    private SelenideElement continueButton = $(byText("Продолжить"));
    private SelenideElement wrongFormatNotification = $(".input__sub");

    public void buyWithCardInfo() {
        cardNumberField.setValue("4444-4444-4444-44441");
        monthField.setValue("11");
        yearField.setValue("22");
        holderField.setValue("dorko");
        cvcField.setValue("123");
        continueButton.click();
    }
}
