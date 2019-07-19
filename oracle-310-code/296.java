import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;
/*www . j ava  2  s.  c o m*/
public class Main {
  public static void main(String[] args) throws Exception {
    String parserClass = "org.apache.xerces.parsers.SAXParser";
    String validationFeature = "http://xml.org/sax/features/validation";
    String schemaFeature = "http://apache.org/xml/features/validation/schema";
    String x = args[0];
    XMLReader r = XMLReaderFactory.createXMLReader(parserClass);
    r.setFeature(validationFeature, true);
    r.setFeature(schemaFeature, true);
    r.setErrorHandler(new MyErrorHandler());
    r.parse(x);
  }
}
class MyErrorHandler extends DefaultHandler {
  public void warning(SAXParseException e) throws SAXException {
    printInfo(e);
  }

  public void error(SAXParseException e) throws SAXException {
    printInfo(e);
  }

  public void fatalError(SAXParseException e) throws SAXException {
    printInfo(e);
  }
  private void printInfo(SAXParseException e) {
    System.out.println("   Public ID: " + e.getPublicId());
    System.out.println("   System ID: " + e.getSystemId());
    System.out.println("   Line number: " + e.getLineNumber());
    System.out.println("   Column number: " + e.getColumnNumber());
    System.out.println("   Message: " + e.getMessage());
  }
}
