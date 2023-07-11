package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Project;
import util.ConnectionFactory;

public class ProjectController {
	
	public void save(Project project ) {
		String sql = "INSERT INTO projects (name,"
				+ "description,"
				+ "createdAt,"
				+ "updatedAt)"
				+ "VALUES(?,?,?,?)";
		
		Connection conn = null;
		PreparedStatement statement = null;
		try {
			conn = ConnectionFactory.getConnection();
			statement = conn.prepareStatement(sql);
			statement.setString(1, project.getName());
			statement.setString(2, project.getDescription());
			statement.setDate(3, new Date(project.getCreatedAt().getTime()));
			statement.setDate(4, new Date(project.getUpdatedAt().getTime()));
			statement.execute();
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao salvar projeto" + e.getMessage(), e);
		} finally {
			ConnectionFactory.closeConnetion(conn, statement);
		}
	}
	
	public void update(Project project) {
		String sql = "UPDATE projects SET "
				+ "name = ?,"
				+ "description = ?,"
				+ "createdAt = ?,"
				+ "updatedAt = ?"
				+ "WHERE id = ?";
		Connection conn = null;
		PreparedStatement statement = null;
		
		try {
			conn = ConnectionFactory.getConnection();
			statement = conn.prepareStatement(sql);
			statement.setString(1, project.getName());
			statement.setString(2, project.getDescription());
			statement.setDate(3, new Date(project.getCreatedAt().getTime()));
			statement.setDate(4, new Date(project.getUpdatedAt().getTime()));
			statement.setInt(5, project.getId());
			statement.execute();
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao atualizar projeto" + e.getMessage(), e);
		} finally {
			ConnectionFactory.closeConnetion(conn, statement);
		}
	}
	
	public void removeById(int projectId) {
		String sql = "DELETE FROM projects WHERE id = ?";
		Connection conn = null;
		PreparedStatement statement = null;
		
		try {
			conn = ConnectionFactory.getConnection();
			statement = conn.prepareStatement(sql);
			statement.setInt(1, projectId);
			statement.execute();
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao remover projeto" + e.getMessage(), e);
		} finally {
			ConnectionFactory.closeConnetion(conn, statement);
		}
	}
	
	public List<Project> getAll() {
		String sql = "SELECT * FROM projects";
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		List<Project> projects = new ArrayList<>();
		
		try {
			conn = ConnectionFactory.getConnection();
			statement = conn.prepareStatement(sql);
			result = statement.executeQuery();
			
			while(result.next()) {
				Project project = new Project();
				project.setId(result.getInt("id"));
				project.setName(result.getString("name"));
				project.setDescription(result.getString("Description"));
				project.setCreatedAt(result.getDate("createdAt"));
				project.setUpdatedAt(result.getDate("updatedAt"));
				
				projects.add(project);
			}
		}catch (SQLException e) {
			throw new RuntimeException("Erro ao listar projetos" + e.getMessage(), e);
		} finally {
			ConnectionFactory.closeConnetion(conn, statement, result);
		}
		return projects;		
	}
}
