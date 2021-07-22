package homework_2.random_chars_table;

import java.util.*;

public class RandomCharsTable {

    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_RESET = "\033[0m";
    private static final String ERROR_MESSAGE = "Passed parameters should match the format [positive integer] [positive integer] [even|odd]";

    public void run() {
        Scanner systemScanner = new Scanner(System.in);

        System.out.println("Enter width, height and parity");
        String s = systemScanner.nextLine();
        if (s.matches("^(([1-9][0-9]*\\s){2})(odd|even)")) {
            Scanner stringScanner = new Scanner(s);
            char[][] chars = RandomCharsTableCreator.initTable(stringScanner.nextInt(), stringScanner.nextInt());
            String parity = stringScanner.next();
            List<Character> characterList = getValidChars(chars, parity);

            printTable(chars);
            System.out.println(parity + " letters - " + getResult(characterList));
            stringScanner.close();
        } else {
            System.out.println(ANSI_RED + ERROR_MESSAGE + ANSI_RESET);
        }

        systemScanner.close();
    }

    public void printTable(char[][] arrayOfChars) {
        for (char[] chars : arrayOfChars) {
            System.out.print("|");
            for (char ch : chars) {
                System.out.print(ch + "|");
            }
            System.out.println();
        }
    }

    private String getResult(List<Character> characterList) {
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

    private List<Character> getValidChars(char[][] arrayOfChars, String parity) {
        List<Character> characterList = new ArrayList<>();

        for (char[] chars : arrayOfChars) {
            for (char ch : chars) {
                if (parity.equals("even")) {
                    if (ch % 2 == 0) {
                        characterList.add(ch);
                    }
                } else {
                    if (ch % 2 == 1) {
                        characterList.add(ch);
                    }
                }
            }
        }

        return characterList;
    }
}
