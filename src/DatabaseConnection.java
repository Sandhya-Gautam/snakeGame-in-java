import javax.swing.*;
import java.sql.*;

public class DatabaseConnection {
   static String usr,passWord;
    static String url = "jdbc:mysql://localhost:3306/snakegame";
    static String username="admin";
    public static void record(String userName,String password ){
        // Database credentials

            int count=0;
        try {
            // Step 1: Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection
            Connection connection = DriverManager.getConnection(url, username,"admin123");

            // Step 3: Create a statement
            Statement statement = connection.createStatement();

            // Step 4: Execute a query (Example: Retrieving data)
            String query = "SELECT * FROM userDetails";
            ResultSet resultSet = statement.executeQuery(query);

            // Step 5: Process the result
            while (resultSet.next()) {
                usr= resultSet.getString("username");
                passWord = resultSet.getString("password");
                // processing
                if(usr.equals(userName) && passWord.equals(password)){
                    count++;
                }

            }
            if(count>0){
                new GameFrame();
            }
            // Step 6: Close the resources
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public boolean keepRecord(String userName,String email, String passWord) {
        int rowsAffected=0,count=0;
        try {
            // Step 1: Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection
            Connection connection = DriverManager.getConnection(url, username, "admin123");
            // Step 3: Create a statement
            PreparedStatement stmt = connection.prepareStatement("select count(email) from userDetails where email=?");
            stmt.setString(1,email);
            // Step 4: Execute a query (Example: Retrieving data)
            ResultSet resultSet = stmt.executeQuery();
            resultSet.next();
            int i=resultSet.getInt(1);
           if(i==0){
            // Step 3: Create a statement
            PreparedStatement statement = connection.prepareStatement("insert into userDetails(username,email,password) values(?,?,?)");

            // Step 4: Execute a query (Example: Retrieving data)
            statement.setString(1,userName);
            statement.setString(2,email);
            statement.setString(3,passWord);
            rowsAffected= statement.executeUpdate();
            // Step 6: Close the resources
            statement.close();
            connection.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        if(rowsAffected>0){
            return true;
        }else {
            return false;
        }
    }
}

