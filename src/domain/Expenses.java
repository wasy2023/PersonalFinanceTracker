package domain;

import java.time.LocalDateTime;

public class Expenses extends Transaction{
    public Expenses(int amount, Period period, LocalDateTime dateTime) {
        this.setAmount(amount);
        this.setPeriod(period);
        this.setDateTime(dateTime);
    }
}
