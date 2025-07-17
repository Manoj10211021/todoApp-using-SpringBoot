package com.app.todoApp.repositories;

import com.app.todoApp.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Taskrepository  extends JpaRepository<Task,Long> {
}
