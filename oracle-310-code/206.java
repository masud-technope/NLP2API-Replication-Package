/*from w w w  . j av a2  s.  c o m*/
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class Main {
  public static void main(String[] args) throws Exception {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    factory.setNamespaceAware(false); // never forget this!
    DocumentBuilder builder = factory.newDocumentBuilder();

    Document doc = builder.parse("/data.xml");

    XPathFactory xPathFactory = XPathFactory.newInstance();
    XPath xpath = xPathFactory.newXPath();

    XPathExpression xPathExpression = xpath.compile("//city/text()");

    Object result = xPathExpression.evaluate(doc, XPathConstants.NODESET);

    System.out.println(result.toString());

    NodeList nodes = (NodeList) result;

    System.out.println(nodes.getLength());
    for (int i = 0; i < nodes.getLength(); i++) {
      System.out.println(nodes.item(i).getNodeValue());
    }
  }
}
