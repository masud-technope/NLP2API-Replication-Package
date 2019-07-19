import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Counter extends HttpServlet {
  static final String COUNTER_KEY = "Counter.count";

  public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
      IOException {
    HttpSession session = req.getSession(true);
    resp.setContentType("text/html");
    PrintWriter out = resp.getWriter();
    int count = 1;
    Integer i = (Integer) session.getAttribute(COUNTER_KEY);
    if (i != null) {
      count = i.intValue() + 1;
    }
    session.setAttribute(COUNTER_KEY, new Integer(count));
    out.println("<html>");
    out.println("<head>");
    out.println("<title>Session Counter</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("Your session ID is <b>" + session.getId());
    out.println("</b> and you have hit this page <b>" + count
        + "</b> time(s) during this browser session");

    out.println("<form method=GET action=\"" + req.getRequestURI() + "\">");
    out.println("<input type=submit " + "value=\"Hit page again\">");
    out.println("</form>");
    out.println("</body>");
    out.println("</html>");
    out.flush();
  }
}
