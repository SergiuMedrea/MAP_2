import java.sql.*;

public class MySQLConnection {
    public static void main(String[] args) {
        // JDBC URL, username, and password of MySQL server
        String ip = "192.168.14.30";
        String port = "3306";
        String database = "quickbytedb";
        String url = "jdbc:mysql://" + ip + ':' + port + '/' + database;
        String user = "Admin";
        String password = "oprisiuESmardoi123$";

        try {
            // Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open a connection
            Connection connection = DriverManager.getConnection(url, user, password);

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Users");

            while (resultSet.next()) {
                int userID = resultSet.getInt("userID");
                int addressID = resultSet.getInt("addressID");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String phoneNumber = resultSet.getString("phoneNumber");

                System.out.println("User ID: " + userID);
                System.out.println("Address ID: " + addressID);
                System.out.println("First Name: " + firstName);
                System.out.println("Last Name: " + lastName);
                System.out.println("Phone Number: " + phoneNumber);
                System.out.println("------------------------------");
            }


            // Close the connection
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
