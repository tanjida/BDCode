import java.sql.*;

public class MysqlDemo {

    public static void main(String[]args) {
        String url = "jdbc:mysql://localhost:3306/fahimpnt";
        String user = "root";
        String password = "abcd1234";
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;



        try {
            // 1.  Establish a connection
            connection = DriverManager.getConnection(url, user, password);

            // 2. Create a statement
            statement = connection.createStatement();


            // 3. Execute the query
            String sql = "select * from Student";
            resultSet = statement.executeQuery(sql);

            System.out.println("First name is " + resultSet.getString("FIRST_NAME"));


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();

                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
    }
