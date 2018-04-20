package com.softserve.edu.jwtsecurity.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

//    @Autowired
//    private TaskRepository taskRepository;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public void addTask(@RequestBody TaskEntity taskEntity){
        taskService.createTask(taskEntity);
    }

    @GetMapping
    public List<TaskEntity> getAllTasks(){
        return taskService.getAllTasks();
    }

    @PutMapping("/{id}")
    public void editTask(@PathVariable Long id, @RequestBody TaskEntity taskEntity){
        TaskEntity currentTask =  taskService.getTask(id);
        currentTask.setDescription(taskEntity.getDescription());
        taskService.updateTask(currentTask);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
    }

}
