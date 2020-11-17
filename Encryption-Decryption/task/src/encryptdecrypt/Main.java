package encryptdecrypt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        ParserOfArgs parser = new ParserOfArgs(args);
        String mode = parser.mode();
        String text = parser.text();
        int key = parser.key();
        String algorithm = parser.algorithm();

        String in = parser.in();
        String out = parser.out();

        FileWriter writer = null;
        if (out.length() > 0) {
            writer = new FileWriter(out);
        }

        File file = null;
        if (in.length() != 0) {
            file = new File(in);
        }
        String input = "";
        if (in.length() > 0) {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                input = scanner.nextLine();
            }
            scanner.close();
        }

        if (text.length() == 0 && input.length() != 0) {
            text = input;
        }


        switch (mode) {
            case "enc":
                if (algorithm.equals("unicode")) {
                    Encoder encoder = new Encoder();
                    String encodedText = encoder.cipherWholeString(text, key);
                    if (writer != null) {
                        writer.write(encodedText);
                        writer.close();
                    } else {
                        System.out.println(encodedText);
                    }
                } else if (algorithm.equals("shift")) {
                    CaesarEncoder encoder = new CaesarEncoder();
                    String encodedText = encoder.cipherWholeString(text, key);
                    if (writer != null) {
                        writer.write(encodedText);
                        writer.close();
                    } else {
                        System.out.println(encodedText);
                    }
                }
                    break;

            case "dec":
                if (algorithm.equals("unicode")) {
                    Decoder decoder = new Decoder();
                    String decodedText = decoder.decipherWholeString(text, key);
                    if (writer != null) {
                        writer.write(decodedText);
                        writer.close();
                    } else {
                        System.out.println(decodedText);
                    }
                } else if (algorithm.equals("shift")) {
                    CaesarDecoder decoder = new CaesarDecoder();
                    String decodedText = decoder.decipherWholeString(text, key);
                    if (writer != null) {
                        writer.write(decodedText);
                        writer.close();
                    } else {
                        System.out.println(decodedText);
                    }
                }

                break;
            default:
                break;
        }

        /*
         Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        String text = scanner.nextLine();
        int key = scanner.nextInt();
         */

    }
}
