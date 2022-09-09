package opertators_arrays;

import java.util.Scanner;

public class DZ {
    public static void main(String[] args) {
        String[] answerVariants1 = {"Yes", "No", "Not sure"};
        String[] answerVariants2 = {"Yes", "Doubt (but rather yes)", "Yes ?", "Rather no", "No!"};
        String[] answerVariants3 = {"+", "-", "?"};

        Scanner sc = new Scanner(System.in);

        String[] answers = new String[3];

        System.out.println("All clear? ");
        answers[0] = answerVariants1[sc.nextInt()];
        System.out.println("sure ? ");
        answers[1] = answerVariants2[sc.nextInt()];
        System.out.println("Definitely? ");
        answers[2] = answerVariants3[sc.nextInt()];

        for (String answer : answers) {
            System.out.println(answer);
        }
    }
}
