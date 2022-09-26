package sept16_oop.calendar_impl;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class CalendarStarter {
    public static void main(String[] args) {


        List<Employee> employeeList = new ArrayList<>();
        Employee employee = new Employee(
                "Иванов Иван Иванович",
                'М',
                LocalDateTime.of(2000,
                        Month.JULY, 29, 19, 30, 40),
                "88005553535",
                "ivan@ya.ru"
        );
        employee = new Employee(
                "Пертов Петр Петрович",
                'М',
                LocalDateTime.of(1995,
                        Month.JULY, 20, 19, 30, 40),
                "88005553535",
                "ivan@ya.ru"
        );
        employee = new Employee(
                "Иванов Иван Иванович",
                'М',
                LocalDateTime.of(2000,
                        Month.JULY, 29, 19, 30, 40),
                "88005553535",
                "ivan@ya.ru"
        );
        employeeList.add(employee);

/*        private String credentials;
        private String sex;
        private LocalDateTime birthday;
        private String phoneNumber;
        private String email;*/
    }
}
