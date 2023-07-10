package model;

import java.util.Date;

public class Task {
	private int id;
	private int idProject;
	private String name;
	private String description;
	private String notes;
	private boolean Completed;
	private Date deadline;
	private Date createdAt;
	private Date updatedAt;
	
	public Task(int id, int idProject, String name, String description, String notes, boolean completed, Date deadline,
			Date createdAt, Date updatedAt) {
		super();
		this.id = id;
		this.idProject = idProject;
		this.name = name;
		this.description = description;
		this.notes = notes;
		Completed = completed;
		this.deadline = deadline;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	
	public Task() {
		this.createdAt = new Date();
	}


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


	public boolean getCompleted() {
		return Completed;
	}


	public void setCompleted(boolean Completed) {
		this.Completed = Completed;
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
				+ ", notes=" + notes + ", inCompleted=" + Completed + ", deadline=" + deadline + ", createdAt="
				+ createdAt + ", updatedAt=" + updatedAt + "]";
	}
	
}
