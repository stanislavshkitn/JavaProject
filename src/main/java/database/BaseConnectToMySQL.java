package database;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseConnectToMySQL {
    protected static final String url = "jdbc:mysql://localhost:3306/db_java_project?characterEncoding=utf-8";
    protected static final String user = "user";
    protected static final String password = "user";

    protected static Connection connect = null;
    protected static Statement statement = null;
    protected static ResultSet resultSet = null;

    public static void toConnect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
           e.printStackTrace();
        }
        try {
            connect = DriverManager.getConnection(url, user, password);
        }catch (SQLException e){
            System.out.print("(error) Connecting to the database");
            e.printStackTrace();
        }
    }

    public static void toDisconnect() {
        try {
            connect.close();
        }catch (SQLException e){
            System.out.print("(error) Disconnecting to the database");
            e.printStackTrace();
        }
    }
}


