package homework_2.random_chars_table;

import java.util.*;

public class RandomCharsTable {

    protected static final String ANSI_RED = "\u001B[31m";
    protected static final String ANSI_RESET = "\033[0m";

    public void start() {
        Scanner systemScanner = new Scanner(System.in);
        Scanner stringScanner;
        char[][] chars;
        String parity;
        List<Character> characterList;

        System.out.println("Enter width, height and parity");
        String s = systemScanner.nextLine();
        if (s.matches("^(([1-9][0-9]*\\s){2})(odd|even)")) {
            stringScanner = new Scanner(s);
            chars = RandomCharsTableCreator.initTable(stringScanner.nextInt(), stringScanner.nextInt());
            parity = stringScanner.next();
            characterList = checkChars(chars, parity);

            printTable(chars);
            System.out.println(parity + " letter(s) - " + getResult(characterList));
            stringScanner.close();
        } else {
            System.out.println(ANSI_RED + "Passed parameters should match the format [positive integer] [positive integer] [even|odd]" + ANSI_RESET);
        }

        systemScanner.close();
    }

    public void printTable(char[][] chars) {
        for (char[] aChar : chars) {
            System.out.print("|");
            for (char c : aChar) {
                System.out.print(c + "|");
            }
            System.out.println();
        }
    }

    protected String getResult(List<Character> characterList) {
        StringBuilder stringBuilder = new StringBuilder();
        ListIterator<Character> characterListIterator = characterList.listIterator();

        while (characterListIterator.hasNext()) {
            stringBuilder.append(characterListIterator.next());
            if (characterListIterator.hasNext()) {
                stringBuilder.append(", ");
            } else {
                stringBuilder.append("\n");
            }
        }
        return stringBuilder.toString();
    }

    protected List<Character> checkChars(char[][] chars, String parity) {
        List<Character> characterList = new ArrayList<>();

        for (char[] aChar : chars) {
            for (char c : aChar) {
                if (parity.equals("even")) {
                    if (c % 2 == 0) {
                        characterList.add(c);
                    }
                } else {
                    if (c % 2 == 1) {
                        characterList.add(c);
                    }
                }
            }
        }

        return characterList;
    }
}
