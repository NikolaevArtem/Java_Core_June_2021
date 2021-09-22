package course_project.parts;

import java.util.HashMap;
import java.util.Random;

public class Bot {

    private GameField personField;

    public Bot(GameField personField) {
        this.personField = personField;
    }

    private final HashMap<Integer, String> commandsMap = new HashMap<Integer, String>() {{
        put(0, "A");
        put(1, "B");
        put(2, "C");
        put(3, "D");
        put(4, "E");
        put(5, "F");
        put(6, "G");
        put(7, "H");
        put(8, "I");
        put(9, "J");
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
