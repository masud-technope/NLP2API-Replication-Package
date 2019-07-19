package org.kodejava.example.commons.codec;

import org.apache.commons.codec.digest.DigestUtils;

public class MD5HashDemo {
    public static void main(String[] args) {
        // Calculates the MD5 digest for the password text and returns
        // the value as a 32 character hex string.
        String password = "s3cretw0rd**";
        String digest = DigestUtils.md5Hex(password);

        // Prints the plain text password, the digest and the length of
        // the digest.
        System.out.println("Password        = " + password);
        System.out.println("Password Digest = " + digest);
        System.out.println("Length          = " + digest.length());

        // Calculates the MD5 digest for the long texts.
        String md5 = "The MD5 message-digest algorithm is a formerly " +
                "widely used cryptographic hash function that produces " +
                "a 128-bit (16-byte) hash value. Specified in RFC 1321, " +
                "MD5 has been utilized in a wide variety of security " +
                "applications, and is also commonly used to check data " +
                "integrity. MD5 was designed by Ron Rivest in 1991 to " +
                "replace an earlier hash function, MD4. An MD5 hash value " +
                "is typically expressed as a hexadecimal number, 32 " +
                "digits long.";
        String fingerprint = DigestUtils.md5Hex(md5);

        // Prints the text, the fingerprint and the length of the digest /
        // fingerprint.
        System.out.println("Text        = " + md5);
        System.out.println("Fingerprint = " + fingerprint);
        System.out.println("Length      = " + fingerprint.length());
    }
}