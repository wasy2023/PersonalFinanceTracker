package domain;

import java.time.LocalDateTime;

public abstract class Transaction implements Identifiable<TransactionType> {
    private int amount;
    private Period period;
    private LocalDateTime dateTime;
    private int userID;

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    public boolean setAmount(int amount) {
        this.amount = amount;
        return true;
    }

    public int getAmount(){
        return amount;
    }

}
