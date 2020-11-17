package encryptdecrypt;

public class Decoder {

    public char decipherOneSimbol(char simbol, int key) {
        return (char) (simbol - key);
    }

    public String decipherWholeString(String text, int key) {
        char[] array = text.toCharArray();
        for (int i = 0; i < array.length; i ++) {
            array[i] = decipherOneSimbol(array[i], key);
        }
        return new String(array);
    }

}
