package opertators_arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //1

        /*Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String b = scanner.nextLine();
        char[] ach = a.toCharArray();
        char[] bch = b.toCharArray();
        Arrays.sort(ach);
        Arrays.sort(bch);
        System.out.println(Arrays.equals(ach, bch));

        System.out.println(extracted(ach, bch));*/
    }

/*    popka
      kapop*/

    //ka_op
    //pOpka
    //ka__p
    //_____

    //kot
    //tko --> t_o
    //t__

    //2
    private static boolean extracted(char[] ach, char[] bch) {
        int bchLength = bch.length;
        if (ach.length == bchLength) {
            for (int i = 0; i < ach.length; i++) {
                for (int j = 0; j < bchLength; j++) {
                    if (bch[j] == ach[i]) {
                        bch[j] = '_';
                        break;
                    }
                }
            }
        }
        return true;
    }
}
