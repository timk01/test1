package opertators_arrays;

import java.util.Scanner;

public class IfElseDemo {
    public static void main(String[] args) {
        System.out.println("Завтра отдыхаем? (1 - да, 0 - нет");
        Scanner sc = new Scanner("System.in");
        if (sc.hasNextInt()) {
            String str = sc.nextInt() == 1 ? "ура" : "не ура";
            System.out.println(str);
        }
        sc.close();
    }
}
