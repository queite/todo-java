package com.todo.todo;
import java.util.Date;
import java.util.List;

import controller.ProjectController;
import controller.TaskController;
import model.Project;
import model.Task;

public class App 
{
    public static void main( String[] args ) {
    	
    	ProjectController projectController = new ProjectController();
    	
    	Project project = new Project();
    	project.setName("Projeto teste");
    	project.setDescription("uma descrição qualquer");
    	projectController.save(project);

    	project.setId(1);
    	project.setName("Segundo nome");
    	projectController.update(project);
    	
    	
    	
    	List<Project> projects = projectController.getAll();
    	System.out.println(projects.size());
    	projectController.removeById(projects.size());
    	System.out.println("Total de projetos " + projects.size());
    	System.out.println(projects);
    	
    	TaskController taskController = new TaskController();
    	
    	Task task = new Task(1, "task1", "decription", "notes", 0, new Date(2023-8-28), new Date(), new Date());
    	System.out.println(task);
    	taskController.save(task);
    	
    	task.setId(1);
    	task.setName("outro nome");
    	taskController.update(task);
    	
    	
    	List<Task> tasks = taskController.getAll(1);
    	taskController.removeById(tasks.size());
    	System.out.println("Total de tarefas no projeto " + tasks.size());
    	System.out.println(tasks);
	}
}
