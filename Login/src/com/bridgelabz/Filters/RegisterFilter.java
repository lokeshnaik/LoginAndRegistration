package com.bridgelabz.Filters;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebFilter("/Register")
public class RegisterFilter implements Filter
{

   
    public RegisterFilter() {
        // TODO Auto-generated constructor stub
    }

	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException 
	{
		   String FirstName=req.getParameter("firstName");
		   String LastName=req.getParameter("lastName");
		   String Password=req.getParameter("password");
		   String Gender=req.getParameter("gender");
		   String Phone=req.getParameter("phoneNumber");
		   String gmail=req.getParameter("gmail");
		   
		   String username=req.getParameter("username");
		   
		   HttpSession session=((HttpServletRequest) req).getSession(); 
		   
		   PrintWriter out=res.getWriter();
	    if(FirstName.equals("Admin"))
	    {
	    
	       out.println("Enter the other username.This the username of Admin");
	       
	    }
		else if (!(FirstName.length()>3&& FirstName.matches("^[a-zA-Z]*$")))
	    {
			session.setAttribute("message", "Enter the valid firstName of the user having more than 2 character:");
	    	((HttpServletResponse) res).sendRedirect("registration.jsp");
	    }
	    else if(!(LastName.length()>3&& LastName.matches("^[a-zA-Z]*$")))
	    {
	    	session.setAttribute("message","Enter the valid lastName of the user having more than 2 character:");
	    	((HttpServletResponse) res).sendRedirect("registration.jsp");
	    }
	    else if(!(Password.length()>7&& Password.matches("^(?=.[0-9])(?=.[a-z])(?=.[A-Z])(?=.[@#$%^&+=])(?=\\S+$).{8,}$")))
	    {
	    	session.setAttribute("message","Enter the valid password having 1.Special case 2.Uppercase letter 3.Lowercase letter 4.Numeric case");
	    	((HttpServletResponse) res).sendRedirect("registration.jsp");
	    }
	    else if(!(Gender.equals("Male")||Gender.equals("Female")))
	    {
	    	session.setAttribute("message","Enter either Male or Female");
	    	((HttpServletResponse) res).sendRedirect("registration.jsp");
	    }
	    else if(!(Phone.length()==10&& Phone.matches("[0-9]{10}")))
	    {
	    	session.setAttribute("message","Enter phone number having more 10 digits");
	    	((HttpServletResponse) res).sendRedirect("registration.jsp");
	    }
	    else if(!(Pattern.compile("[a-zA-Z0-9][azA-Z0-9]*gmail.com").matcher(gmail).find()))
	    {
	    	session.setAttribute("message","Enter the correct gmail");
	    	((HttpServletResponse) res).sendRedirect("registration.jsp");
	    }
	    else
	    {
		chain.doFilter(req, res);
	    }
	  
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}


}
