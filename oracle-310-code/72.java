import java.io.*;
 
import javax.servlet.*;
import javax.servlet.http.*;
 
/**
 * Example Servlet
 * @author www.javadb.com
 */
public class ExampleServlet extends HttpServlet {
    
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void service(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
 
        //Redirect call to another url
        response.sendRedirect("http://www.java.com");
    }
    
}