<%--
  Created by IntelliJ IDEA.
  User: Tim
  Date: 07/12/2016
  Time: 20:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*"%>
<html>
<head>
    <title>Success</title>
</head>
<body>
<h1>Success</h1>
    <%
    Class.forName("com.mysql.jdbc.Driver");
    Connection con = null;
    try {
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dt354jdbc",
                "root", "root");
    } catch (SQLException e) {
        e.printStackTrace();
    }
    Statement st = null;
    try {
        st = con.createStatement();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    ResultSet rs;
    try {
        rs = st.executeQuery("select * from track");
        if (rs.next()) {
            response.sendRedirect("success.jsp");
        } else {
            out.println("Invalid password <a href='index.jsp'>try again</a>");
            response.sendRedirect("index.jsp");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

%>

</body>
</html>