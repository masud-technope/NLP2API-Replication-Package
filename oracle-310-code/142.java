import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class SessionBindListen implements HttpSessionBindingListener {

  private Map info;

  /** Creates new SessionBindListen */
  public SessionBindListen() {

    //zero-arg constructor
    info = new HashMap();
  }

  public void valueBound(HttpSessionBindingEvent be) {

    HttpSession session = be.getSession();
    String id = session.getId();
    String name = be.getName();
    Object value = be.getValue();
    String source = be.getSource().getClass().getName();
    String message = new StringBuffer("Attribute bound to session in ")
        .append(source).append("\nThe attribute name: ").append(name)
        .append("\n").append("The attribute value: ").append(value)
        .append("\n").append("The session id: ").append(id).toString();

    System.out.println(message);
  }

  public void valueUnbound(HttpSessionBindingEvent be) {

    HttpSession session = be.getSession();
    String id = session.getId();
    String name = be.getName();
    if (name == null)
      name = "Unknown";
    String source = be.getSource().getClass().getName();
    String message = new StringBuffer("Attribute unbound from session in ")
        .append(source).append("\nThe attribute name: ").append(name)
        .append("\n").append("The session id: ").append(id).toString();
    //clear Map; send message
    info.clear();
    System.out.println(message + "\nThe size of the HashMap is: "
        + info.size());
  }

  public void addInfo(String name, String email) {

    info.put(email, name);

  }

}