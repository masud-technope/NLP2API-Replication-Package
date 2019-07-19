package org.kodejava.example.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.InputStream;

public class SAXElementAttribute {
    public static void main(String[] args) {
        SAXElementAttribute demo = new SAXElementAttribute();
        demo.run();
    }

    private void run() {
        try {
            //
            // Create SAXParserFactory instance and a SAXParser
            //
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();

            //
            // Get an InputStream to the elements.xml file and parse
            // its contents using the SAXHandler.
            //
            InputStream is =
                    getClass().getResourceAsStream("/elements.xml");
            DefaultHandler handler = new SAXHandler();
            parser.parse(is, handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class SAXHandler extends DefaultHandler {
        @Override
        public void startElement(String uri, String localName,
                                 String qName, Attributes attributes)
                throws SAXException {

            int attributeLength = attributes.getLength();
            if ("person".equals(qName)) {
                for (int i = 0; i < attributeLength; i++) {
                    //
                    // Get attribute names and values
                    //
                    String attrName = attributes.getQName(i);
                    String attrVal = attributes.getValue(i);
                    System.out.print(attrName + " = " + attrVal + "; ");
                }
                System.out.println("");
            }
        }
    }
}