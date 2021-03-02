<%--
  Created by IntelliJ IDEA.
  User: 余家煜
  Date: 2021/2/25
  Time: 10:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" errorPage="" %>
<%
    request.setCharacterEncoding("UTF-8");
    String name = request.getParameter("name");
    String pass = request.getParameter("pass");
    if(name.equals("xxx")
            && pass.equals("xxx"))
    {
        out.println("登录成功！");
    }
    else
    {
        out.println("登录失败！");
    }
%>
