import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;

public class GenSig {

  public static void main(String[] args) {

    /* Generate a DSA signature */

    if (args.length != 1) {
      System.out.println("Usage: GenSig nameOfFileToSign");
    } else
      try {

        /* Generate a key pair */

        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("DSA",
            "SUN");
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG",
            "SUN");

        keyGen.initialize(1024, random);

        KeyPair pair = keyGen.generateKeyPair();
        PrivateKey priv = pair.getPrivate();
        PublicKey pub = pair.getPublic();

        /*
         * Create a Signature object and initialize it with the private
         * key
         */

        Signature dsa = Signature.getInstance("SHA1withDSA", "SUN");

        dsa.initSign(priv);

        /* Update and sign the data */

        FileInputStream fis = new FileInputStream(args[0]);
        BufferedInputStream bufin = new BufferedInputStream(fis);
        byte[] buffer = new byte[1024];
        int len;
        while (bufin.available() != 0) {
          len = bufin.read(buffer);
          dsa.update(buffer, 0, len);
        }
        ;

        bufin.close();

        /*
         * Now that all the data to be signed has been read in, generate
         * a signature for it
         */

        byte[] realSig = dsa.sign();

        /* Save the signature in a file */
        FileOutputStream sigfos = new FileOutputStream("sig");
        sigfos.write(realSig);

        sigfos.close();

        /* Save the public key in a file */
        byte[] key = pub.getEncoded();
        FileOutputStream keyfos = new FileOutputStream("suepk");
        keyfos.write(key);

        keyfos.close();

      } catch (Exception e) {
        System.err.println("Caught exception " + e.toString());
      }

  };

}
