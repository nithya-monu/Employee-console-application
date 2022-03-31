package practise;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class addServlets extends HttpServlet{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 6697013642035269643L;

	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
	{
		int i=Integer.parseInt(req.getParameter("n1"));
		int j=Integer.parseInt(req.getParameter("n2"));
		int sum=i+j;
		req.setAttribute("sum",sum);
		RequestDispatcher rd= req.getRequestDispatcher("sd");
		rd.forward(req, res);
	}
}

