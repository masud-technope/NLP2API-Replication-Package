import java.io.InputStream;
import java.net.URL;
/*ww  w  .  ja v a  2s.c  o m*/
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;

public class Main {
  public static void main(String[] args) throws Exception {
    URL url = new URL("http://www.w3c.org");
    InputStream in = url.openStream();
    XMLInputFactory factory = XMLInputFactory.newInstance();
    XMLStreamReader parser = factory.createXMLStreamReader(in);
    while (parser.hasNext()) {
      int event = parser.next();
      if (event == XMLStreamConstants.START_ELEMENT) {
        if (parser.getLocalName().equals("a")) {
          String href = parser.getAttributeValue(null, "href");
          if (href != null)
            System.out.println(href);
        }
      }
    }
  }
}