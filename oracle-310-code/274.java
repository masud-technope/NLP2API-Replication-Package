import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Executors;
//from ww w .j ava2 s  . c om
import java.util.concurrent.TimeUnit;

import java.util.Random;

public class Main {

    ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();;
    Random randomnum = new Random();

    public void moveNow() {
        int moveX = randomnum.nextInt(5);
        int moveY = randomnum.nextInt(5);
        System.out.println("Moving " + moveX + ", " + moveY);
    }

    public void startRandomMover()  {
        executor.scheduleAtFixedRate(new Runnable()
        {
            public void run() {
                moveNow();
            }
        }, 0, 1, TimeUnit.SECONDS);
    }

    public static void main(String[] args) {
        new Main().startRandomMover();
    }
}
