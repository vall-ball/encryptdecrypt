package encryptdecrypt;

public class CaesarDecoder {
    public char cipherOneSimbol(char simbol, int key) {
        if (simbol >= 97 && simbol <= 122) {
                if ((char) (simbol - key) < 97) {
                    return (char) ((simbol - key) + 26);
                } else {
                    return (char) (simbol - key);
                }
            } else {
                return simbol;
            }

    }

    public String decipherWholeString(String text, int key) {
        char[] array = text.toCharArray();
        for (int i = 0; i < array.length; i ++) {
            array[i] = cipherOneSimbol(array[i], key);
        }
        return new String(array);
    }
}
