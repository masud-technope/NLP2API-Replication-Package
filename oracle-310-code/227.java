import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
  public static void main(String[] args) throws Exception {
    ExecutorService service = Executors.newFixedThreadPool(5);
    List<Future<java.lang.String>> futureList = service.invokeAll(Arrays
        .asList(new Task1<String>(), new Task2<String>()));

    System.out.println(futureList.get(1).get());
    System.out.println(futureList.get(0).get());
  }
}
class Task2<String> implements Callable<String> {
  @Override
  public String call() throws Exception {
    Thread.sleep(1000 * 2);
    int i = 3;
    if (i == 3)
      throw new RuntimeException("Its Wrong");
    return (String) "1000 * 2";
  }
}

class Task1<String> implements Callable<String> {
  @Override
  public String call() throws Exception {
    Thread.sleep(1000 * 10);
    return (String) "1000 * 5";
  }
}
