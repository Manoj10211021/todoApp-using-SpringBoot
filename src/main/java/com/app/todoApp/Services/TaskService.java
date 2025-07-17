package com.app.todoApp.Services;

import com.app.todoApp.models.Task;
import com.app.todoApp.repositories.Taskrepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final Taskrepository taskrepository;

    public TaskService(Taskrepository taskrepository){
        this.taskrepository = taskrepository;
    }
    public List<Task> getAllTasks() {
        return taskrepository.findAll();
    }

    public void CreateTask(String title) {
        Task task = new Task();
        task.setTitle(title);
        task.setCompleted(false);
        taskrepository.save(task);
    }

    public void deleteTask(Long id) {
        taskrepository.deleteById(id);
    }

    public void toggleTask(Long id) {
        Task task = taskrepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid task id"));
        task.setCompleted(!task.isCompleted());
        taskrepository.save(task);

    }
}
