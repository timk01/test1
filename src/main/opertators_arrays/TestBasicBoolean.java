package opertators_arrays;

public class TestBasicBoolean {

    public static void main(String[] args) {

    }

    private static void checkInversionPass() {
        BasicBooleanOperators basicBooleanOperators = new BasicBooleanOperators();
        boolean inversion = basicBooleanOperators.inversion(true);
        boolean expected = false;
        if (inversion == expected) {
            System.out.println("PASS " + "checkInversionPass())");
        } else {
            System.out.println("NOT " + "checkInversionPass())");
        }
    }

    private static void checkconjuctionPass() {
        BasicBooleanOperators basicBooleanOperators = new BasicBooleanOperators();
        boolean inversion = basicBooleanOperators.conjuction(true, false);
        boolean expected = false;
        if (inversion == expected) {
            System.out.println("PASS " + "checkconjuctionPass");
        } else {
            System.out.println("NOT " + "checkconjuctionPass");
        }
    }

}
