import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;

public class Main {
  public static void main(String[] argv) throws Exception {
    KeyGenerator keyGen = KeyGenerator.getInstance("HmacMD5");
    SecretKey key = keyGen.generateKey();

    Mac mac = Mac.getInstance(key.getAlgorithm());
    mac.init(key);

    String str = "This message will be digested";

    byte[] utf8 = str.getBytes("UTF8");
    byte[] digest = mac.doFinal(utf8);

    String digestB64 = new sun.misc.BASE64Encoder().encode(digest);
    System.out.println(digestB64);
  }
}