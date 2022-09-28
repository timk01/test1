package sept15_oop.ATM;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import static sept15_oop.ATM.CommonInterface.requestNumber;

public class ATMEngine {

    private static final int MAX_CURRENCY_IN_VALET = 4;
    private static final int MIN_CURRENCY_IN_VALET = 2;
    private static final int MAX_CURRENCY_IN_ATM = 40;
    private static final int MIN_CURRENCY_IN_ATM = 30;

    public static void main(String[] args) {
        CurrencyAmount[] currencyAmounts = CurrencyAmount
                .generateRandomCurrencyAmount(MAX_CURRENCY_IN_VALET, MIN_CURRENCY_IN_VALET);
        long sum = CurrencyAmount.getCurrencyAmountArrayValue(currencyAmounts);

        User user = new User(
                1,
                "Timur Khasmamedov",
                124_123_456_789_090_12L,
                1256,
                BigDecimal.valueOf(sum),
                new Balance(BigDecimal.valueOf(20000.0)),
                currencyAmounts
        );

        currencyAmounts = CurrencyAmount
                .generateRandomCurrencyAmount(MAX_CURRENCY_IN_ATM, MIN_CURRENCY_IN_ATM);
        sum = CurrencyAmount.getCurrencyAmountArrayValue(currencyAmounts);
        List<User> userList = new ArrayList<>();
        userList.add(user);

        ATM atm = new ATM(
                currencyAmounts,
                BigDecimal.valueOf(sum),
                userList);

        //System.out.println(atm);

        atm.showMainMenu();

        int number;
        boolean stop = true;
        boolean stopAdd;

        while (stop) {
            number = requestNumber();
            switch (number) {
                case 1:
                    if (atm.checkPinCode(user)) {
                        //tbh here... should be checking for REAL user, but //todo
                        atm.showAddMenu();
                        stopAdd = true;
                        while (stopAdd) {
                            number = requestNumber();
                            switch (number) {
                                case 1 -> {
                                    atm.showCurrentBalance(user);
                                    atm.showAddMenu();
                                }
                                case 2 -> {
                                    atm.getFunds(user);
                                    atm.showAddMenu();
                                }
                                case 3 -> {
                                    atm.putFundsOnAccount();
                                    atm.showAddMenu();
                                }
                                default -> {
                                    stopAdd = false;
                                    System.out.println("Return to main menu\n");
                                }
                            }
                        }
                    }
                    stop = false;
                    break;
                default:
                    stop = false;
                    System.out.println("Exit from main menu");
            }
        }
    }
}
