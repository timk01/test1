package sept16_oop.calendar_impl;

import java.time.LocalDateTime;
import java.util.List;

public class Event {
    private LocalDateTime date;
    private long length;
    private String theme;
    final private List<Employee> participants;
    private CellType eventType;

    public Event(LocalDateTime date, long length, String theme, List<Employee> participants, CellType eventType) {
        this.date = date;
        this.length = length;
        this.theme = theme;
        this.participants = participants;
        this.eventType = eventType;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public long getLength() {
        return length;
    }

    public void setLength(long length) {
        this.length = length;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public List<Employee> getParticipants() {
        return participants;
    }

    public CellType getEventType() {
        return eventType;
    }

    public void setEventType(CellType eventType) {
        this.eventType = eventType;
    }
}
