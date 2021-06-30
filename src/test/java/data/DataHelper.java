package data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.util.Locale;
import java.time.LocalDate;

import static java.time.format.DateTimeFormatter.ofPattern;

@Value
public class DataHelper {

    public DataHelper() {
    }

    @Value
    public static class CardInfo {
        String number;
        String month;
        String year;
        String cardHolder;
        String cvc;
    }

    private static String getFullName() {
        return new Faker().name().firstName().toUpperCase() + " " + new Faker().name().firstName().toUpperCase();
    }

    public static CardInfo getApprovedCardInfo() {
        return new CardInfo("4444444444444441", "12", "22", getFullName(), "777");
    }

    public static CardInfo getDeclinedCardInfo() {
        return new CardInfo("4444444444444442", "12", "22", getFullName(), "777");
    }


    public static CardInfo getRandomCardNumber(String locale) {
        Faker faker = new Faker(new Locale(locale));
        return new CardInfo(
                faker.finance().creditCard(),
                getApprovedCardInfo().month,
                getApprovedCardInfo().year,
                getApprovedCardInfo().cardHolder,
                getApprovedCardInfo().cvc
        );
    }

    public static CardInfo getShortCardNumber() {
        return new CardInfo(
                "444444444444444",
                getApprovedCardInfo().month,
                getApprovedCardInfo().year,
                getApprovedCardInfo().cardHolder,
                getApprovedCardInfo().cvc
        );
    }

    public static CardInfo getOneDigitInCardNumberField() {
        return new CardInfo(
                "4",
                getApprovedCardInfo().month,
                getApprovedCardInfo().year,
                getApprovedCardInfo().cardHolder,
                getApprovedCardInfo().cvc
        );
    }

    public static CardInfo getZeroInMonthField() {
        return new CardInfo(
                getApprovedCardInfo().number,
                "0",
                getApprovedCardInfo().year,
                getApprovedCardInfo().cardHolder,
                getApprovedCardInfo().cvc
        );
    }

    public static CardInfo getDoubleZeroInMonthField() {
        return new CardInfo(
                getApprovedCardInfo().number,
                "00",
                getApprovedCardInfo().year,
                getApprovedCardInfo().cardHolder,
                getApprovedCardInfo().cvc
        );
    }

    public static CardInfo getBadMonth() {
        Faker faker = new Faker();
        return new CardInfo(
                getApprovedCardInfo().number,
                String.valueOf(faker.number().numberBetween(13, 99)),
                getApprovedCardInfo().year,
                getApprovedCardInfo().cardHolder,
                getApprovedCardInfo().cvc
        );
    }

    public static CardInfo getLastMonth() {
        return new CardInfo(
                getApprovedCardInfo().number,
                LocalDate.now().minusMonths(1).format(ofPattern("MM")),
                getApprovedCardInfo().year,
                getApprovedCardInfo().cardHolder,
                getApprovedCardInfo().cvc
        );
    }

    public static CardInfo getZeroInYearField() {
        return new CardInfo(
                getApprovedCardInfo().number,
                getApprovedCardInfo().month,
                "0",
                getApprovedCardInfo().cardHolder,
                getApprovedCardInfo().cvc
        );
    }

    public static CardInfo getDoubleZeroInYearField() {
        return new CardInfo(
                getApprovedCardInfo().number,
                getApprovedCardInfo().month,
                "00",
                getApprovedCardInfo().cardHolder,
                getApprovedCardInfo().cvc
        );
    }

    public static CardInfo getLastYears() {
        Faker faker = new Faker();
        return new CardInfo(
                getApprovedCardInfo().number,
                getApprovedCardInfo().month,
                //  Рассчитывается значение относительно текущего года, возвращает значение от 01 до (текущий год -1)
                LocalDate.now().minusYears(faker.number().numberBetween(1, LocalDate.now().minusYears(2001).getYear())).format(ofPattern("yy")),
                getApprovedCardInfo().cardHolder,
                getApprovedCardInfo().cvc
        );
    }

    public static CardInfo getOverSixYears() {
        Faker faker = new Faker();
        return new CardInfo(
                getApprovedCardInfo().number,
                getApprovedCardInfo().month,
                LocalDate.now().plusYears(6).format(ofPattern("yy")),
                getApprovedCardInfo().cardHolder,
                getApprovedCardInfo().cvc
        );
    }

    public static CardInfo getCardHolderBadName() {
        Faker faker = new Faker();
        return new CardInfo(
                getApprovedCardInfo().number,
                getApprovedCardInfo().month,
                getApprovedCardInfo().year,
                faker.aquaTeenHungerForce().character() + " - " + faker.number().numberBetween(1,999),
                getApprovedCardInfo().cvc
        );
    }


    public static void main(String[] args) {
        System.out.println("LOOK AT THIS :  ----> " + getCardHolderBadName().getCardHolder() + " <----");
    }

}
