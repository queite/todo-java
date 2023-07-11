package com.todo.todo;

import java.util.List;

import controller.ProjectController;
import model.Project;

public class App 
{
    public static void main( String[] args ) {
    	
    	ProjectController projectController = new ProjectController();
    	
    	Project project = new Project();
    	project.setName("Projeto teste");
    	project.setDescription("uma descrição qualquer");
    	projectController.save(project);

    	project.setName("Segundo nome");
    	projectController.update(project);
    	
    	List<Project> projects = projectController.getAll();
    	System.out.println("Total de projetos " + projects.size());
    	System.out.println(projects);
    }
}
