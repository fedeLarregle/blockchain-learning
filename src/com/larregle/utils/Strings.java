package com.larregle.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Strings {

    public static class Charset {
        public static final String UTF_8 = "UTF-8";
    }

    public static final String SHA_256 = "SHA-256";

    public static String sha256(String s) {
        StringBuilder result = new StringBuilder();
        MessageDigest messageDigest;

        try {
            messageDigest = MessageDigest.getInstance(SHA_256);
            byte[] hash = messageDigest.digest(s.getBytes(Charset.UTF_8));

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1) result.append('0');
                result.append(hex);
            }
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return result.toString();
    }
}
