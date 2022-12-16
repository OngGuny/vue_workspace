<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dto.TodoDTO"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.List"%>
<%@page import="dao.impl.TodoDAOImpl"%>
<%@page import="service.TodoService"%>
<%
TodoService ts = new TodoDAOImpl();
List<TodoDTO> list = new ArrayList<TodoDTO>();
list = ts.listTodo();
Gson gs = new Gson();
String result = gs.toJson(list);
out.print(result);
%>