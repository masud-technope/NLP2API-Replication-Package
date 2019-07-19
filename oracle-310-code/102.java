import org.jdom.Document;
import org.jdom.Element;

public class MainClass {

  public static void main(String args[]) {

    Document doc = new Document(new Element("games"));
    Element newGame = new Element("game").setText("Final Fantasy");
    doc.getRootElement().addContent(newGame);
    newGame.setAttribute("genre", "rpg");

  }

}
