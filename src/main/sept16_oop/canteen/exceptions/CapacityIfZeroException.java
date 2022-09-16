package sept16_oop.canteen.exceptions;

public class CapacityIfZeroException extends Exception {

    public CapacityIfZeroException(String errorMessage) {
        super(errorMessage);
    }
}
