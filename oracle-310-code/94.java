import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
//  ww  w. j  a  v  a2  s . c  o m
public class Main {

  public static void main(String[] args) {
    Map<String, String> map = new HashMap<String, String>();

    map.put("KeyA", "erty");
    map.put("KeyC", "trwe");
    map.put("KeyD", "wert");
    map.put("KeyB", "fdsd");
    map.put("KeyS", "dsa");
    map.put("KeyE", "fdas");
    map.put("KeyG", "asdf");

    System.out.println(sort(map, new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        return o1.compareTo(o2);
      }
    }));
  }

  @SuppressWarnings("unchecked")
  public static <K, V> Map<K, V> sort(Map<K, V> in,
      Comparator<? super V> compare) {
    Map<K, V> result = new LinkedHashMap<K, V>();
    V[] array = (V[]) in.values().toArray();
    for (int i = 0; i < array.length; i++) {

    }
    Arrays.sort(array, compare);
    for (V item : array) {
      K key = (K) getKey(in, item);
      result.put(key, item);
    }
    return result;
  }

  public static <K, V> Object getKey(Map<K, V> in, V value) {
    Set<K> key = in.keySet();
    Iterator<K> keyIterator = key.iterator();
    while (keyIterator.hasNext()) {
      K valueObject = (K) keyIterator.next();
      if (in.get(valueObject).equals(value)) {
        return valueObject;
      }
    }
    return null;
  }
}