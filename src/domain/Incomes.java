package domain;

import java.time.LocalDateTime;

public class Incomes extends Transaction{
    public Incomes(int amount, Period period, LocalDateTime dateTime) {
        this.setAmount(amount);
        this.setPeriod(period);
        this.setDateTime(dateTime);
    }
}
