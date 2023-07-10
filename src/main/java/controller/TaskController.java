package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
<<<<<<< HEAD
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
=======
import java.sql.SQLException;
>>>>>>> fd7300a33d3b8167259c4f9af79096adefb21b35
import java.util.List;

import model.Task;
import util.ConnectionFactory;

public class TaskController {
	
	public void save(Task task) throws SQLException {
		String sql = "INSERT INTO tasks (idProject"
				+ "name,"
				+ "description,"
				+ "completed,"
				+ "notes,"
				+ "deadline,"
				+ "createdAt"
				+ "updatedAt"
				+ ") VALUES (?,?,?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement statement = null;
		
		try {
			conn = ConnectionFactory.getConnection();
			statement = conn.prepareStatement(sql);
			statement.setInt(1, task.getIdProject());
			statement.setString(2, task.getName());
			statement.setString(3, task.getDescription());
			statement.setBoolean(4, task.getCompleted());
			statement.setString(5, task.getNotes());
			statement.setDate(6, new Date(task.getDeadline().getTime()));
			statement.setDate(7, new Date(task.getCreatedAt().getTime()));
			statement.setDate(8, new Date(task.getUpdatedAt().getTime()));
			statement.execute();
		} catch (SQLException e) {
			throw new SQLException("Erro ao salvar tarefa"
					+ e.getMessage(), e);
		} finally {
			ConnectionFactory.closeConnetion(conn);
		}
	}
	
	public void update(Task task) {
		
	}
	
	public void removeById(int taskId) throws SQLException {
		String sql = "DELETE FROM tasks WHERE id = ?";
		Connection conn = null;
		PreparedStatement statement = null;
		
		try {
			conn = ConnectionFactory.getConnection();
			statement = conn.prepareStatement(sql);
			statement.setInt(1, taskId);
			statement.execute();
		} catch (SQLException e) {
			throw new SQLException("Erro ao remover tarefa", e);
		} finally {
			ConnectionFactory.closeConnetion(conn);
		}
	}
	
	public List<Task> getAll(int idProject) {
<<<<<<< HEAD
		String sql = "SELECT * FROM tasks WHERE idProject = ?";
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		List<Task> tasks = new ArrayList<Task>();
		
		try {
			conn = ConnectionFactory.getConnection();
			statement = conn.prepareStatement(sql);
			statement.setInt(1, idProject);
			result = statement.executeQuery();
			
			while(result.next()) {
				Task task = new Task();
				task.setId(result.getInt("id"));
				task.setIdProject(idProject);
				task.setName(result.getString("name"));
				task.setDescription(result.getString("Description"));
				task.setNotes(result.getString("Notes"));
				task.setCompleted(result.getBoolean("completed"));
				task.setDescription(result.getString("Description"));
				task.setDeadline(result.getDate("deadline"));
				task.setCreatedAt(result.getDate("createdAt"));
				task.setUpdatedAt(result.getDate("updatedAt"));
				
				tasks.add(task);
			}
		}catch(Exception e) {
			
		}
=======
>>>>>>> fd7300a33d3b8167259c4f9af79096adefb21b35
		return null;		
	}
}
