import java.util.HashSet;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;
//from  w w  w.j  a v  a  2 s.  com
public class Main {
  public static void main(String[] arg) throws Exception {
    Runnable parallelCode = () -> {
      HashSet<String> allThreads = new HashSet<>();
      IntStream.range(0, 1_000_000).parallel().filter(i -> {
        allThreads.add(Thread.currentThread().getName());
        return false;
      }).min();
      System.out.println("executed by " + allThreads);
    };
    System.out.println("default behavior: ");
    parallelCode.run();
    System.out.println("specialized pool:");
    ForkJoinPool pool = new ForkJoinPool(2);
    pool.submit(parallelCode).get();
  }
}
