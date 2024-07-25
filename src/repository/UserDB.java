package repository;

import domain.Expenses;
import domain.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserDB {
    public List<User> users = new ArrayList<>();

    public UserDB(){
        fetchData();
    }
    public void fetchData() {
        try(Connection connection = DriverManager.getConnection("jdbc:sqlite:identifier.sqlite");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM User");){
            while(resultSet.next()) {
                User user = new User(resultSet.getInt("balance"),resultSet.getInt("Id"));
                users.add(user);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
    public void putData() {

    }
    public void deleteData() {

    }
    public void update() {

    }
}
