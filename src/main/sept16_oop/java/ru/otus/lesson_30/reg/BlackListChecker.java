package sept16_oop.java.ru.otus.lesson_30.reg;

import java.util.regex.Pattern;

public class BlackListChecker {

    public Pattern prepareChecker(String[] values) {
        String ptrStr = "";

        for (int i = 0; i < values.length; i++) {

            String tmpPtr = values[i];
            tmpPtr = tmpPtr.replaceAll("\\+", "\\" + "\\" + "+");

            ptrStr = ptrStr + tmpPtr;
            if (i < values.length - 1) {
                ptrStr = ptrStr + "|";
            }
        }

        // 123|456|789

        Pattern pattern = Pattern.compile(ptrStr.toString());
        return pattern;
    }
}
