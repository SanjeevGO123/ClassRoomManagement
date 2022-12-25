import connect.mysql.MySQLConnectivity;
import java.sql.SQLException;

public class MySQLTest {
    public static void main(String[] args) {
        try {
            MySQLConnectivity.TestConnectivity();
        }
        catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
