import java.sql.*;

public class DatabaseConnection {
   static String usr,passWord;
   static boolean found;
    static String url = "jdbc:mysql://localhost:3306/snakegame";
    static String username="root";
    public static void record(String userName,String password ){
        // Database credentials


        try {
            // Step 1: Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection
            Connection connection = DriverManager.getConnection(url, username,"");

            // Step 3: Create a statement
            Statement statement = connection.createStatement();

            // Step 4: Execute a query (Example: Retrieving data)
            String query = "SELECT * FROM users";
            ResultSet resultSet = statement.executeQuery(query);

            // Step 5: Process the result
            while (resultSet.next()) {
                usr= resultSet.getString("username");
                passWord = resultSet.getString("password");
                // processing
                if(usr.equals(userName) && passWord.equals(password)){
                   new GameFrame();
                }
            }

            // Step 6: Close the resources
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public boolean keepRecord(String userName,String email, String passWord){

    }
}

