package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import model.Task;
import util.ConnectionFactory;

public class TaskController {
	
	public void save(Task task) {
		
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
		return null;		
	}
}
