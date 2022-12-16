<%@page import="dto.MemberDTO"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="dao.impl.MemberDAOImpl"%>
<%@page import="service.Memberservice"%>
<%

String id = (String)request.getParameter("id");
Memberservice ms = new MemberDAOImpl();
MemberDTO mDTO = ms.viewMember(id);
Gson gs = new Gson();
String result = gs.toJson(mDTO);
out.print(result);
%>