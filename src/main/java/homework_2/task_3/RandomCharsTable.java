package homework_2.task_3;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

/**
 * todo Document type RandomCharsTable
 */
public class RandomCharsTable {
    private int height;
    private int width;
    private String parity;
    private char[][] chars;
    private List<Character> characterList = new ArrayList<>();

    public RandomCharsTable() {
    }

    public RandomCharsTable(int height, int w, String parity) {
        this.height = height;
        this.width = w;
        this.parity = parity;
        initTable();
    }

    public void initTable() {
        chars = new char[height][width];
        Random random = new Random();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                chars[i][j] = (char) (random.nextInt(26) + 65);
                checkChar(i, j);
            }
        }
    }

    public void printTable() {
        for (int i = 0; i < height; i++) {
            System.out.print("|");
            for (int j = 0; j < width; j++) {
                System.out.print(chars[i][j] + "|");
            }
            System.out.println();
        }
    }

    public void getResult() {
        printTable();
        ListIterator<Character> characterListIterator = characterList.listIterator();
        System.out.print(parity + " letter(s) - ");
        while (characterListIterator.hasNext()) {
            System.out.print(characterListIterator.next());
            if (characterListIterator.hasNext()) {
                System.out.print(", ");
            } else {
                System.out.println();
            }
        }
    }

    private void checkChar(int i, int j) {
        if (parity.equals("even")) {
            if (chars[i][j] % 2 == 0) {
                characterList.add(chars[i][j]);
            }
        } else {
            if (chars[i][j] % 2 == 1) {
                characterList.add(chars[i][j]);
            }
        }
    }
}
