import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stax.StAXResult;
//from w  w  w.  ja  va2 s.c om
import org.w3c.dom.Document;

public class Main {

  public static void main(String[] args) throws Exception {
    Document doc = null;
    XMLStreamWriter writer = XMLOutputFactory.newFactory()
        .createXMLStreamWriter(System.out);
    Transformer transformer = TransformerFactory.newInstance().newTransformer();
    transformer.transform(new DOMSource(doc), new StAXResult(writer));
  }

}
