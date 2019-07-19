import java.io.FileInputStream;
// www  .j a va  2s .  co m
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.xml.sax.InputSource;

public class Main {

    public static void main(String[] args) throws Exception {
        XPath xp = XPathFactory.newInstance().newXPath();
        InputSource xml = new InputSource(new FileInputStream("input.xml"));
        double count = (Double) xp.evaluate("count(//slot[@name='slot1']/port)", xml, XPathConstants.NUMBER);
    }

}
