package repository;

import domain.Expenses;
import domain.Identifiable;
import domain.Incomes;

import java.util.Collection;
import java.util.HashMap;

public class MemoryRepo{
    protected int userID;
    protected HashMap<Integer, Incomes> incomes;
    protected HashMap<Integer, Expenses> expenses;

    public MemoryRepo(HashMap<Integer, Incomes> incomes, HashMap<Integer, Expenses> expenses, int userID) {
        this.incomes = incomes;
        this.expenses = expenses;
        this.userID = userID;
    }

    public HashMap<Integer, Incomes> getIncomes() {
        return incomes;
    }

    public void setIncomes(HashMap<Integer, Incomes> incomes) {
        this.incomes = incomes;
    }

    public HashMap<Integer, Expenses> getExpenses() {
        return expenses;
    }

    public void setExpenses(HashMap<Integer, Expenses> expenses) {
        this.expenses = expenses;
    }
}
