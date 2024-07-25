package domain;

import java.time.LocalDateTime;

public class Incomes extends Transaction {
    public Incomes(int amount, Period period, LocalDateTime dateTime, int userID) {
        this.setAmount(amount);
        this.setPeriod(period);
        this.setDateTime(dateTime);
        this.setUserID(userID);
    }

    @Override
    public TransactionType getType() {
        return TransactionType.INCOME;
    }
}
