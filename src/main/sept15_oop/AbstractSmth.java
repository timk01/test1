package sept15_oop;

public class AbstractSmth {

/*    public AbstractSmth() {

    }*/
}

class ConcreteSmth extends AbstractSmth {

    public ConcreteSmth() {

    }

    public static void main(String[] args) {
        AbstractSmth abstractSmth = new ConcreteSmth();
    }
}
