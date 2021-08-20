package homework_2.random_chars_table;

import base.BaseClazz;

import java.util.*;

public class RandomCharsTable extends BaseClazz {

    private static final String ERROR_MESSAGE = "Passed parameters should match the format [positive integer] [positive integer] [even|odd]";

    @Override
    public void run() {
        Scanner systemScanner = new Scanner(System.in);

        System.out.println("Enter width, height and parity");
        String s = systemScanner.nextLine();
        if (isValid(s)) {
            Scanner stringScanner = new Scanner(s);
            char[][] table = RandomCharsTableCreator.initAndFillTable(stringScanner.nextInt(), stringScanner.nextInt());
            String parity = stringScanner.next();
            List<Character> characterList = getValidChars(table, parity);

            printTable(table);
            System.out.println(parity + " letters - " + getResult(characterList));
            stringScanner.close();
        } else {
            System.out.println(ANSI_RED + ERROR_MESSAGE + ANSI_RESET);
        }

        systemScanner.close();
    }

    @Override
    protected boolean isValid(String... inputStr) {
        if (inputStr.length > 1) return false;
        return inputStr[0].matches("^(([1-9][0-9]*\\s){2})(odd|even)");
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
