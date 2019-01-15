package lifeCycle;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/lifecycle")
public class LCEx extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LCEx() {
        System.out.println("--- Create LCEx Servlet ---");
    }

	
	public void init(ServletConfig config) throws ServletException {
		
		System.out.println("---- Init() ---");
	}

	
	public void destroy() {
		
		System.out.println("--- If you update application or Dead Server --> Start destroy() ---");
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("--- service()! --> get, post ---");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>formEx</title></head>");
		out.println("<body>");
		out.println("<form method='post' action='/ServleLifeCycle/lifecycle'>");
		out.println("Name : <input type = 'text' name = 'name'>");
		out.println("<input type = 'submit' value = 'post!'>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		out.close();
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		out.println("<h1> Welcome " + name + "!!! </h1>");
		out.close();
		
	}

}
