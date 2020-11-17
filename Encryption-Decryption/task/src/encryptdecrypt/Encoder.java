package encryptdecrypt;

public class Encoder {

    public char cipherOneSimbol(char simbol, int key) {
        return (char) (simbol + key);
    }

    public String cipherWholeString(String text, int key) {
        char[] array = text.toCharArray();
        for (int i = 0; i < array.length; i ++) {
            array[i] = cipherOneSimbol(array[i], key);
        }
        return new String(array);
    }

}
