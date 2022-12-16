

<%@page import="com.google.gson.Gson"%>
<%@page import="dto.MemberDTO"%>
<%@page import="java.util.List"%>
<%@page import="dao.impl.MemberDAOImpl"%>
<%@page import="service.Memberservice"%>
<% 
Memberservice ms = new MemberDAOImpl();
List<MemberDTO> memberlist = ms.listMember();


Gson gson = new Gson();
String result = gson.toJson(memberlist);
out.print(result);


%>