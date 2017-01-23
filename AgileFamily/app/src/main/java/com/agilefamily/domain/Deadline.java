package com.agilefamily.domain;

import java.util.Date;

public class Deadline {
    public Reminder reminder;
    public Date end;
    public Date start;

    public Deadline(Date start, Date end, Reminder reminder) {
        this.start = start;
        this.end = end;
        this.reminder = reminder;
    }
    public Deadline(Date end, Reminder reminder) {
        this(new Date(), end, reminder);
    }
    public Deadline(Date end) {
        this(end, Reminder.defaultReminder());
    }
}

