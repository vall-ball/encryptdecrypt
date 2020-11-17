package encryptdecrypt;

public class CaesarEncoder {
    public char cipherOneSimbol(char simbol, int key) {
        if (simbol >= 97 && simbol <= 122) {
        if ((char) (simbol + key) > 122) {
            return (char) ((simbol + key) - 26);
        } else {
            return (char) (simbol + key);
        }
        } else {
            return simbol;
        }
        }

    public String cipherWholeString(String text, int key) {
        char[] array = text.toCharArray();
        for (int i = 0; i < array.length; i ++) {
            array[i] = cipherOneSimbol(array[i], key);
        }
        return new String(array);
    }
}
