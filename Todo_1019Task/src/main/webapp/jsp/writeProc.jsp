<%@page import="java.util.ArrayList"%>
<%@page import="dto.TodoDTO"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="java.sql.Time"%>
<%@page import="dao.impl.TodoDAOImpl"%>
<%@page import="service.TodoService"%>
<%
String todo = (String)request.getParameter("todo");
String time = (String)request.getParameter("time");
String id = "ss"+todo+time;
TodoService ts = new TodoDAOImpl();
ts.writeTodo(todo, time);
//새로고침기능구현
List<TodoDTO> list = new ArrayList<TodoDTO>();
list = ts.listTodo();
list.get(list.size()-1);

Gson gs = new Gson();
out.print(gs.toJson(list.get(list.size()-1)));

%>
