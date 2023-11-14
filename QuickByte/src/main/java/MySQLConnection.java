import java.sql.*;

public class MySQLConnection {
    public static void main(String[] args) {
        // JDBC URL, username, and password of MySQL server
        String url = "jdbc:mysql://192.168.14.30:3306/your_database";
        String user = "Admin";
        String password = "oprisiuESmardoi123$";

        try {
            // Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open a connection
            Connection connection = DriverManager.getConnection(url, user, password);

            // Do something with the connection (e.g., execute SQL queries)
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Users");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("firstName"));
            }

            // Close the connection
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
