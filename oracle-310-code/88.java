import java.io.File;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;

public class Main {
  public static void main(String[] argv) throws Exception{
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    factory.setValidating(true);
    factory.setExpandEntityReferences(false);
    Document doc = factory.newDocumentBuilder().parse(new File("filename"));
    Element element = doc.getElementById("key1");
    NamedNodeMap attrs = element.getAttributes();
    while (attrs.getLength() > 0) {
      attrs.removeNamedItem(attrs.item(0).getNodeName());
    }
  }
}