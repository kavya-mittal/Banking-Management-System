import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

    public class DBConnection {

        private static final String URL =
                "jdbc:mysql://localhost:3307/kavya";

        private static final String USER = "root";

        private static final String PASSWORD = "Kavya@1435";

        public static Connection getConnection()
                throws SQLException {

            return DriverManager.getConnection(
                    URL, USER, PASSWORD
            );
        }

        public static void main(String[] args) {

            try {
                Connection con = getConnection();

                System.out.println(
                        "Database Connected Successfully!"
                );

                con.close();

            } catch (SQLException e) {

                System.out.println(
                        "Database Connection Failed!"
                );

                e.printStackTrace();
            }
        }
    }
