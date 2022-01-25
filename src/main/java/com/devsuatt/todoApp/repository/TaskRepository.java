package com.devsuatt.todoApp.repository;

import com.devsuatt.todoApp.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, String> {


}
