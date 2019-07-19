// w ww. j  av  a  2s.  c o m
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;

public class Main {
  public static String getXMLData() {
    return "<a><person  number='' dept=''><name>myName</name></person></a>";
  }

  public static void main(String[] argv) throws Exception {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    Document doc = factory.newDocumentBuilder().parse(
        new InputSource(new StringReader(getXMLData())));

    addComment(doc);

    System.out.println(documentToString(doc));

  }
  public static void addComment(Document doc) {
    Element root = doc.getDocumentElement();
    Element folks = (Element)root.getLastChild();
    Comment comment = doc.createComment("Text of the comment");
    root.insertBefore(comment,folks);
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