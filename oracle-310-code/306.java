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
import org.w3c.dom.Text;
import org.xml.sax.InputSource;

public class Main {
  public static String getXMLData() {
    return "<a><person><email>asdf</email></person></a>";
  }

  public static void main(String[] argv) throws Exception {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    Document doc = factory.newDocumentBuilder().parse(
        new InputSource(new StringReader(getXMLData())));

    replacePerson(doc,"newName","111111","newEmail@email.com");

    System.out.println(documentToString(doc));

  }

  public static void replacePerson(Document doc, String name, String phone, String email) {
    Element newPersonNode = doc.createElement("person");

    Element nameNode = doc.createElement("name");
    newPersonNode.appendChild(nameNode);
    Text nametextNode = doc.createTextNode(name);
    nameNode.appendChild(nametextNode);

    Element phoneNode = doc.createElement("phone");
    newPersonNode.appendChild(phoneNode);
    Text phonetextNode = doc.createTextNode(phone);
    phoneNode.appendChild(phonetextNode);

    Element emailNode = doc.createElement("email");
    newPersonNode.appendChild(emailNode);
    Text emailtextNode = doc.createTextNode(email);
    emailNode.appendChild(emailtextNode);

    Element root = doc.getDocumentElement();
    Element oldPersonNode = (Element) root.getFirstChild();
    root.replaceChild(newPersonNode, oldPersonNode);
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
