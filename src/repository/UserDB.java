package repository;

import domain.Expenses;
import domain.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserDB extends DBconnection{
    private List<User> users = new ArrayList<>();

    @Override
    public void fetchData() {
        try(Connection connection = DriverManager.getConnection(URL);
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

    @Override
    public void putData() {

    }

    @Override
    public void deleteData() {

    }

    @Override
    public void update() {

    }
}
