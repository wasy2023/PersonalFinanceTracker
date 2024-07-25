package repository;

import domain.Expenses;
import domain.Incomes;
import domain.Period;
import domain.Transaction;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TransactionsDB extends DBconnection{
    private final HashMap<Integer, List<Transaction>> transactions = new HashMap<>();
    @Override
    public void fetchData() {
        try(Connection connection = DriverManager.getConnection(URL);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM transaction");){
            while(resultSet.next()){
                int userId = resultSet.getInt("userID");
                if(resultSet.getInt("type")==1){
                    Incomes income = new Incomes(resultSet.getInt("amount"),StringToPeriod(resultSet.getString("period")), stringToLocalDateTime(resultSet.getString("date")));
                    if(transactions.containsKey(userId)){
                        transactions.get(userId).add(income);
                    }
                    else{
                        transactions.put(userId,new ArrayList<>());
                        transactions.get(userId).add(income);
                    }
                }
                else{
                    Expenses expense = new Expenses(resultSet.getInt("amount"),StringToPeriod(resultSet.getString("period")),stringToLocalDateTime(resultSet.getString("date")));
                    if(transactions.containsKey(userId)){
                        transactions.get(userId).add(expense);
                    }
                    else{
                        transactions.put(userId,new ArrayList<>());
                        transactions.get(userId).add(expense);
                    }
                }

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
    public Period StringToPeriod(String string){
        if(string == "DAILY"){
            return Period.DAILY;
        } else if (string == "MONTHLY") {
            return Period.MONTHLY;
        } else  {
            return Period.YEARLY;
        }
    }
    public static LocalDateTime stringToLocalDateTime(String dateTimeString) {
        String pattern = "dd-MM-yyyy";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        try {
            return LocalDateTime.parse(dateTimeString, formatter);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date-time format: " + e.getMessage());
            return null;
        }
    }
    public static String localDateTimeToString(LocalDateTime localDateTime) {
        String pattern = "dd-MM-yyyy";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return localDateTime.format(formatter);
    }
}
