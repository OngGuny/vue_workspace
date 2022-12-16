package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import dao.TodoDAO;
import dto.TodoDTO;
import util.ConnectionManager;

public class TodoDAOImpl implements TodoDAO {
	Connection conn = ConnectionManager.getConnection();

	@Override
	public List<TodoDTO> listTodo() throws Exception {
		String sql = " select * from todos ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		List<TodoDTO> list = new ArrayList<TodoDTO>();
		while (rs.next()) {
			TodoDTO tDTO = new TodoDTO();
			tDTO.setId(rs.getInt("id"));
			tDTO.setTodos(rs.getString("todos"));
			tDTO.setTime(rs.getString("times"));
			list.add(tDTO);
		}
		System.out.print(list);
		conn.close();
		rs.close();
		pstmt.close();
		return list;
	}

	@Override
	public void writeTodo(String todo, String time) throws Exception {
		String sql = " insert into todos (todos,times) values (?, ?) ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, todo);
		pstmt.setString(2, time);
		pstmt.executeUpdate();
		pstmt.close();
	}

	@Override
	public void deleteTodo(int id) throws Exception {
		String sql = "delete from todos where id = ? ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, id);
		pstmt.executeUpdate();
		pstmt.close();
	}

	@Override
	public void allDeleteTodo() throws Exception {
		String sql = " delete from todos ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.executeUpdate();
		pstmt.close();
	}

	@Override
	public void updateTodo() throws Exception {
		String sql = " update table ";
	}

}
