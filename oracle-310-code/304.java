import java.io.File;
// w w w.  j  a v  a  2 s  .  co  m
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Main {

  public static void main(String args[]) throws Exception {
    File stocks = new File("Stocks.xml");
    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    Document doc = dBuilder.parse(stocks);
    doc.getDocumentElement().normalize();

    System.out.println(doc.getDocumentElement().getNodeName());
    NodeList nodes = doc.getElementsByTagName("stock");

    for (int i = 0; i < nodes.getLength(); i++) {
      Node node = nodes.item(i);
      if (node.getNodeType() == Node.ELEMENT_NODE) {
        Element element = (Element) node;
        System.out.println("Stock Symbol: " + getValue("symbol", element));
        System.out.println("Stock Price: " + getValue("price", element));
        System.out.println("Stock Quantity: " + getValue("quantity", element));
      }
    }
  }
  static String getValue(String tag, Element element) {
    NodeList nodes = element.getElementsByTagName(tag).item(0).getChildNodes();
    Node node = (Node) nodes.item(0);
    return node.getNodeValue();
  }
}
