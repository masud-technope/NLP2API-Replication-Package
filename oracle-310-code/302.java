//from   w  w  w.jav  a 2 s  .co m
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.InputSource;

public class Main {
  public static String getXMLData() {
    return "<a><person><name>myName</name></person></a>";
  }

  public static void main(String[] argv) throws Exception {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    Document doc = factory.newDocumentBuilder().parse(
        new InputSource(new StringReader(getXMLData())));

    duplicatePerson(doc);

    System.out.println(documentToString(doc));

  }

  public static void duplicatePerson(Document doc) {
    Element root = doc.getDocumentElement();
    Element origPerson = (Element)root.getFirstChild();
    Element newPerson = (Element)origPerson.cloneNode(true);
    root.appendChild(newPerson);
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
