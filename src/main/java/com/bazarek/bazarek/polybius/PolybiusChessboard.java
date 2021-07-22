package com.bazarek.bazarek.polybius;

/**
 * @apiNote Decode and Encode text (String) by Polybius chessboard cipher.
 * @author kamillodzinski
 */
public class PolybiusChessboard implements PolybiusFunction{

    private int[] decode;
    private int nElem;

    /**
     * @apiNote 'converseCharToNumber' get two private method:
     * @param charToConvert char to decode in Polybius chessboard cipher.
     * @return int converted from char on the basis of a Polybius chessboard cipher.
     */
    public static int converseCharToNumber(char charToConvert) {
        return charToNumberPolybiusChessboardCode(charToConvert);
    }

    /**
     * @apiNote 'converseCharToNumber' get two private method
     * @param intToConvert int to decode in Polybius chessboard.
     * @return char converted from int on the basis of a Polybius chessboard cipher.
     */
    public static char converseNumberToChar(int intToConvert){
        return numberToCharPolybiusChessboardCode(intToConvert);
    }

    /**
     * @param textToDecode to decode in Polybius chessboard cipher.
     * @return array of numbers decode text in Polybius chessboard cipher .
     */
    public int[] decode (String textToDecode){
        char[] chars = PolybiusFunction.textToChar(textToDecode);
        decode = new int[chars.length];
        for (char inputChar : chars) {
            int i = converseCharToNumber(inputChar);
            insert(i);
        }
        return decode;
    }

    /**
     * @param toEncode to encode in a Polybius chessboard cipher .
     * @return string encode text in a Polybius chessboard cipher.
     */
    public String encode (int[] toEncode){
        StringBuilder newString = new StringBuilder();
        for (int i : toEncode) {
            char converseNumberToChar = converseNumberToChar(i);
            newString.append(converseNumberToChar);
        }
        return newString.toString();
    }


    /**
     * @param value put number to array
     */
    public void insert (int value){
        decode[nElem] = value;
        nElem++;
    }


    private static char numberToCharPolybiusChessboardCode(int intToConvert) {
        return getCharPolybiusChessboard(intToConvert);
    }

    private static char getCharPolybiusChessboard(int intToConvert) {
        char a = 'a';
        int aChar = a - 86;
        char b = 'b';
        int bChar = b - 86;
        char c = 'c';
        int cChar = c - 86;
        char d = 'd';
        int dChar = d - 86;
        char e = 'e';
        int eChar = e - 86;
        char f = 'f';
        int fChar = f - 81;
        char g = 'g';
        int gChar = g - 81;
        char h = 'h';
        int hChar = h - 81;
        char i = 'i';
        int iChar = i - 81;
        char j = 'j';
        int jChar = i - 81;
        char k = 'k';
        int kChar = j - 81;
        char l = 'l';
        int lChar = l - 77;
        char m = 'm';
        int mChar = m - 77;
        char n = 'n';
        int nChar = n - 77;
        char o = 'o';
        int oChar = o - 77;
        char p = 'p';
        int pChar = p - 77;
        char q = 'q';
        int qChar = q - 72;
        char r = 'r';
        int rChar = r - 72;
        char s = 's';
        int sChar = s - 72;
        char t = 't';
        int tChar = t - 72;
        char u = 'u';
        int uChar = u - 72;
        char v = 'v';
        int vChar = v - 67;
        char w = 'w';
        int wChar = w - 67;
        char x = 'x';
        int xChar = x - 67;
        char y = 'y';
        int yChar = y - 67;
        char z = 'z';
        int zChar = z - 67;

        Character a1 = getCharacter(intToConvert, aChar, bChar, cChar, dChar, eChar, fChar, gChar, hChar, iChar, jChar, kChar, lChar, mChar, nChar, oChar, pChar, qChar, rChar, sChar, tChar, uChar, vChar, wChar, xChar, yChar, zChar);
        if (a1 != null) return a1;
        return 0;
    }

    private static Character getCharacter(int intToConvert, int aChar, int bChar, int cChar, int dChar, int eChar, int fChar, int gChar, int hChar, int iChar, int jChar, int kChar, int lChar, int mChar, int nChar, int oChar, int pChar, int qChar, int rChar, int sChar, int tChar, int uChar, int vChar, int wChar, int xChar, int yChar, int zChar) {
        char convertCharToInt = '.';
        if (intToConvert == aChar) {
            return 'a';
        }
        if (intToConvert == bChar) {
            return 'b';
        }
        if (intToConvert == cChar) {
            return 'c';
        }
        if (intToConvert == dChar) {
            return 'd';
        }
        if (intToConvert == eChar) {
            return 'e';
        }
        if (intToConvert == fChar) {
            return 'f';
        }
        if (intToConvert == gChar) {
            return 'g';
        }
        if (intToConvert == hChar) {
            return 'h';
        }
        if (intToConvert == iChar) {
            return 'i';
        }
        if (intToConvert == jChar) {
            return 'j';
        }
        if (intToConvert == kChar) {
            return 'k';
        }
        if (intToConvert == lChar) {
            return 'l';
        }
        if (intToConvert == mChar) {
            return 'm';
        }
        if (intToConvert == nChar) {
            return 'n';
        }
        if (intToConvert == oChar) {
            return 'o';
        }
        if (intToConvert == pChar) {
            return 'p';
        }
        if (intToConvert == qChar) {
            return 'q';
        }
        if (intToConvert == rChar) {
            return 'r';
        }
        if (intToConvert == sChar) {
            return 's';
        }
        if (intToConvert == tChar) {
            return 't';
        }
        if (intToConvert == uChar) {
            return 'u';
        }
        if (intToConvert == vChar) {
            return 'f';
        }
        if (intToConvert == wChar) {
            return 'w';
        }
        if (intToConvert == xChar) {
            return 'x';
        }
        if (intToConvert == yChar) {
            return 'y';
        }
        if (intToConvert == zChar) {
            return 'z';
        }
        return convertCharToInt;
    }

