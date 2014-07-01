<%@taglib uri="/struts-tags" prefix="s"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
            String path = request.getContextPath();
            String basePath = request.getScheme() + "://"
                    + request.getServerName() + ":" + request.getServerPort()
                    + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
        <base href="<%=basePath%>">
        <title></title>

    </head>

    <body>
        <s:set name="userList" value="persons"></s:set>

        <form action="addPerson.action" method="POST">
            <!--		自动放到Person类的name中-->
            <input type='text' name="newPerson.name" />
            <input type='submit' value="Submit" />
        </form>

        <s:if test="#userList.size>0">
            <table>
                <th>编号</th>
                <th>姓名</th>
                <th>操作</th>
                <s:iterator value="#userList">
                    <tr>
                        <td>
                            <s:property value="id" />
                        </td>
                        <td>
                            <s:property value="name" />
                        </td>
                        <td>
                            <a href="deletePerson.action?id=<s:property value="id" />" >delete</a>&nbsp;&nbsp;
                            <a href="updatePerson.action?id=<s:property value="id" />&newName=Kenko" >rename</a>
                        </td>
                    </tr>
                </s:iterator>
            </table>
        </s:if>
    </body>
</html>
