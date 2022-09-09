/**
 * @author
 * Khasmamedov Timur
 * @see
 * написать программу подсчета доходности банковских вкладов:
 * на экран выводятся вопросы "какая сумма изначального вклада", "какая процентная ставка", "на какой срок планируется вклад".
 * Необходимо рассчитать доходность вклада на основе простой ставки и ставки с начислением.
 */

package package1;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Bank01 {


    public static final int DAYS_IN_YEAR = 365;
    public static final int SCALE = 5;
    public static final int FOUR = 4;

    public static void main(String[] args) {
        String str = "str";
        String substring = str.substring(1);
        System.out.println(str == substring);
        str.compareTo(substring);
        str.equals(substring);
        str.indexOf(1);

        System.out.println("All numbers should be non-negative and number!");
        System.out.println("enter the sum: ");
        int sum = getIntValue();
        System.out.println("now, enter the period in days: ");
        int periodInDays = getIntValue();
        System.out.println("lastly, enter the percent in days: ");
        BigDecimal percent = getPercentValue();

        System.out.println("Now, please enter the case: 1 - simple %, 2 - complex %, or anything else to exit");

        switch (getIntValue()) {
            case 1 -> System.out.println(getSimpleRate(sum, periodInDays, percent));
            case 2 -> System.out.println(getComplexRatePerQuarter(sum, percent));
            default -> System.out.println("woot-woot");
        }
    }

    public static int getIntValue() {
        Scanner sc = new Scanner(System.in);
        boolean isNumber;
        int number = 0;
        do {
            if(sc.hasNextInt()) {
                number = sc.nextInt();
                if (number >= 0) {
                    return number;
                }
                System.out.println("number must be non-negative");
            } else {
                sc.next();
                System.out.println("it's not a number");
            }
            isNumber = true;
        } while (isNumber);
        return number;
    }

    public static BigDecimal getPercentValue() {
        Scanner sc = new Scanner(System.in);
        boolean isNumber;
        BigDecimal number = BigDecimal.ZERO;
        do {
            if(sc.hasNextBigDecimal()) {
                number = sc.nextBigDecimal();
                if (number.compareTo(BigDecimal.ZERO) >= 0) {
                    return number;
                }
                System.out.println("number must be non-negative");
            } else {
                sc.next();
                System.out.println("it's not a number");
            }
            isNumber = true;
        } while (isNumber);
        return number;
    }

    public static BigDecimal getSimpleRate(int sum, int periodInDays, BigDecimal percentValue) {
        return percentValue.multiply(
                new BigDecimal(sum))
                .multiply(new BigDecimal(periodInDays))
                .divide(new BigDecimal(DAYS_IN_YEAR), SCALE, RoundingMode.CEILING);
    }

    public static BigDecimal getComplexRatePerQuarter(int sum, BigDecimal percentValue) {
        return (((percentValue.divide(BigDecimal.valueOf(100)).divide(
                        new BigDecimal(FOUR)).add(BigDecimal.ONE)).pow(3))
                .multiply(new BigDecimal(sum))).subtract(new BigDecimal(sum));
    }
}
