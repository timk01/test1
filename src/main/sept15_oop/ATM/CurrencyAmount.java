package sept15_oop.ATM;

import java.util.Random;

public class CurrencyAmount {
    private Currency currency;
    private long quantity;

    public CurrencyAmount(Currency currency, int quantity) {
        this.currency = currency;
        this.quantity = quantity;
    }

    public CurrencyAmount() {

    }

    public static CurrencyAmount[] generateRandomCurrencyAmount(int maxAmount, int minAmount) {
        Currency[] values = Currency.values();
        CurrencyAmount[] currencyAmounts = new CurrencyAmount[values.length];
        for (int i = 0; i < values.length; i++) {
            currencyAmounts[i] = new CurrencyAmount(values[i]
                    , new Random()
                    .nextInt(maxAmount - minAmount + 1) + minAmount);
        }
        return currencyAmounts;
    }

    public static long getCurrencyAmountArrayValue(CurrencyAmount[] currencyAmounts) {
        long sum = 0;
        for (CurrencyAmount currencyAmount : currencyAmounts) {
            sum += currencyAmount.getQuantity() * currencyAmount.getCurrency().getValue();
        }
        return sum;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CurrencyAmount{" +
                "currency=" + currency +
                ", quantity=" + quantity +
                '}';
    }
}
