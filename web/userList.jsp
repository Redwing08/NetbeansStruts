<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
    <title>Search Results</title>
</head>
<body>

<h1>Search Results</h1>

<s:if test="users != null && !users.isEmpty()">
    <table border="1">
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
        </tr>
        <s:iterator value="users">
            <tr>
                <td><s:property value="fname" /></td>
                <td><s:property value="lname" /></td>
            </tr>
        </s:iterator>
    </table>
</s:if>

<s:else>
    <p>No users found with the given last name.</p>
</s:else>

</body>
</html>
