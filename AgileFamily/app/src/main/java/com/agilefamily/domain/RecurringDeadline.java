package com.agilefamily.domain;

import java.util.Date;

public class RecurringDeadline extends Deadline {
    public int repetitionInDays;
    public RecurringDeadline(Date start, Date end, Reminder reminder, int repetitionInDays) {
        super(start, end, reminder);
        this.repetitionInDays = repetitionInDays;
    }
}