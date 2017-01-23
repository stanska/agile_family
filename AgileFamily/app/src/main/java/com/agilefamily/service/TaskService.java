package com.agilefamily.service;

import com.agilefamily.domain.Task;
import com.agilefamily.domain.TaskStatus;
import com.agilefamily.domain.Deadline;
import java.util.ArrayList;

public class TaskService {

    public static ArrayList<Task> tasks = new ArrayList<Task>();

    public TaskService() {
        tasks.add(new Task("Да почистя стаята", null, null));
        tasks.add(new Task("Боклука", null, null));
        tasks.add(new Task("Домашното", null, null));
        tasks.add(new Task("Дрехи", null, null));
        tasks.add(new Task("Чанта", null, null));
        tasks.add(new Task("Зъби", null, null));
        tasks.add(new Task("Пижама", null, null));
        tasks.add(new Task("Риби", null, null));
        tasks.add(new Task("Гуш", null, null));
        tasks.add(new Task("Бюро и много дълъг текст.", null, null));
    }

    public void newTask(Task task) {
        tasks.add(task);
    }

    public Task[] getTasks() {
        Task[] tasksArray = new Task[tasks.size()];
        tasksArray = tasks.toArray(tasksArray);
        return tasksArray;
    }
}
