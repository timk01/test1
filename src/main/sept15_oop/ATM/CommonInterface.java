package sept15_oop.ATM;

import java.util.Scanner;

public interface CommonInterface {
    static int requestNumber() {
        Scanner scanner = new Scanner(System.in);
        int n = -1;
        boolean isGoodInput;
        do {
            if (scanner.hasNextInt()) {
                n = scanner.nextInt();
                scanner.nextLine();
                isGoodInput = n >= 0;
            } else {
                scanner.nextLine();
                isGoodInput = false;
            }
        } while (!isGoodInput);
        return n;
    }
}
