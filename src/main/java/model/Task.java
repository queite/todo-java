package model;

import java.util.Date;

public class Task {
	private int id;
	private int idProject;
	private String name;
	private String description;
	private String notes;
	private boolean inCompleted;
	private Date deadline;
	private Date createdAt;
	private Date updatedAt;
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getIdProject() {
		return idProject;
	}


	public void setIdProject(int idProject) {
		this.idProject = idProject;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getNotes() {
		return notes;
	}


	public void setNotes(String notes) {
		this.notes = notes;
	}


	public boolean isInCompleted() {
		return inCompleted;
	}


	public void setInCompleted(boolean inCompleted) {
		this.inCompleted = inCompleted;
	}


	public Date getDeadline() {
		return deadline;
	}


	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}


	public Date getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


	public Date getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}


	@Override
	public String toString() {
		return "Task [id=" + id + ", idProject=" + idProject + ", name=" + name + ", description=" + description
				+ ", notes=" + notes + ", inCompleted=" + inCompleted + ", deadline=" + deadline + ", createdAt="
				+ createdAt + ", updatedAt=" + updatedAt + "]";
	}
	
}
