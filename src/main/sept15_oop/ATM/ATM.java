package sept15_oop.ATM;

import java.math.BigDecimal;
import java.util.*;

public class ATM {
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
        hashMapAdd.put(2, "Get funds");
        hashMapAdd.put(3, "Deposit funds");
        hashMapAdd.forEach((k, v) -> System.out.println(k + ". " + v));
        System.out.println("Please enter one number from menu above or any other positive number to exit:");
    }

    public void getFunds(User user) {

    }

    public void putFundsOnAccount() {

    }

    public void showCurrentBalance() {

    }

    public boolean checkPinCode(User user) {
        System.out.println("Enter pinCode, you have 3 tries total: ");
        int tries = 3;
        int number;
        boolean isPinCodeGood;
        StringBuilder msg = new StringBuilder();
        do {
            number = requestNumber();
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

    public int requestNumber() {
        Scanner scanner = new Scanner(System.in);
        int n = -1;
        boolean isGoodInput;
        do {
            if (scanner.hasNextInt()) {
                n = scanner.nextInt();
                scanner.nextLine();
                isGoodInput = n >= 0;
            } else {
                scanner.nextLine();
                isGoodInput = false;
            }
        } while (!isGoodInput);
        return n;
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

