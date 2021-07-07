package data;

import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseHelper {
    private final static QueryRunner runner = new QueryRunner();
    private final static Connection conn = connection();

    @SneakyThrows
    public static Connection connection() {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "app", "pass");
    }

    @SneakyThrows
    public static String getDebitBuyingStatus() {
        return runner.query(conn, "SELECT status FROM payment_entity", new ScalarHandler<>());
    }

    @SneakyThrows
    public static String getCreditBuyingStatus() {
        return runner.query(conn, "SELECT status FROM credit_request_entity", new ScalarHandler<>());
    }

    @SneakyThrows
    public static void dropDataBase() {
        runner.update(conn, "DELETE FROM credit_request_entity");
        runner.update(conn, "DELETE FROM order_entity");
        runner.update(conn, "DELETE FROM payment_entity");
    }

}
