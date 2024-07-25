package domain;

import java.time.LocalDateTime;

public class Expenses extends Transaction {
    public Expenses(int amount, Period period, LocalDateTime dateTime, int userID) {
        this.setAmount(amount);
        this.setPeriod(period);
        this.setDateTime(dateTime);
        this.setUserID(userID);
    }

    @Override
    public TransactionType getType() {
        return TransactionType.EXPENSE;
    }

}
