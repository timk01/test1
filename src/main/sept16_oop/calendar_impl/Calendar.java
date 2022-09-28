package sept16_oop.calendar_impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class Calendar {
    private Map<LocalDateTime, List<TimeCell>> tableForTimeAndEvent;

    public Calendar(Map<LocalDateTime, List<TimeCell>> tableForTimeAndEvent) {
        this.tableForTimeAndEvent = tableForTimeAndEvent;
    }

    public Event createEvent() {
        return null;
    }

    public String sendNotificationToEmployee() {
        return new String();
    }

    public Event changeEvent() {
        return null;
    }

    public Map<LocalDateTime, Event> getTableForTimeAndEvent() {
        return tableForTimeAndEvent;
    }
}