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
        if (status.equals("random")) {
            return new Faker(new Locale(locale)).finance().creditCard();
        }
        return null;
    }

    private static String getFullName(String status) {
        Faker faker = new Faker();
        if (status.equals("badName")) {
            return faker.aquaTeenHungerForce().character() + " - " + faker.number().numberBetween(1, 999);
        }
        if (status.equals("goodName")) {
        return new Faker().name().firstName().toUpperCase() + " " + new Faker().name().firstName().toUpperCase();
        }
        return null;
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
        if (status.equals("badRandom")){
            return String.valueOf(faker.number().numberBetween(13, 99));
        }
        return null;
    }

    private static String getBadYear(String status) {
        if (status.equals("zero")) {
            return "0";
        }
        if (status.equals("doubleZero")) {
            return "00";
        }
        if (status.equals("badRandom")){
            return LocalDate.now().plusMonths(new Faker().number().numberBetween(12 * 6, 12 * 9)).format(ofPattern("yy"));
        }
        return null;
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
        if (status.equals("random")) {
            return cvc;
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(getCVC("random"));
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

//           Statuses:
//-------------------------------------------------------------------------------------------------------------------------------------
//           cardStatus:               |    "APPROVED", "DECLINED", "short", "one", "random" or nothing for "null"
//           requiredLocale:           |    "en"
//           dateMethod:               |    "getDate" (correct date) or nothing for a choice of an incorrect data
//           dateStatus:               |    "past", "future" or nothing for a choice of a current date (if dateMethod = getDate)"
//           badMonthStatus:           |    "zero", "doubleZero", "badRandom" (13-99) or nothing for "null" (if dateMethod != getDate)
//           badYearStatus:            |    "zero", "doubleZero", "badRandom" (дата более пяти лет от текущей) or nothing for "null" (if dateMethod != getDate)
//           holderStatus:             |    "goodName (a random correct name), badName (a random incorrect name) or nothing for "null"
//           cvcStatus:                |    "tripleZero", "short", "random" or nothing for "null"

}
