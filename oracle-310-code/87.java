import java.io.StringReader;
// j a  v a2 s.c  om
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class Main {
  public static void main(String[] argv) throws Exception {
    InputSource is = new InputSource();
    is.setCharacterStream(new StringReader(xmlRecords));

    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    DocumentBuilder db = dbf.newDocumentBuilder();

    Document doc = db.parse(is);
    NodeList list = doc.getElementsByTagName("*");
    for (int i = 0; i < list.getLength(); i++) {
      Element element = (Element) list.item(i);
      System.out.println(element.getNodeName());
    }
  }
  static String xmlRecords =
      "<data>" +
      "  <employee>" +
      "    <name>Tom</name>"+
      "    <title>Manager</title>" +
      "  </employee>" +
      "  <employee>" +
      "    <name id='web'>java2s.com</name>"+
      "    <title>Programmer</title>" +
      "  </employee>" +
      "</data>";
}