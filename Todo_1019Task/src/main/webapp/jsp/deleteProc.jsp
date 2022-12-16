<%@page import="com.google.gson.Gson"%>
<%@page import="dao.impl.TodoDAOImpl"%>
<%@page import="service.TodoService"%>
<%
String sid = (String) request.getParameter("id");
String order = (String) request.getParameter("all");

TodoService ts = new TodoDAOImpl();

if (sid != null) {
	int nid = Integer.parseInt(sid);
	ts.deleteTodo(nid);
};

if (order != null) {
	if (order.equals("all")) {
		ts.allDeleteTodo();
	};
};

String an = "{Your schedule is delete.}";
Gson gs = new Gson();
String ans = gs.toJson(an);
out.print(ans);
%>