package sept15_oop.ATM;

import java.math.BigDecimal;

public class Balance {
    private BigDecimal balance;

    public Balance(BigDecimal balance) {
        setBalance(balance);
    }

    public BigDecimal getBalance() {
        return balance;
    }

    private void setBalance(BigDecimal balance) {
        if (balance.compareTo(BigDecimal.ZERO) > 0) {
            this.balance = balance;
        }
    }

    @Override
    public String toString() {
        return "Balance{" +
                "balance=" + balance +
                '}';
    }
}
