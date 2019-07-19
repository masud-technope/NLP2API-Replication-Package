import java.io.StringReader;
import java.io.StringWriter;
// www .  ja  v a 2 s .c  o  m
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

public class Main {
  public static String getXMLData() {
    return "<a attr='value'></a>";
  }

  public static void main(String[] argv) throws Exception {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    Document doc = factory.newDocumentBuilder().parse(
        new InputSource(new StringReader(getXMLData())));

    printAttributes(doc.getDocumentElement());

    System.out.println(documentToString(doc));

  }
  public static void printAttributes(Element element) {
    NamedNodeMap attributes = element.getAttributes();
    for (int i = 0; i < attributes.getLength(); i++) {
        Node node = attributes.item(i);
        System.out.println("## prefix=" + node.getPrefix() + " localname:" + node.getLocalName()
                           + " value=" + node.getNodeValue());
    }
}

  public static String documentToString(Document document) {
    try {
      TransformerFactory tf = TransformerFactory.newInstance();
      Transformer trans = tf.newTransformer();
      StringWriter sw = new StringWriter();
      trans.transform(new DOMSource(document), new StreamResult(sw));
      return sw.toString();
    } catch (TransformerException tEx) {
      tEx.printStackTrace();
    }
    return null;
  }
}
