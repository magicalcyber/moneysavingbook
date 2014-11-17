<%--
  Created by IntelliJ IDEA.
  User: magicalcyber
  Date: 11/16/14
  Time: 2:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<form:form modelAttribute="registerForm" method="post" action="register">
    <div align="center">
        <table>
            <tr>
                <td><label for="username">Username</label></td>
                <td><form:input path="username" id="username"/><form:errors path="username"/></td>
            </tr>
            <tr>
                <td><label for="password">Password</label></td>
                <td>
                    <form:password path="password" id="password"/>
                    <form:errors path="password"/></td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td><input type="submit" value="Register"/></td>
            </tr>
        </table>
    </div>

</form:form>
</body>
</html>
