package com.example.demoProject2;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "authentication", value = "/authentication")
public class AuthServlet extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        int userId = Integer.parseInt(request.getParameter("userId"));
        String password = request.getParameter("pwd");

        PrintWriter out = response.getWriter();
        out.print("<html><body>");
        try {
            Connection connection = DatabaseConnection.intializeDatabse();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from auth where id =" + userId + " and password ='" + password + "'");
            if (resultSet.next()) {
                resultSet = statement.executeQuery("select * from employee where id = " + userId);
                while (resultSet.next()) {
                    out.print( "<h1>" + resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3) + " " + resultSet.getString(4) + "</h1>");
                }
            }
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            out.print("Invalid credentials");
        }
        out.print("</body></html>");
    }   
}
