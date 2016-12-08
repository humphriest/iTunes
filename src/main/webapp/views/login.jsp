<%@ page import="java.sql.*"%>
<%
    String userName = request.getParameter("username");
    String password = request.getParameter("password");
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
        rs = st.executeQuery("select * from user where username='" + userName + "' and password='" +password + "'");
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