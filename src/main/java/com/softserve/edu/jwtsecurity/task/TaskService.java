package com.softserve.edu.jwtsecurity.task;

import java.util.List;

public interface TaskService {

    List<TaskEntity> getAllTasks();

    void createTask(TaskEntity taskEntity);

    TaskEntity getTask(Long id);

    void updateTask(TaskEntity taskEntity);

    void deleteTask(Long id);
}
