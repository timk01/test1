package sept16_oop.java.ru.otus.lesson_30;

import sept16_oop.java.ru.otus.lesson_30.reg.BlackListChecker;
import sept16_oop.java.ru.otus.lesson_30.reg.PhoneParser;
import sept16_oop.java.ru.otus.lesson_30.util.FileReader;

import java.io.InvalidObjectException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws InvalidObjectException {

        FileReader fr = new FileReader();
        String[] blackListPhones = fr.readAllFileLines("black_list.csv");

        PhoneParser phoneParser = new PhoneParser();
        for (String phone:blackListPhones) {
            if (!phoneParser.isPhoneNumber(phone)){
                throw new InvalidObjectException("Строка не соответсвует шаблону номера телефона");
            }
        }

        BlackListChecker blackListChecker = new BlackListChecker();
        Pattern blackListPattern = blackListChecker.prepareChecker(blackListPhones);

        Scanner sc = new Scanner(System.in);

        String userNumber = sc.nextLine();
        boolean isExit = false;
        while (!isExit) {
            if (userNumber.equals("exit")) {
                isExit = true;
                continue;
            }

            boolean isAvailable = blackListPattern.matcher(userNumber).matches();
            if (isAvailable) {
                System.out.println("номер не доступен");
            } else {
                System.out.println("номер доступен");
            }
            userNumber = sc.nextLine();
        }

    }
}
