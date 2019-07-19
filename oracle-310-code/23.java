package org.kodejava.example.security;

import java.security.*;
import java.util.Base64;

public class GenerateKeyPairDemo {
    public static void main(String[] args) {
        try {
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("DSA", "SUN");

            // Initialize KeyPairGenerator.
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG", "SUN");
            keyGen.initialize(1024, random);

            // Generate Key Pairs, a private key and a public key.
            KeyPair keyPair = keyGen.generateKeyPair();
            PrivateKey privateKey = keyPair.getPrivate();
            PublicKey publicKey = keyPair.getPublic();

            Base64.Encoder encoder = Base64.getEncoder();
            System.out.println("privateKey: " + encoder.encodeToString(privateKey.getEncoded()));
            System.out.println("publicKey: " + encoder.encodeToString(publicKey.getEncoded()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        }
    }
}