package org.kodejava.example.security;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;

public class VerifyDigitalSignature {
    public static void main(String[] args) {
        try {
            byte[] publicKeyEncoded = Files.readAllBytes(Paths.get("publickey"));
            byte[] digitalSignature = Files.readAllBytes(Paths.get("signature"));

            X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(publicKeyEncoded);
            KeyFactory keyFactory = KeyFactory.getInstance("DSA", "SUN");

            PublicKey publicKey = keyFactory.generatePublic(publicKeySpec);
            Signature signature = Signature.getInstance("SHA1withDSA", "SUN");
            signature.initVerify(publicKey);

            byte[] bytes = Files.readAllBytes(Paths.get("README"));
            signature.update(bytes);

            boolean verified = signature.verify(digitalSignature);
            if (verified) {
                System.out.println("Data verified.");
            } else {
                System.out.println("Cannot verify data.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}