package sept16_oop.canteen;

import sept16_oop.canteen.exceptions.CapacityIfOverException;
import sept16_oop.canteen.exceptions.NoAvailablePortionsException;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Random;
import java.util.Scanner;

public class CanteenManager {

    public static void main(String[] args)  {

        System.out.println("name the canteen: ");
        Canteen canteen = new Canteen(100, requestWord());

        Random random = new Random();
        while (true) {
            try {
                int currentNumberOfVisitors = canteen.getNumberOfVisitors();
                System.out.println("Начался очередной час. Посетителей в столовой: " + currentNumberOfVisitors);

                int visitors = random.nextInt(5);
                System.out.println("enter the number of visiting users: ");
                canteen.visit(getUserNumber());
                System.out.println("enter the number of leaveing users: ");
                canteen.leave(getUserNumber());
                generateRandomVisitorsLeavers(canteen);

                for (int i=1; i<=visitors; i++) {
                    int dishIndex = random.nextInt(Dish.values().length);
                    Dish dish = Dish.values()[dishIndex];
                    canteen.orderDish(dish);
                }
                generateRandomDish(canteen);
                Thread.sleep(1000);
            } catch (CapacityIfOverException e) {
                System.out.println(e.getMessage());
            } catch (NoAvailablePortionsException e) {
                System.out.println(e.getMessage());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void generateRandomDish(Canteen canteen) {
        Random random = new Random();
        int dishIndex = random.nextInt(Dish.values().length);
        Dish dish = Dish.values()[dishIndex];
        Integer integer = canteen.getDishesNumber().get(dish);
        canteen.getDishesNumber().put(dish, ++integer);
    }

    private static void generateRandomVisitorsLeavers(Canteen canteen) {
        Random random = new Random();
        int leavers = random.nextInt(5);
        int numberOfVisitorsBefore = canteen.getNumberOfVisitors();
        canteen.setNumberOfVisitors(numberOfVisitorsBefore - leavers);
    }

    public static int getUserNumber() {
        Scanner sc = new Scanner(System.in);
        boolean isNumber;
        int number = 0;
        do {
            if(sc.hasNextInt()) {
                number = sc.nextInt();
                isNumber = false;
            } else {
                sc.next();
                System.out.println("it's not a number");
                isNumber = true;
            }
        } while (isNumber);
        return number;
    }

    static String requestWord() {
        Scanner scanner = new Scanner(System.in);
        String str = "";
        boolean isGoodInput = false;
        do {
            if (scanner.hasNextLine()) {
                str = scanner.nextLine();
                isGoodInput = str != null && !str.isEmpty() && !str.trim().isEmpty();
            }
        } while (!isGoodInput);
        return str;
    }
}
