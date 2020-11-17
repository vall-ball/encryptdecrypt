package encryptdecrypt;

public class ParserOfArgs {

    public String[] args;

    public ParserOfArgs(String[] args) {
        this.args = args;
    }

    public String mode() {
        for (int i = 0; i < args.length; i++) {
            if ("-mode".equals(args[i])) {
                return args[i + 1];
            }
        }
        return "enc";
    }

    public String text() {
        for (int i = 0; i < args.length; i++) {
            if ("-data".equals(args[i])) {
                return args[i + 1];
            }
        }
        return "";
    }

    public int key() {
        for (int i = 0; i < args.length; i++) {
            if ("-key".equals(args[i])) {
                return Integer.parseInt(args[i + 1]);
            }
        }
        return 0;
    }

    public String in() {
        for (int i = 0; i < args.length; i++) {
            if ("-in".equals(args[i])) {
                return args[i + 1];
            }
        }
        return "";
    }

    public String out() {
        for (int i = 0; i < args.length; i++) {
            if ("-out".equals(args[i])) {
                return args[i + 1];
            }
        }
        return "";
    }

    public String algorithm() {
        for (int i = 0; i < args.length; i++) {
            if ("-alg".equals(args[i])) {
                return args[i + 1];
            }
        }
        return "shift";
    }


}
