package data;

import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.time.LocalDateTime;

public class DataBaseHelper {
    private final static QueryRunner runner = new QueryRunner();
    private final static Connection conn = connection();

    @SneakyThrows
    public static Connection connection() {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "app", "pass");
    }

    @SneakyThrows
    public static int getAmountFromPaymentEntity() {
        return runner.query(conn, "SELECT amount FROM payment_entity", new ScalarHandler<>());
    }

    @SneakyThrows
    public static LocalDateTime getCreatedDateFromPaymentEntity() {
        return runner.query(conn, "SELECT created FROM payment_entity", new ScalarHandler<>());
    }

    @SneakyThrows
    public static String getStatusFromPaymentEntity() {
        return runner.query(conn, "SELECT status FROM payment_entity", new ScalarHandler<>());
    }

    @SneakyThrows
    public static String getTransactionIdFromPaymentEntity() {
        return runner.query(conn, "SELECT transaction_id FROM payment_entity", new ScalarHandler<>());
    }

    @SneakyThrows
    public static String getBankIdFromCreditRequestEntity() {
        return runner.query(conn, "SELECT bank_id FROM credit_request_entity", new ScalarHandler<>());
    }

    @SneakyThrows
    public static LocalDateTime getCreatedDateFromCreditRequestEntity() {
        return runner.query(conn, "SELECT created FROM credit_request_entity", new ScalarHandler<>());
    }

    @SneakyThrows
    public static String getStatusFromCreditRequestEntity() {
        return runner.query(conn, "SELECT status FROM credit_request_entity", new ScalarHandler<>());
    }

    @SneakyThrows
    public static LocalDateTime getCreatedDateFromOrderEntity() {
        return runner.query(conn, "SELECT created FROM order_entity", new ScalarHandler<>());
    }

    @SneakyThrows
    public static String getCreditIdFromOrderEntity() {
        return runner.query(conn, "SELECT credit_id FROM order_entity", new ScalarHandler<>());
    }

    @SneakyThrows
    public static String getPaymentIdFromOrderEntity() {
        return runner.query(conn, "SELECT payment_id FROM order_entity", new ScalarHandler<>());
    }

    @SneakyThrows
    public static void dropDataBase() {
        runner.update(conn, "DELETE FROM credit_request_entity");
        runner.update(conn, "DELETE FROM order_entity");
        runner.update(conn, "DELETE FROM payment_entity");
    }

}
