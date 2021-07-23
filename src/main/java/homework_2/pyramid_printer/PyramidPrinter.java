package homework_2.pyramid_printer;

import homework_2.ConsoleSafeReader;


public class PyramidPrinter {

    private static String brick = "x";
    private static String mode = "default";

    PyramidPrinter(String... args) {
        if (args.length != 0) {
            for (int i = 0; i < args.length; i+=2 ) {
                if ("-mode".equals(args[i])) {
                    if ("symmetric".equals(args[i + 1]) ||
                            "inverse".equals(args[i + 1]) ||
                            "rightSide".equals(args[i + 1])) {
                        PyramidPrinter.mode = args[i + 1];
                    }
                }
                if ("-brick".equals(args[i])) {
                    PyramidPrinter.brick = args[i + 1];
                }
            }
        }
    }

    public void run() {
        System.out.println("How many levels should the pyramid be?");
        String input = ConsoleSafeReader.read();
        String result = processData(input);
        System.out.println(result);
    }

    String processData(String input) {
        if ("Error.".equals(input)) {
            return input;
        }
        try {
            int levels = Integer.parseInt(input);
            if (levels < 0) {
                throw new NumberFormatException();
            }
            return print(levels);
        } catch (NumberFormatException e) {
            return "Only 1 non-negative integer is allowed as passed parameter";
        }
    }

     private String print(int levels) throws NumberFormatException{

        StringBuilder s = new StringBuilder();
        if ("symmetric".equals(mode)) {
            symmetricMode(s, levels);
        } else if ("rightSide".equals(mode)) {
            rightSideMode(s, levels);
        } else if ("inverse".equals(mode)) {
            inverseMode(s, levels);
        } else if ("default".equals(mode)) {
            defaultMode(s, levels);
        }
        return s.toString();
    }

    private void symmetricMode(StringBuilder s, int levels) {
        for (int i = 1; i <= levels; i++) {
            for (int j = 0; j < levels * 2 - 1; j++) {
                if (j >= levels - i && j < levels + i - 1) {
                    s.append(brick);
                } else {
                    for (int l = 0; l < brick.length(); l++) {
                        s.append(" ");
                    }
                }
            }
            s.append("\n");
        }
    }

    private void rightSideMode(StringBuilder s, int levels) {
        for (int i = 1; i <= levels; i++) {
            for (int j = 0; j < levels; j++) {
                if (j < levels - i ) {
                    for (int l = 0; l < brick.length(); l++) {
                        s.append(" ");
                    }
                } else {
                    s.append(brick);
                }
            }
            s.append("\n");
        }
    }

    private void inverseMode(StringBuilder s, int levels) {
        for (int i = 1; i <= levels; i++) {
            for (int j = 0; j < levels; j++) {
                if (j < levels - i + 1) {
                    s.append(brick);
                } else {
                    for (int l = 0; l < brick.length(); l++) {
                        s.append(" ");
                    }
                }
            }
            s.append("\n");
        }
    }

    private void defaultMode(StringBuilder s, int levels) {
        StringBuilder temp = new StringBuilder(brick);
        for (int i = 1; i <= levels; i++) {
            s.append(temp).append("\n");
            temp.append(brick);
        }
    }
}
