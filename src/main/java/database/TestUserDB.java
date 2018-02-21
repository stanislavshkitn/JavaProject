package database;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Formatter;

import model.TestUser;

public class TestUserDB extends BaseConnectToMySQL {
    public static ArrayList<TestUser> getAllTestUser(){
        toConnect();
        ArrayList <TestUser> userArrayList = new ArrayList<TestUser>();
        try {
            String query = "select * from tbl_user";
            statement = connect.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                TestUser user = new TestUser();
                user.setId(resultSet.getInt("id"));
                user.setFirst_name(resultSet.getString("first_name"));
                user.setLast_name(resultSet.getString("last_name"));
                user.setAge(resultSet.getInt("age"));
                user.setNumber(resultSet.getString("number"));
                user.setGroup(resultSet.getInt("groupe"));
                userArrayList.add(user);
            }
        }catch (SQLException e){
            System.out.print("(error) While working with database 1");
            e.printStackTrace();
        }finally {
            try {
                statement.close();
                resultSet.close();
            }catch (SQLException e){
                System.out.print("(error) While working with database 2");
                e.printStackTrace();
            }
        }
        return userArrayList;
    }

    public static void createToDB(TestUser user){
        toConnect();
        try {
            String first_name = user.getFirst_name();
            String last_name = user.getLast_name();
            int age = user.getAge();
            String number = user.getNumber();
            int group = user.getGroup();

            String query = String.format("INSERT INTO tbl_user (first_name, last_name, age," +
                    "number, groupe) VALUES ('%s', '%s', %d, '%s', %d)", first_name, last_name,
                    age, number, group);
            System.out.print(query);
            statement = connect.createStatement();
            statement.executeUpdate(query);

        }catch (SQLException e){
            System.out.print("(error) While working with database 3");
            e.printStackTrace();
        }finally {
            try {
                statement.close();
                resultSet.close();
            }catch (SQLException e){
                System.out.print("(error) While working with database 4");
                e.printStackTrace();
            }finally{
                toDisconnect();
            }
        }

    }
    }

