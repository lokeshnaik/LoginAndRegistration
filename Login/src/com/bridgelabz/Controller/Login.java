package com.bridgelabz.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgelabz.Repository.DataBaseOperation;

/**
 * Servlet implementation class Loginregistration
 */
@WebServlet("/Login")
public class Login extends HttpServlet
{
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		String username=request.getParameter("name");
		String password=request.getParameter("password");
		System.out.println("Login Servlet************");
		ResultSet rs=null;
		PrintWriter out=response.getWriter();
		try {
			rs=DataBaseOperation.getDetails(username, password);
		} catch (SQLException e)
		{
			System.out.println(e);
		}
		
		try {
			if(rs.next())
			{
				if(username.equals("Admin"))
				{
					response.sendRedirect("admin.jsp");
				}
				else
				{
					HttpSession session=request.getSession();
					session.setAttribute("username",username);
					response.sendRedirect("welcome.jsp");
				}
			}
			else
			{
				response.sendRedirect("login.jsp");
			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}