import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
//w w w  . jav  a 2  s . c  o m
public class Main {
  public static void main(String[] args) {
    List<String> syncList = Collections
        .synchronizedList(new ArrayList<String>());

    syncList.add("one");
    syncList.add("two");
    syncList.add("three");

    synchronized (syncList) {
      Iterator<String> iterator = syncList.iterator();
      while (iterator.hasNext()) {
        System.out.println("item: " + iterator.next());
      }
    }
  }
}
