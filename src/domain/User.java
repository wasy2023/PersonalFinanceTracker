package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class User {
    //TODO: user auth
    private String username;
    private String password;
    private int balance;
    private int ID;

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    private final HashMap<Integer,Expenses> transactions;

    public User(int balance,int ID, HashMap<Integer,Expenses> transactions){
        this.ID = ID;
        this.balance = balance;
        this.transactions = transactions;
    }

    public User(int balance, int ID) {
        this.ID = ID;
        this.balance = balance;
        this.transactions = new HashMap<>();
    }
    public User(){
        this.balance = 0;
        this.transactions = new HashMap<>();
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }




}
