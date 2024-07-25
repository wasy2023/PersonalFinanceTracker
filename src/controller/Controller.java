package controller;

import domain.*;
import repository.TransactionsDB;
import repository.UserDB;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Controller {
    private final UserDB usersList = new UserDB() ;
    private final TransactionsDB transactionsDB = new TransactionsDB(new HashMap<>(),new HashMap<>(),0);
    private User currentUser;
    private List<Incomes> incomes = new ArrayList<>();
     private List<Expenses> expenses = new ArrayList<>();
    public Controller(int userID){
        for(User user : usersList.users){
            if(user.getID() == userID){
                currentUser = user;
                break;
            }
        }
        List<Transaction> transactions = new ArrayList<>();
        for(Transaction transaction : transactions){
            if(transaction.getType()==TransactionType.EXPENSE){
                expenses.add((Expenses) transaction);
            }
            else{
                incomes.add((Incomes) transaction);
            }
        }
    }
}
