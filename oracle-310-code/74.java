import java.io.*;
import java.util.Enumeration;
 
import javax.servlet.*;
import javax.servlet.http.*;
 
/**
 * Example Servlet
 * @author www.javadb.com
 */
public class ExampleServlet extends HttpServlet {
    
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void service(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
 
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        printPageStart(out);
        
        Enumeration en = request.getParameterNames();
        
        while (en.hasMoreElements()) {
            
            String paramName = (String) en.nextElement();
            out.println(paramName + " = " + request.getParameter(paramName) + "<br/>");
            
        }
        
        printPageEnd(out);
    }
    
    /** Prints out the start of the html page
     * @param out the PrintWriter object
     */
    private void printPageStart(PrintWriter out) {
        
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet ExampleServlet</title>");
        out.println("</head>");
        out.println("<body>");
        
    }
    
    /** Prints out the end of the html page
     * @param out the PrintWriter object
     */
    private void printPageEnd(PrintWriter out) {
        
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}