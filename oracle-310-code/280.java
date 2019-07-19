import java.io.StringReader;
import java.io.StringWriter;
// w  w w. j  a v  a 2 s  .  c  o  m
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;

public class Main {
  static public void main(String[] arg) throws Exception {
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    dbf.setValidating(true);
    dbf.setNamespaceAware(true);
    dbf.setIgnoringElementContentWhitespace(true);

    DocumentBuilder builder = dbf.newDocumentBuilder();

    StringReader sr = new StringReader("<tag>java2s.com</tag>");
    Document document = builder.parse(new InputSource(sr));
    deleteFirstElement(document); 
    
    TransformerFactory tf = TransformerFactory.newInstance();
    Transformer trans = tf.newTransformer();
    StringWriter sw = new StringWriter();
    trans.transform(new DOMSource(document), new StreamResult(sw));
    System.out.println(sw.toString());


  }
  public static void deleteFirstElement(Document doc) {
    Element root = doc.getDocumentElement();
    if(root.getFirstChild() instanceof Element){
      Element child = (Element)root.getFirstChild();
      root.removeChild(child);
      
    }
  }
}

