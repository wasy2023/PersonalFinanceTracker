package repository;

import domain.Expenses;
import domain.Identifiable;
import domain.Incomes;

import java.util.HashMap;

public abstract class DBconnection extends MemoryRepo {
    protected String URL = "jdbc:sqlite:identifier.sqlite";

    public DBconnection(HashMap<Integer, Incomes> incomes, HashMap<Integer, Expenses> expenses, int userID) {
        super(incomes, expenses,userID);
    }

    public abstract void fetchData();
    public abstract void putDataIncome(Incomes income);
    public abstract void putDataExpenses(Expenses expense);
    public abstract  void deleteData();
    public abstract void update();

}
