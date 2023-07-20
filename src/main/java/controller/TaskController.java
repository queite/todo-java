package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Task;
import util.ConnectionFactory;

public class TaskController {
	
	public void save(Task task) throws RuntimeException {
		String sql = "INSERT INTO tasks ("
				+ "idProject,"
				+ "name,"
				+ "description,"
				+ "completed,"
				+ "notes,"
				+ "deadline,"
				+ "createdAt,"
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
		} catch (SQLException  e) {
			throw new RuntimeException("Erro ao salvar tarefa" + e.getMessage(), e);
		} finally {
			ConnectionFactory.closeConnetion(conn, statement);
		}
	}
	
	public void update(Task task) {
		String sql = "UPDATE tasks SET "
				+ "idProject = ?, "
				+ "name = ?,"
				+ "description = ?,"
				+ "notes = ?,"
				+ "completed = ?,"
				+ "deadline = ?,"
				+ "createdAt = ?,"
				+ "updatedAt = ?"
				+ "WHERE id = ?";
		
		Connection conn = null;
		PreparedStatement statement = null;
		
		try {
			conn = ConnectionFactory.getConnection();
			statement = conn.prepareStatement(sql);
			statement.setInt(1, task.getIdProject());
			statement.setString(2, task.getName());
			statement.setString(3, task.getDescription());
			statement.setString(4, task.getNotes());
			statement.setBoolean(5, task.getCompleted());
			statement.setDate(6, new Date(task.getDeadline().getTime()));
			statement.setDate(7, new Date(task.getCreatedAt().getTime()));
			statement.setDate(8, new Date(task.getUpdatedAt().getTime()));
			statement.setInt(9, task.getId());
			statement.execute();
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao atualizar tarefa" + e.getMessage(), e);
		} finally {
			ConnectionFactory.closeConnetion(conn, statement);
		}
	}
	
	public void removeById(int taskId) throws RuntimeException {
		String sql = "DELETE FROM tasks WHERE id = ?";
		Connection conn = null;
		PreparedStatement statement = null;
		
		try {
			conn = ConnectionFactory.getConnection();
			statement = conn.prepareStatement(sql);
			statement.setInt(1, taskId);
			statement.execute();
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao remover tarefa" + e.getMessage(), e);
		} finally {
			ConnectionFactory.closeConnetion(conn, statement);
		}
	}
	
	public List<Task> getAll(int idProject) throws RuntimeException {
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
		}catch (SQLException e) {
			throw new RuntimeException("Erro ao listar tarefas" + e.getMessage(), e);
		} finally {
			ConnectionFactory.closeConnetion(conn, statement, result);
		}
		return tasks;		
	}
}
