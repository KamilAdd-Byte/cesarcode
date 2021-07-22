package com.bazarek.bazarek.polybius;

@FunctionalInterface
public interface PolybiusFunction {

    int[] decode (String textToDecode);

    /** Static method
     * @param textToConvert string to encode
     * @return array of characters.
     */
    static char[] textToChar (String textToConvert) {
        return textToConvert.trim().toLowerCase().toCharArray();
    }

}
