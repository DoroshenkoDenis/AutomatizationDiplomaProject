package page;

import com.codeborne.selenide.SelenideElement;
import lombok.Data;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

@Data
public class SalesPage {
    SelenideElement debitBuyingButton = $(byText("Купить"));
    SelenideElement creditBuyingButton = $(byText("Купить в кредит"));
    SelenideElement successNotification = $(".notification_status_ok ");
    SelenideElement errorNotification = $(".notification_status_error");

    public PaymentForm buyByDebit() {
        debitBuyingButton.click();
        return new PaymentForm();
    }
    public PaymentForm buyByCredit() {
        debitBuyingButton.click();
        return new PaymentForm();
    }
}


