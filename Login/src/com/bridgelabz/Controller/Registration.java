package com.bridgelabz.Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgelabz.Model.RegistrationModel;
import com.bridgelabz.Repository.DataBaseOperation;


@WebServlet("/Register")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Registration() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		   RegistrationModel model=new RegistrationModel();
		   model.setFirstName(request.getParameter("firstName"));
		   model.setLastName(request.getParameter("lastName"));
		   model.setPassword(request.getParameter("password"));
		   model.setGender(request.getParameter("gender"));
		   model.setPhone(request.getParameter("phoneNumber"));
		   model.setGmail(request.getParameter("gmail"));
		   try
		   {
			DataBaseOperation.insertToTable(model);
		   } 
		   catch (SQLException e) 
		   {
				e.printStackTrace();
		   }
		   doGet(request, response);
	}

}
