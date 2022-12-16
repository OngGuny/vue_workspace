package dao;

import java.util.List;

import dto.TodoDTO;
import service.TodoService;

public interface TodoDAO extends TodoService{
	public abstract List<TodoDTO> listTodo() throws Exception;

	public abstract void writeTodo(String todos, String time) throws Exception;

	public abstract void deleteTodo(int id) throws Exception;

	public abstract void allDeleteTodo() throws Exception;

	public abstract void updateTodo() throws Exception;

}
