package course_project.parts;

import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Player {
    private String name;
    private GameField myField;
    private GameField enemyField;
    private final HashMap<String, Integer> commandsMap = new HashMap<String, Integer>() {{
        put("A", 0);
        put("B", 1);
        put("C", 2);
        put("D", 3);
        put("E", 4);
        put("F", 5);
        put("G", 6);
        put("H", 7);
        put("I", 8);
        put("J", 9);
    }};

    public Player(String name, GameField myField, GameField enemyField) {
        this.name = name;
        this.myField = myField;
        this.enemyField = enemyField;
    }

    public boolean shoot() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите клетку:");
        String command = in.nextLine();
        if (Pattern.matches("([A-Ja-j])\\d{1,2}", command)) {
            int x = commandsMap.get((Character.toString(command.toUpperCase().charAt(0))));
            int y = Integer.parseInt(command.substring(1)) - 1;
            if (y >= 0 && y < 10) {
                if (enemyField.isFreeEnterCell(x, y)) {
                    return enemyField.registerShot(x, y);
                } else {
                    System.out.println("Сюда больше стрелять нельзя");
                }
            }
        }
        System.out.println("Ошибка ввода, допустимый формат ввода: \"б2\" или \"Б10\"");
        System.out.println("Попробуйте ещё раз.");
        shoot();
        return false;
    }

    public GameField getMyField() {
        return myField;
    }

    public GameField getEnemyField() {
        return enemyField;
    }

    public String getName() {
        return name;
    }

    public boolean isWinner() {
        return enemyField.isAllShipsDestroyed();
    }
}
