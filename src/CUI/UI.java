package CUI;

import domain.User;

import java.util.concurrent.TimeUnit;

public class UI {
    private static User user = new User(345,1);
    public static void main(String[] args) throws InterruptedException {
        boolean currentSession = true;
        while(currentSession){
            clearCommand();
            showBalance();
            showMenu();
            TimeUnit.MILLISECONDS.sleep(500);
        }

    }
    public static void clearCommand(){
        System.out.println(new String(new char[50]).replace('\0', '\n'));
    }
    public static void showMenu(){
        System.out.println("Menu: ");
        System.out.println("1. Add new transaction");
        System.out.println("2. Remove old transaction");
        System.out.println("3. Show expenses");
        System.out.println("4. Show incomes");
        System.out.println("5. Update transaction");
    }
    public static void showBalance(){
        System.out.println("Current balance: " + user.getBalance());
    }

}
