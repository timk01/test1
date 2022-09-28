package sept15_oop.ATM;

import java.math.BigDecimal;
import java.util.*;

public class ATM implements CommonInterface{
    private CurrencyAmount[] currencyAmount;
    private BigDecimal cash;
    private List<User> userList;
    private int pinCode;
    Map<Integer, String> hashMapAdd = new HashMap<>();
    Map<Integer, String> hashMapMain = new HashMap<>();

    public ATM(CurrencyAmount[] currencyAmount, BigDecimal cash, List<User> userList) {
        this.currencyAmount = currencyAmount;
        this.cash = cash;
        this.userList = userList;
    }

    public CurrencyAmount[] getCurrencyAmount() {
        return currencyAmount;
    }

    public void setCurrencyAmount(CurrencyAmount[] currencyAmount) {
        this.currencyAmount = currencyAmount;
    }

    public BigDecimal getCash() {
        return cash;
    }

    public void setCash(BigDecimal cash) {
        this.cash = cash;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public void showMainMenu() {
        hashMapMain.put(1, "Enter pinCode");
        hashMapMain.forEach((k, v) -> System.out.println(k + ". " + v));
        System.out.println("Please enter one number from menu above or any other positive number to exit:");
    }

    public void showAddMenu() {
        hashMapAdd.put(1, "Show balance");
        hashMapAdd.put(2, "Get funds (should be >= 50)");
        hashMapAdd.put(3, "Deposit funds");
        hashMapAdd.forEach((k, v) -> System.out.println(k + ". " + v));
        System.out.println("Please enter one number from menu above or any other positive number to exit:");
    }

    public void getFunds(User user) {
        BigDecimal currentUserBalance = user.getBalance().getBalance();
        int withdrawNumber = CommonInterface.requestNumber();
        if (currentUserBalance.compareTo(BigDecimal.ZERO) < 0) {
            System.out.println("0 balance");
        } else if (withdrawNumber / 5000 > 0 && currentUserBalance.compareTo(BigDecimal.valueOf(5000L)) > 0) {
            int moneyLeftAfterWithdrawing = withdrawNumber % 5000;
            cash = cash.subtract(BigDecimal.valueOf(5000));

            int value = currencyAmount[5].getCurrency().getValue();
            long quantity = currencyAmount[5].getQuantity();

            currencyAmount[5].setQuantity(--quantity);
            System.out.println("after withdraw quantity " + quantity);
            System.out.println("after withdraw cash " + cash);
            if (withdrawNumber / 1000 > 0 && currentUserBalance.compareTo(BigDecimal.valueOf(1000L)) > 0) {
                moneyLeftAfterWithdrawing = withdrawNumber % 1000;
                cash = cash.subtract(BigDecimal.valueOf(1));

                value = currencyAmount[4].getCurrency().getValue();
                quantity = currencyAmount[4].getQuantity();

                currencyAmount[4].setQuantity(--quantity);
                System.out.println("after withdraw quantity " + quantity);
                System.out.println("after withdraw cash " + cash);
            }
        } else if (withdrawNumber % 50 != 0) {
            System.out.println("mimimal amount of sum should be >= 50");
        }
    }

    public void putFundsOnAccount() {

    }

    public void getLeftFunds(User user) {

    }

    public void showCurrentBalance(User user) {
        System.out.println(user.getBalance());
    }

    public boolean checkPinCode(User user) {
        System.out.println("Enter pinCode, you have 3 tries total: ");
        int tries = 3;
        int number;
        boolean isPinCodeGood;
        StringBuilder msg = new StringBuilder();
        do {
            number = CommonInterface.requestNumber();
            if (number == user.getPinCode()) {
                isPinCodeGood = true;
            } else {
                tries--;
                System.out.println(msg.append("Wrong number, you have ").append(tries).append(" tries"));
                isPinCodeGood = false;
            }
            msg.setLength(0);
        } while (!(isPinCodeGood) && tries > 0);
        return isPinCodeGood;
    }

    @Override
    public String toString() {
        return "ATM{" +
                "currencyAmount=" + Arrays.toString(currencyAmount) +
                "\n, cash=" + cash +
                ", user=" + userList +
                '}';
    }
}

