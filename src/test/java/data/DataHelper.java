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

    private static String getNumber(String status, String locale) {
        if (status.equals("APPROVED")) {
            return "4444 4444 4444 4441";
        }
        if (status.equals("DECLINED")) {
            return "4444 4444 4444 4442";
        }
        if (status.equals("short")) {
            return "4444 4444 4444 444";
        }
        if (status.equals("one")) {
            return "4";
        }
        return new Faker(new Locale(locale)).finance().creditCard();
    }

    private static String getFullName(String status) {
        Faker faker = new Faker();
        if (status.equals("badName")) {
            return faker.aquaTeenHungerForce().character() + " - " + faker.number().numberBetween(1, 999);
        }
        return new Faker().name().firstName().toUpperCase() + " " + new Faker().name().firstName().toUpperCase();
    }

    private static LocalDate getDate(String status) {
        if (status.equals("past")) {
            return LocalDate.now().minusMonths(new Faker().number().numberBetween(1, 12 * 5));
        }
        if (status.equals("future")) {
            return LocalDate.now().plusMonths(new Faker().number().numberBetween(1, 12 * 5));
        }
        return LocalDate.now();
    }

    private static String getBadMonth(String status) {
        Faker faker = new Faker();
        if (status.equals("zero")) {
            return "0";
        }
        if (status.equals("doubleZero")) {
            return "00";
        }
        return String.valueOf(faker.number().numberBetween(13, 99));
    }

    private static String getBadYear(String status) {
        if (status.equals("zero")) {
            return "0";
        }
        return "00";
    }

    private static String getMonth(String dateMethod, String dateStatus, String badMonthStatus) {
        if (dateMethod.equals("getDate")) {
            return getDate(dateStatus).format(ofPattern("MM"));
        }
        return getBadMonth(badMonthStatus);
    }

    private static String getYear(String dateMethod, String dateStatus, String badYearStatus) {
        if (dateMethod.equals("getDate")) {
            return getDate(dateStatus).format(ofPattern("yy"));
        }
        return getBadYear(badYearStatus);
    }

    private static String getCVC(String status) {
        String cvc = new Faker().number().digits(3);
        if (status.equals("tripleZero")) {
            return "000";
        }
        if (status.equals("short")) {
            return String.valueOf(new Faker().number().numberBetween(0, 99));
        }
        if (cvc.equals("000")) {
            return "777";
        }
        return cvc;
    }

    public static CardInfo getCardInfo(String cardStatus, String requiredLocale, String dateMethod, String dateStatus, String badMonthStatus, String badYearStatus, String holderStatus, String cvcStatus) {
        return new CardInfo(
                getNumber(cardStatus, requiredLocale),
                getMonth(dateMethod, dateStatus, badMonthStatus),
                getYear(dateMethod, dateStatus, badYearStatus),
                getFullName(holderStatus),
                getCVC(cvcStatus)
        );
    }

//    оставляю пока здесь для отладки и проверки
    public static void main(String[] args) {
        System.out.println("please try and look at this:  ----> " + getCardInfo(
                "APPROVED, DECLINED, short, one or nothing for a random choice",
                "en",
                "getDate or nothing for a incorrect date",
                "past, future or nothing for choice a current date (if dateMethod = getDate)",
                "zero, doubleZero or nothing for choice an incorrect value (from 13 to 99) (if dateMethod != getDate)",
                "zero or nothing for choice a doubleZero value (if dateMethod != getDate)",
                "tripleZero, short or nothing for choice a random value",
                "badName or nothing for choice a random correct name"
        ) + " <----");
    }

}
