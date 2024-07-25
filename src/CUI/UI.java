package CUI;

import domain.User;
import service.Service;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class UI {
    private static User user = new User(345,1);
    public static void main(String[] args) throws InterruptedException {
        boolean currentSession = true;
        int command = 20;
        Scanner scanner = new Scanner(System.in);
        LogIn();
        Service service = new Service(scanner.nextInt());
        while(currentSession){
            clearCommand();
            showBalance();
            showMenu();
            command = scanner.nextInt();
            if(command==0){
                currentSession = false;
            }
            else if (command == 1){

            }
            TimeUnit.MILLISECONDS.sleep(1000);
        }

    }
    public static void LogIn(){
        System.out.println("Input credentials: (only userid for now) : ");
        System.out.println("id ...");
    }
    public static void clearCommand(){
        System.out.println(new String(new char[50]).replace('\0', '\n'));
    }
    public static void showMenu(){
        System.out.println("Menu: ");
        System.out.println("1. Add new Transaction");
        System.out.println("2. Remove old transaction");
        System.out.println("3. Show expenses");
        System.out.println("4. Show incomes");
        System.out.println("5. Update transaction");
        System.out.println(">>>");
    }
    public static void showBalance(){
        System.out.println("Current balance: " + user.getBalance());
    }

}
