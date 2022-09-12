package opertators_arrays;

public class BasicBooleanOperators {
    public static void main(String[] args) {
        BasicBooleanOperators basicBooleanOperators = new BasicBooleanOperators();
        System.out.println(basicBooleanOperators.inversion(true));
        System.out.println(basicBooleanOperators.conjuction(true, false));
        System.out.println(basicBooleanOperators.disjunction(true, false));
        System.out.println(basicBooleanOperators.implication(true, false));
        System.out.println(basicBooleanOperators.equivalent(true, false));
    }

    public boolean inversion(boolean firstValue) {
        return !firstValue;
    }

    public boolean conjuction(boolean firstValue, boolean secondValue) {
        return firstValue && secondValue;
    }

    public boolean disjunction(boolean firstValue, boolean secondValue) {
        return firstValue || secondValue;
    }

    public boolean implication(boolean firstValue, boolean secondValue) {
        if (firstValue) {
            return secondValue;
        } else {
            return true;
        }
    }

    public boolean equivalent(boolean firstValue, boolean secondValue) {
        return firstValue == secondValue;
    }
}
