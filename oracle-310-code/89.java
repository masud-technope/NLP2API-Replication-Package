import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {
  public static void main(String[] args) throws Exception {
    String url = "http://www.java2s.com";
    Document doc = Jsoup
        .connect(url)
        .userAgent(
            "Mozilla/5.0 (Windows; U; WindowsNT 5.1;"
                + " en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6").get();

    Elements resultDivElems = doc.select("div");
    Iterator<Element> itr = resultDivElems.iterator();

    while (itr.hasNext()) {
      System.out.println(((Element) itr.next()).text());
    }
  }
}