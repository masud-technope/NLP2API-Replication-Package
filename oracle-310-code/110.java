import java.io.File;
import java.util.List;
import java.util.Map;
//from  w w w.ja v  a 2 s.c om
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.namespace.QName;

@XmlRootElement(name = "Root")
class Root {
  private Map<QName, String> extension;
  private List<Node> cnodes;

  @XmlAnyAttribute
  public Map<QName, String> getExtension() {
    return extension;
  }

  public void setExtension(Map<QName, String> extension) {
    this.extension = extension;
  }

  @XmlElement(name = "CNode")
  public List<Node> getCnodes() {
    return cnodes;
  }

  public void setCnodes(List<Node> cnodes) {
    this.cnodes = cnodes;
  }

}

class Node {

  private Map<QName, String> extension;

  @XmlAnyAttribute
  public Map<QName, String> getExtension() {
    return extension;
  }

  public void setExtension(Map<QName, String> extension) {
    this.extension = extension;
  }

}

public class Main {
  public static void main(String[] args) throws Exception {
    JAXBContext jc = JAXBContext.newInstance(Root.class);

    Unmarshaller unmarshaller = jc.createUnmarshaller();
    Root root = (Root) unmarshaller.unmarshal(new File("input.xml"));

    Marshaller marshaller = jc.createMarshaller();
    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    marshaller.marshal(root, System.out);
  }
}