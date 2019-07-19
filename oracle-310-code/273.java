import static java.lang.System.currentTimeMillis;
import static java.lang.System.out;
//w ww .  j  a va 2s  .c  o m
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
  public static void main(String[] args) {
    List<Runnable> runnables = Arrays.asList(new Runnable[] { new Runnable() {
      public void run() {
        out.println("I'm the one");
      }
    }, new Runnable() {
      public void run() {
        out.println("I'm the two");
      }
    }, new Runnable() {
      public void run() {
        out.println("I'm the three");
      }
    }, new Runnable() {
      public void run() {
        out.println("I'm the four");
      }
    }, });
    for (Runnable run : runnables) {
      new ExecuteTask(run).start();
    }

  }
}

class ExecuteTask extends TimerTask {
  static Map<Timer, Long> upTo = new HashMap<Timer, Long>();
  static Random random = new Random();
  Timer owner;
  Runnable task;

  public ExecuteTask(Runnable task) {
    this.owner = new Timer();
    this.task = task;
    upTo.put(owner, currentTimeMillis() + random.nextInt(10) * 1000);
  }

  public void start() {
    owner.schedule(this, 0, 1000);
  }

  public void run() {
    if (shouldRunAgain()) {
      task.run();
    } else {
      owner.cancel();
    }
  }

  private boolean shouldRunAgain() {
    return ExecuteTask.upTo.get(owner) > currentTimeMillis();
  }
}
