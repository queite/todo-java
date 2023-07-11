package model;

import java.util.Date;

public class Project {
	private int id;
	private String name;
	private String description;
	private Date createdAt;
	private Date updateddAt;
	
	public Project(int id, String name, String description, Date createdAt, Date updateddAt ) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.createdAt = createdAt;
		this.updateddAt = updateddAt;
	}
	
	public Project( ) {
		this.createdAt = new Date();
		this.updateddAt = new Date();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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

	public Date getUpdatedAt() {
		return updateddAt;
	}

	public void setUpdatedAt(Date updateddAt) {
		this.updateddAt = updateddAt;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	@Override
	public String toString() {
	    return "Project [id=" + id + ", name=" + name + ", description=" + description +
	           ", createdAt=" + createdAt + ", updatedAt=" + updateddAt + "]";
	}

	
	
}
