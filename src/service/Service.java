package service;


import controller.Controller;

public class Service {
    private Controller controller;
    private int userID;
    public Service(int userID){
        this.userID = userID;
        controller = new Controller(userID);
    }
}
