package practise;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class sqrServlet extends HttpServlet{

	public void service(HttpServletRequest req,HttpServletResponse res ) throws IOException
	{
		int sum=(int) req.getAttribute("sum");
		sum=sum * sum;
	    PrintWriter out=res.getWriter();
	    out.println("the square is:"+ " "+sum);
	}
}
