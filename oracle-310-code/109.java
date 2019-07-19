import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Node;
/*from   ww  w.  j av  a  2  s .  c  o m*/
public class Main {
  public static void main(String... args) {
    String h = "<html><body>"
        + "<div><!-- foo --><p>bar<!-- baz --></div><!--qux--><br/></body></html>";
    Document doc = Jsoup.parse(h);
    removeComments(doc);
    System.out.println(doc.toString());
  }

  private static void removeComments(Node node) {
    for (int i = 0; i < node.childNodes().size();) {
      Node child = node.childNode(i);
      if (child.nodeName().equals("#comment"))
        child.remove();
      else {
        removeComments(child);
        i++;
      }
    }
  }
}