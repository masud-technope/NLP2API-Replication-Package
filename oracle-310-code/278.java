import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class Main {
  public static void main(String[] argv) throws Exception {
    File file = new File("filename");
    FileChannel channel = new RandomAccessFile(file, "rw").getChannel();

    FileLock lock = channel.lock(0, Long.MAX_VALUE, true);

    lock = channel.tryLock(0, Long.MAX_VALUE, true);

    boolean isShared = lock.isShared();

    lock.release();

    channel.close();
  }
}
