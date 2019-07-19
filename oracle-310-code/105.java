import java.io.File;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class Main {
  public static void main(String[] args) throws Exception {
    Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(
        new InputSource("data.xml"));

    XPath xpath = XPathFactory.newInstance().newXPath();
    NodeList nodes = (NodeList) xpath.evaluate("//employee/name[text()='old']", doc,
        XPathConstants.NODESET);

    for (int idx = 0; idx < nodes.getLength(); idx++) {
      nodes.item(idx).setTextContent("new value");
    }
    Transformer xformer = TransformerFactory.newInstance().newTransformer();
    xformer.transform(new DOMSource(doc), new StreamResult(new File("data_new.xml")));
  }
}