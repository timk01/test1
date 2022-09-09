package opertators_arrays;

import java.nio.CharBuffer;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

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

        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String b = scanner.nextLine();
        char[] ach = a.toCharArray();
        char[] bch = b.toCharArray();
        System.out.println(extracted(ach, bch));

      /*  String str = "_____";
        String regex = "^_+$";
        if (str.matches(regex)) {
            System.out.println("YES");
        }
        if ("____p".matches(regex)) {
            System.out.println("NO");
        }
        if ("k____".matches(regex)) {
            System.out.println("NO");
        }
        if ("__o_".matches(regex)) {
            System.out.println("NO");
        }
        if (Arrays.toString(new char[]{'_', '_'}).matches(regex)) {
            System.out.println("YES"); //doesn't work
        }
        if (new char[]{'_', '_'}.toString().matches(regex)) {
            System.out.println("YES"); //doesn't work either
        }
        char[] arr = new char[] {'_', '_'};
        System.out.println(Pattern.matches("^_+$", Arrays.toString(arr))); //no
        System.out.println(Pattern.matches("^_+$", new String(arr))); //no
        System.out.println(Pattern.matches("^_+$", CharBuffer.wrap(arr))); //yes baby*/
    }

/*        popka
        kapop
        akppp
        akopp
        kkkka*/

    //2
    private static boolean extracted(char[] ach, char[] bch) {
        int bchLength = bch.length;
        if (ach.length != 0 || bch.length != 0) {
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
        }
        return Pattern.matches("^_+$", CharBuffer.wrap(bch));
    }
}
