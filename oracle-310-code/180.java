import java.util.concurrent.Semaphore;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
// w w w.j  a v a  2 s.  c  om
public class Main {
  public static void main(String[] args) {
    try {
      new Main().runTest();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  public void runTest() throws Exception {
    ThreadPoolExecutor tp = new ThreadPoolExecutor(1, 1, 60L, TimeUnit.SECONDS,
        new SynchronousQueue<Runnable>());
    tp.setRejectedExecutionHandler((Runnable r, ThreadPoolExecutor executor) ->System.out.println("Task rejected: " + r));
    Semaphore oneTaskDone = new Semaphore(0);
    tp.execute(()->{
        System.out.println("Sleeping");
        try {
          Thread.sleep(300);
        } catch (Exception e) {
          e.printStackTrace();
        }
        System.out.println("Done sleeping");
        oneTaskDone.release();
    });
    tp.execute(new Runnable() {
      @Override
      public void run() {
        System.out.println("Never happends");
      }
      @Override
      public String toString() {
        return "Rejected Runnable";
      }
    });
    oneTaskDone.acquire();
    tp.execute(()->System.out.println("Running"));
    tp.shutdown();
    tp.awaitTermination(100, TimeUnit.MILLISECONDS);
    System.out.println("Finished");
  }
}
