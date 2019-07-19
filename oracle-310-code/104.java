import java.io.StringReader;
import java.io.StringWriter;
//  java  2s .  co m
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;

public class Main {

  public static void main(String[] args) throws Exception {
    InputSource is = new InputSource();
    is.setCharacterStream(new StringReader(xmlRecords));
    
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    DocumentBuilder db = dbf.newDocumentBuilder();
    
    Document doc = db.parse(is);
    
    Element root = doc.getDocumentElement();
    Element folks = (Element)root.getLastChild();
    Comment comment = doc.createComment("Text of the comment");
    root.insertBefore(comment,folks);
    toString(doc);
  }
  private static void toString(Document newDoc) throws Exception{
    DOMSource domSource = new DOMSource(newDoc);
    Transformer transformer = TransformerFactory.newInstance().newTransformer();
    StringWriter sw = new StringWriter();
    StreamResult sr = new StreamResult(sw);
    transformer.transform(domSource, sr);
    System.out.println(sw.toString());  
  }
  static String xmlRecords = 
      "<data>" +
      "  <employee>" +
      "    <name>Tom</name>"+ 
      "    <title>Manager</title>" +
      "  </employee>" +
      "  <employee>" +
      "    <name>Jerry</name>"+ 
      "    <title>Programmer</title>" +
      "  </employee>" +
      "</data>";
}