package repository;

import domain.*;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;

public class TransactionsDB extends DBconnection{
    public TransactionsDB(HashMap<Integer, Incomes> incomes, HashMap<Integer, Expenses> expenses, int userID) {
        super(incomes, expenses,userID);
    }
    //TODO: Implement an interface transaction with objects like Expense and Income



    @Override
    public void fetchData() {
        try(Connection connection = DriverManager.getConnection(URL);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Wires");){
            while(resultSet.next()){
                if(resultSet.getInt("type")==1){
                    Incomes income = new Incomes(resultSet.getInt("amount"),StringToPeriod(resultSet.getString("period")), stringToLocalDateTime(resultSet.getString("date")), resultSet.getInt("userID"));
                    if(income.getUserID()==userID)
                        incomes.put(resultSet.getInt("wire__pk"),income);
                }
                else{
                    Expenses expense = new Expenses(resultSet.getInt("amount"),StringToPeriod(resultSet.getString("period")),stringToLocalDateTime(resultSet.getString("date")), resultSet.getInt("userID"));
                    if(expense.getUserID()==userID){
                        expenses.put(resultSet.getInt("wire__pk"),expense);
                    }
                }

            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void putDataIncome(Incomes income) {
        try(Connection connection = DriverManager.getConnection(URL);
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Wires (userID,amount,period,date,type) VALUES (?,?,?,?,?)")){
                preparedStatement.setInt(1,income.getUserID());
                preparedStatement.setInt(2,income.getAmount());
                preparedStatement.setString(3,PeriodToString(income.getPeriod()));
                preparedStatement.setString(4,localDateTimeToString(income.getDateTime()));
                preparedStatement.setInt(5,1);
                preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public void putDataExpenses(Expenses expense) {
        try(Connection connection = DriverManager.getConnection(URL);
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Wires (userID,amount,period,date,type) VALUES (?,?,?,?,?)")){
            preparedStatement.setInt(1,expense.getUserID());
            preparedStatement.setInt(2,expense.getAmount());
            preparedStatement.setString(3,PeriodToString(expense.getPeriod()));
            preparedStatement.setString(4,localDateTimeToString(expense.getDateTime()));
            preparedStatement.setInt(5,1);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
    @Override
    public void deleteData() {

    }

    @Override
    public void update() {
        try(Connection connection = DriverManager.getConnection(URL);
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Wires SET amount=?, period=?, date=?, type=? WHERE wire__pk=?");){

        }catch (SQLException e){
            e.printStackTrace();
        }
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
    public String PeriodToString (Period period){
        if(period == Period.DAILY){
            return "DAILY";
        }
        else if (period == Period.MONTHLY){
            return "MONTHLY";
        }
        else{
            return "YEARLY";
        }
    }
    public static LocalDateTime stringToLocalDateTime(String dateTimeString) {
        String pattern = "yyyy-MM-dd";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        try {
            return LocalDateTime.parse(dateTimeString, formatter);
        } catch (DateTimeParseException e) {
            System.out.println("got: " + dateTimeString);
            System.out.println("Invalid date-time format: " + e.getMessage());
            return null;
        }
    }
    public static String localDateTimeToString(LocalDateTime localDateTime) {
        String pattern = "yyyy-MM-dd";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return localDateTime.format(formatter);
    }
}
