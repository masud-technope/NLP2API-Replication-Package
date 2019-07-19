import java.io.Serializable;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignedObject;

public class Main {
  public static void main(String[] argv) throws Exception {
    KeyPairGenerator keyGen = KeyPairGenerator.getInstance("DSA");
    keyGen.initialize(1024);
    KeyPair keypair = keyGen.genKeyPair();
    PrivateKey privateKey = keypair.getPrivate();
    PublicKey publicKey = keypair.getPublic();

    Serializable o = new MyClass();
    Signature sig = Signature.getInstance(privateKey.getAlgorithm());
    SignedObject so = new SignedObject(o, privateKey, sig);
    
    sig = Signature.getInstance(publicKey.getAlgorithm());
    boolean b = so.verify(publicKey, sig);
    o = (MyClass) so.getObject();
  }
}

class MyClass implements Serializable {
  String s = "my string";
  int i = 123;
}