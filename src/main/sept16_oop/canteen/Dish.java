package sept16_oop.canteen;

public enum Dish {
    MEAT("Мясо"),
    FISH("Рыба"),
    SALAD("Салат"),
    VEGETABLES("Овощи");

    String russianName;

    Dish(String russianName) {
        this.russianName = russianName;
    }
}
