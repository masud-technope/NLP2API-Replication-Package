import org.apache.commons.httpclient.URI;
import org.apache.commons.httpclient.HttpState;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.Credentials;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.HostConfiguration;
import org.apache.commons.httpclient.UsernamePasswordCredentials;

public class BasicAuthenticationForJSPPage {

  public static void main(String args[]) throws Exception {

    HttpClient client = new HttpClient();
    client.getParams().setParameter("http.useragent", "My Browser");

    HostConfiguration host = client.getHostConfiguration();
    host.setHost(new URI("http://localhost:8080", true));

    Credentials credentials = new UsernamePasswordCredentials("tomcat", "tomcat");
    AuthScope authScope =new AuthScope(host.getHost(), host.getPort());
    HttpState state = client.getState();
    state.setCredentials(authScope, credentials);

    GetMethod method = new GetMethod("/commons/chapter01/protected.jsp");
    try{
      client.executeMethod(host, method);
      System.err.println(method.getStatusLine());
      System.err.println(method.getResponseBodyAsString());
    } catch(Exception e) {
      System.err.println(e);
    } finally {
      method.releaseConnection();
    }
  }
}