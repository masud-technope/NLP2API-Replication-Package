import java.io.*;
 
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
        
        //Obtain the session object, create a new session if doesn't exist
        HttpSession session = request.getSession(true);
        
        //Check if our session variable is set, if so, get the session variable value
        //which is an Integer object, and add one to the value.
        //If the value is not set, create an Integer object with the default value 1.
        //Add the variable to the session overwriting any possible present values.
        Integer param = (Integer) session.getAttribute("MySessionVariable");
        if (param != null) {
            
            session.setAttribute("MySessionVariable", new Integer(param.intValue() + 1));
            param = (Integer) session.getAttribute("MySessionVariable");
            
        } else {
            
            param = new Integer(1);
            session.setAttribute("MySessionVariable", param);
            
        }
        
        out.println("You have displayed this page <b>" + param.intValue() + "</b> times this session.<br/><br/>");
        out.println("Hit the browsers refresh button.");
        
        printPageEnd(out);
    }
    
    /** Prints out the start of the html page
     * @param out the PrintWriter object
     */
    private void printPageStart(PrintWriter out) {
        
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Example Servlet of how to store and retrieve session variables</title>");
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