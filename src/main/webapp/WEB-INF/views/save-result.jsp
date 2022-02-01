<%--<%@ page import="hello.servlet.domain.member.Member" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="UTF-8">
</head>
<body>
<a href="/index.html">메인</a>
<%--<ul>--%>
<%--    <li>id=<%= ((Member)request.getAttribute("member")).getId() %></li>--%>
<%--    <li>username=<%= ((Member)request.getAttribute("member")).getUsername() %></li>--%>
<%--    <li>age=<%= ((Member)request.getAttribute("member")).getAge() %></li>--%>
<%--</ul>--%>

<ul>
    <li>id=${member.id}</li>
    <li>username=${member.username}</li>
    <li>age=${member.age}</li>
</ul>
</body>
</html>