    private static int charToNumberPolybiusChessboardCode(char charToConvert) {
        return getNumberPolybiusChessboard(charToConvert);
    }

    private static int getNumberPolybiusChessboard(char charToConvert) {
        char a = 'a';
        int aChar = a - 86;
        char b = 'b';
        int bChar = b - 86;
        char c = 'c';
        int cChar = c - 86;
        char d = 'd';
        int dChar = d - 86;
        char e = 'e';
        int eChar = e - 86;
        char f = 'f';
        int fChar = f - 81;
        char g = 'g';
        int gChar = g - 81;
        char h = 'h';
        int hChar = h - 81;
        char i = 'i';
        int iChar = i - 81;
        char j = 'j';
        int jChar = i - 81;
        char k = 'k';
        int kChar = j - 81;
        char l = 'l';
        int lChar = l - 77;
        char m = 'm';
        int mChar = m - 77;
        char n = 'n';
        int nChar = n - 77;
        char o = 'o';
        int oChar = o - 77;
        char p = 'p';
        int pChar = p - 77;
        char q = 'q';
        int qChar = q - 72;
        char r = 'r';
        int rChar = r - 72;
        char s = 's';
        int sChar = s - 72;
        char t = 't';
        int tChar = t - 72;
        char u = 'u';
        int uChar = u - 72;
        char v = 'v';
        int vChar = v - 67;
        char w = 'w';
        int wChar = w - 67;
        char x = 'x';
        int xChar = x - 67;
        char y = 'y';
        int yChar = y - 67;
        char z = 'z';
        int zChar = z - 67;

        return checkCharAndConvertToNumber(charToConvert, aChar, bChar, cChar, dChar, eChar,
                fChar, gChar, hChar, iChar, jChar, kChar, lChar, mChar,
                nChar, oChar, pChar, qChar, rChar, sChar, tChar, uChar, vChar, wChar, xChar, yChar, zChar);
    }

    private static int checkCharAndConvertToNumber(char charToConvert, int aChar, int bChar, int cChar, int dChar,
                                                   int eChar, int fChar, int gChar, int hChar, int iChar, int jChar, 
                                                   int kChar, int lChar, int mChar, int nChar, int oChar, int pChar, 
                                                   int qChar, int rChar, int sChar, int tChar, int uChar, int vChar, 
                                                   int wChar, int xChar, int yChar, int zChar) {
        int convertChar = 0;
        if (charToConvert == 'a') {
            return aChar;
        }
        if (charToConvert == 'b') {
            return bChar;
        }
        if (charToConvert == 'c') {
            return cChar;
        }
        if (charToConvert == 'd') {
            return dChar;
        }
        if (charToConvert == 'e') {
            return eChar;
        }
        if (charToConvert == 'f') {
            return fChar;
        }
        if (charToConvert == 'g') {
            return gChar;
        }
        if (charToConvert == 'h') {
            return hChar;
        }
        if (charToConvert == 'i') {
            return iChar;
        }
        if (charToConvert == 'j') {
            return jChar;
        }
        if (charToConvert == 'k') {
            return kChar;
        }
        if (charToConvert == 'l') {
            return lChar;
        }
        if (charToConvert == 'm') {
            return mChar;
        }
        if (charToConvert == 'n') {
            return nChar;
        }
        if (charToConvert == 'o') {
            return oChar;
        }
        if (charToConvert == 'p') {
            return pChar;
        }
        if (charToConvert == 'q') {
            return qChar;
        }
        if (charToConvert == 'r') {
            return rChar;
        }
        if (charToConvert == 's') {
            return sChar;
        }
        if (charToConvert == 't') {
            return tChar;
        }
        if (charToConvert == 'u') {
            return uChar;
        }
        if (charToConvert == 'v') {
            return vChar;
        }
        if (charToConvert == 'w') {
            return wChar;
        }
        if (charToConvert == 'x') {
            return xChar;
        }
        if (charToConvert == 'y') {
            return yChar;
        }
        if (charToConvert == 'z') {
            return zChar;
        }
        return convertChar;
    }
}

