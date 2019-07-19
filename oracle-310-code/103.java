import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
//from  j a v a2s.  co m
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Main {
  public static void main(String[] args) throws Exception {
    DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder domBuilder = domFactory.newDocumentBuilder();

    Document newDoc = domBuilder.newDocument();
    Element rootElement = newDoc.createElement("parent");
    newDoc.appendChild(rootElement);
    Element rowElement = newDoc.createElement("row");

    Element curElement = newDoc.createElement("newValue");
    curElement.appendChild(newDoc.createTextNode("newText"));
    rowElement.appendChild(curElement);
    rootElement.appendChild(rowElement);
    
    toString(newDoc);

  }
  private static void toString(Document newDoc) throws Exception{
    TransformerFactory tranFactory = TransformerFactory.newInstance();
    Transformer aTransformer = tranFactory.newTransformer();
    Source src = new DOMSource(newDoc);
    Result dest = new StreamResult(System.out);
    aTransformer.transform(src, dest);
  }
}