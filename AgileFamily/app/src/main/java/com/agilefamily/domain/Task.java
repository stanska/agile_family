package com.agilefamily.domain;

public class Task {
    public Deadline deadline;
    public User owner;
    public String name;
    public TaskStatus taskStatus;

    public Task(String name, User owner, Deadline deadline) {
        this.name = name;
        this.owner = owner;
        this.deadline = deadline;
        this.taskStatus = TaskStatus.DUE;
    }

    public String toString() {
        return name;
    }
}
