

<%@page import="dao.impl.MemberDAOImpl"%>
<%@page import="service.Memberservice"%>
<%
String newid = (String)request.getParameter("newid");
String newname = (String)request.getParameter("newname");
String newemail = (String)request.getParameter("newemail");

Memberservice me = new MemberDAOImpl();
me.joinMember(newid, newname, newemail);
System.out.print(newid);
%>