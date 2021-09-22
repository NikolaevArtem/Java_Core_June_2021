package course_project.parts;

import java.util.HashMap;
import java.util.Random;

public class Bot {

    private GameField personField;

    public Bot(GameField personField) {
        this.personField = personField;
    }

    private final HashMap<Integer, String> commandsMap = new HashMap<Integer, String>() {{
        put(0, "А");
        put(1, "Б");
        put(2, "В");
        put(3, "Г");
        put(4, "Д");
        put(5, "Е");
        put(6, "Ж");
        put(7, "З");
        put(8, "И");
        put(9, "К");
    }};

    public boolean shoot() {
        Random random = new Random();
        int x = random.nextInt(10);
        int y = random.nextInt(10);
        if (personField.isFreeEnterCell(x, y)) {
            System.out.println("Выстрел в " + commandsMap.get(x) + (y + 1));
            return personField.registerShot(x, y);
        }
        shoot();
        return false;
    }

    public boolean isWinner() {
        return personField.isAllShipsDestroyed();
    }
}
