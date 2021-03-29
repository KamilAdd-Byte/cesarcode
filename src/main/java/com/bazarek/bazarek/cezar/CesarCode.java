package com.bazarek.bazarek.cezar;

public class CesarCode {
    /**
     * @param text = "word to decode and encode"
     * @return decode and encode text ASCII char
     */
    public static String encode(String text) {
        StringBuilder newString = new StringBuilder();
        for (char c : text.toCharArray()) {
            char encodeChar = (char) (65 + (c - 62) % 26);
            newString.append(encodeChar);
        }
        return newString.toString();
    }

    public static String decode(String text) {
        StringBuilder newString = new StringBuilder();
        for (char c : text.toCharArray()) {
            char decodeChar = (char) (65 + (c - 42) % 26);
            newString.append(decodeChar);
        }
        return newString.toString();
    }

    public static boolean valid(String text) {
        for (char c : text.toCharArray()) {
            if (c < 'A' || c > 'Z') {
                return false;
            }
        }
        return true;
    }
}
