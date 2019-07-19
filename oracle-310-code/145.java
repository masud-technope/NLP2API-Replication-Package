import java.security.Permission;
import java.security.PermissionCollection;
import java.security.Policy;
import java.security.ProtectionDomain;
import java.util.Enumeration;

public class Main {
  public static void main(String[] argv) throws Exception {
    ProtectionDomain domain = String.class.getProtectionDomain();
    PermissionCollection pcoll = Policy.getPolicy().getPermissions(domain);
    Enumeration e = pcoll.elements();
    for (; e.hasMoreElements();) {
      Permission p = (Permission) e.nextElement();
    }
  }
}