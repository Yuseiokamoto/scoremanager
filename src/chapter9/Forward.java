package chapter9;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns={"/chapter9/forward"})
public class Forward extends HttpServlet{

	public void doPost(
			HttpServletRequest request,HttpServletResponse response
		)throws ServletException, IOException{
		response.setContentType("forward.jsp");
		     .forward(request,response);
	}
}
