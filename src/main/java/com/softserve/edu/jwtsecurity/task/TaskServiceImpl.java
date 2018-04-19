package com.softserve.edu.jwtsecurity.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskRepository taskRepository;

    @Override
    public List<TaskEntity> getAllTasks() {
       return taskRepository.findAll();
    }

    @Override
    public void createTask(TaskEntity taskEntity) {
        taskRepository.save(taskEntity);
    }

    @Override
    public TaskEntity getTask(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TASK " + id + " NOT EXISTS"));
    }

    @Override
    public void updateTask(TaskEntity taskEntity) {
        taskRepository.save(taskEntity);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
