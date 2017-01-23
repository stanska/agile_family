package com.agilefamily.domain;


public class Reminder {
    public static final int MINUTES_BEFORE_DUE_DATE = 15;
    public int minutesBeforeDueDate;

    public Reminder(int minutesBeforeDueDate) {
        this.minutesBeforeDueDate = minutesBeforeDueDate;
    }
    public static Reminder defaultReminder() {
        return new Reminder(MINUTES_BEFORE_DUE_DATE);
    }
}
