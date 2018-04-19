package com.softserve.edu.jwtsecurity.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public void addTask(@RequestBody TaskEntity taskEntity){
        taskService.createTask(taskEntity);
    }

    @GetMapping
    private List<TaskEntity> getAllTasks(){
        return taskService.getAllTasks();
    }

    @PutMapping("/{id}")
    private void editTask(@PathVariable Long id, @RequestBody TaskEntity taskEntity){
        TaskEntity currentTask =  taskService.getTask(id);
        currentTask.setDescription(taskEntity.getDescription());
        taskService.updateTask(currentTask);
    }

    @DeleteMapping("/{id}")
    private void deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
    }

}
