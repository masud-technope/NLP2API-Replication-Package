import java.util.Iterator;
//from  w  w w .j  ava2 s . c  o m
import javax.xml.XMLConstants;
import javax.xml.namespace.NamespaceContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;

public class Main {
  public static void main(String[] args) throws Exception {
    DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
    domFactory.setNamespaceAware(true);
    DocumentBuilder builder = domFactory.newDocumentBuilder();
    Document dDoc = builder.parse("c:\\file.xml");
    XPath xPath = XPathFactory.newInstance().newXPath();
    xPath.setNamespaceContext(new UniversalNamespaceResolver(dDoc));
    String query = "//rss/channel/yweather:location/@city";
    XPathExpression expr = xPath.compile(query);
    Object result = expr.evaluate(dDoc, XPathConstants.STRING);
    System.out.println(result);
  }
}

class UniversalNamespaceResolver implements NamespaceContext {
  private Document sourceDocument;

  public UniversalNamespaceResolver(Document document) {
    sourceDocument = document;
  }

  public String getNamespaceURI(String prefix) {
    if (prefix.equals(XMLConstants.DEFAULT_NS_PREFIX))
      return sourceDocument.lookupNamespaceURI(null);
    else
      return sourceDocument.lookupNamespaceURI(prefix);
  }
  public String getPrefix(String namespaceURI) {
    return sourceDocument.lookupPrefix(namespaceURI);
  }
  public Iterator getPrefixes(String namespaceURI) {
    return null;
  }
}

