package sept16_oop.java.ru.otus.lesson_30.reg;

import java.util.regex.Pattern;

public class PhoneParser {
    private Pattern pattern = Pattern.compile("(\\+7|8)(\\d{3})(\\d{3}\\d{4})");

    public boolean isPhoneNumber(String phone) {
        String pn = phone.trim().replaceAll("\\s", "");
        return pattern.matcher(pn).matches();
    }
}
