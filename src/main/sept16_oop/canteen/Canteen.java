package sept16_oop.canteen;

import sept16_oop.canteen.exceptions.CapacityIfOverException;
import sept16_oop.canteen.exceptions.NoAvailablePortionsException;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Canteen {

    private final int capacity;
    private int numberOfVisitors;
    private String canteenName;

    private final Map<Dish, Integer> dishesNumber = new HashMap<>();

    public Canteen(int capacity, String canteenName) {
        this.capacity = capacity;
        this.canteenName = canteenName;

        for (Dish dish: Dish.values()) {
            dishesNumber.put(dish, 10);
        }
    }

    public int getNumberOfVisitors() {
        return numberOfVisitors;
    }

    public void setNumberOfVisitors(int numberOfVisitors) {
        this.numberOfVisitors = numberOfVisitors;
    }

    public void orderDish(Dish dish) throws NoAvailablePortionsException {
        int availablePortions = dishesNumber.get(dish);
        if (availablePortions == 0) {
            throw new NoAvailablePortionsException();
        }
        availablePortions--;
        dishesNumber.put(dish, availablePortions);
        System.out.println("Заказна новая порция " + dish.russianName);
    }

    public void visit(int numberOfNewVisitors) throws CapacityIfOverException {
        if ((numberOfVisitors + numberOfNewVisitors) > capacity) {
            throw new CapacityIfOverException("Слишком много посетителей");
        }
        numberOfVisitors += numberOfNewVisitors;
        System.out.println("Теперь в столовой " + numberOfVisitors + " посетителей");
    }

    public void leave(int numberOfLeeavingVisitors) throws CapacityIfOverException {
        if ((numberOfVisitors - numberOfLeeavingVisitors) < 0) {
            throw new CapacityIfOverException("Слишком мало посетителей");
        }
        numberOfVisitors -= numberOfLeeavingVisitors;
        System.out.println("Теперь в столовой " + numberOfVisitors + " посетителей");
    }

    public Map<Dish, Integer> getDishesNumber() {
        return dishesNumber;
    }
}
