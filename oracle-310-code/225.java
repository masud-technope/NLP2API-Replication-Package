import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
//  w  ww .  j a va2s .  co m
public class Main {
  final int CPU_COUNT = 4;
  BlockingQueue<Runnable> lightTaskQueue = new LinkedBlockingDeque<Runnable>();
 
  ThreadPoolExecutor lightExecutor = new ThreadPoolExecutor(CPU_COUNT,
      CPU_COUNT, 60L, TimeUnit.SECONDS, lightTaskQueue);
  
  BlockingQueue<Runnable> heavyTaskQueue = new LinkedBlockingDeque<Runnable>();
 
  ThreadPoolExecutor heavyExecutor = new ThreadPoolExecutor(1, 1, 60L,
      TimeUnit.SECONDS, heavyTaskQueue);
  
  static AtomicBoolean heavyTaskRunning = new AtomicBoolean();

  public void shutDownNow() {
    lightExecutor.shutdownNow();
    heavyExecutor.shutdownNow();
  }
  public void runOrQueueLightTask(SampleLightTask lightOne) {
    lightExecutor.execute(lightOne);
  }
  public void runOrQueueHeavyTask(SampleHeavyTask heavyOne) {
    if (heavyTaskRunning.get()) {
      System.out.println("running, skipped new one: " + heavyOne);
      return;
    }
    this.heavyExecutor.execute(heavyOne);
  }
  public static void main(String[] args) throws Exception {
    Main q = new Main();
    long start = System.currentTimeMillis();

    // Run the queues for 30 seconds, add CPU-light and CPU-weight tasks
    // every second.
    while (System.currentTimeMillis() - start <= 30 * 1000L) {
      q.runOrQueueHeavyTask(new SampleHeavyTask());
      q.runOrQueueLightTask(new SampleLightTask());
      Thread.sleep(1000L);
    }

    q.shutDownNow();
  }
}

class SampleLightTask implements Runnable {
  @Override
  public void run() {
    System.out.println("I am " + this + " and running fast!");
  }

}

class SampleHeavyTask implements Runnable {
  @Override
  public void run() {
    try {
      Main.heavyTaskRunning.set(true);
      System.out.println("I am " + this + " and running quite slow!");
      final long start = System.currentTimeMillis();
      while (true) {
        // burn the CPU for ten senconds.
        if (System.currentTimeMillis() - start >= 10000L)
          break;
      }
    } finally {
      Main.heavyTaskRunning.set(false);
    }
  }
}

