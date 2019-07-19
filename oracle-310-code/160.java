import java.security.Provider;
import java.security.Security;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Main {
  public static void main(String[] argv) throws Exception {
    Set result = new HashSet();
    Provider[] providers = Security.getProviders();
    for (int i = 0; i < providers.length; i++) {
      Set keys = providers[i].keySet();
      for (Iterator it = keys.iterator(); it.hasNext();) {
        String key = (String) it.next();
        key = key.split(" ")[0];

        if (key.startsWith("Alg.Alias.")) {
          // Strip the alias
          key = key.substring(10);
        }
        int ix = key.indexOf('.');
        result.add(key.substring(0, ix));
      }
    }
    System.out.println(result);
  }

}