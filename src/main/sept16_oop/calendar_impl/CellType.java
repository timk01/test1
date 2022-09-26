package sept16_oop.calendar_impl;

public enum CellType {
    AVAILABLE("Доступно"),
    BOOKED("Занято"),
    UNAVAILABLE("Недоступно");

    private String state;

    CellType(String state) {
        this.state = state;
    }
}
