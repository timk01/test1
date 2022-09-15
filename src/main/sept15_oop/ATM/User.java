package sept15_oop.ATM;

import java.math.BigDecimal;
import java.util.Arrays;

public class User {
    private String credentials;
    private long cardNumber;
    private int pinCode;
    private BigDecimal cash;
    private Balance balance;
    private CurrencyAmount[] currencyAmount;

    public User(String credentials, long cardNumber, int pinCode, BigDecimal cash, Balance balance, CurrencyAmount[] currencyAmount) {
        this.credentials = credentials;
        this.cardNumber = cardNumber;
        this.pinCode = pinCode;
        this.cash = cash;
        this.balance = balance;
        this.currencyAmount = currencyAmount;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    public String getCredentials() {
        return credentials;
    }

    public void setCredentials(String credentials) {
        this.credentials = credentials;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public BigDecimal getCash() {
        return cash;
    }

    public void setCash(BigDecimal cash) {
        this.cash = cash;
    }

    public Balance getBalance() {
        return balance;
    }

    public void setBalance(Balance balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "User{" +
                "credentials='" + credentials + '\'' +
                ", cardNumber=" + cardNumber +
                ", pinCode=" + pinCode +
                ", cash=" + cash +
                ", balance=" + balance +
                ", \ncurrencyAmount=" + Arrays.toString(currencyAmount) +
                '}';
    }
}
