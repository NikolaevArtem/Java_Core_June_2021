package course_project.util;

import course_project.parts.GameField;

import java.util.HashMap;

import static java.lang.System.out;

public class PrinterOfMap {

    private final HashMap<Integer, String> myFieldSymbols = new HashMap<Integer, String>() {{
        put(0, ".");
        put(1, "H");
        put(2, "X");
        put(3, "X");
        put(4, "*");
    }};
    private final HashMap<Integer, String> enemyFieldSymbols = new HashMap<Integer, String>() {{
        put(0, ".");
        put(1, ".");
        put(2, "X");
        put(3, "X");
        put(4, "*");
    }};

    public void printPlayerField(GameField map) {
        print(map, myFieldSymbols);
    }

    public void printBotField(GameField radar) {
        print(radar, enemyFieldSymbols);
    }

    private void print(GameField map, HashMap<Integer, String> mapSymbols) {
        StringBuilder result = new StringBuilder();
        result.append("   А Б В Г Д Е Ж З И К\n");
        for (int i = 0; i < map.size()[0]; i++) {
            if (i > 8) {
                result.append(i + 1)
                        .append(" ");
            } else {
                result.append(i + 1)
                        .append("  ");
            }
            for (int j = 0; j < map.size()[0]; j++) {
                result.append(mapSymbols.get(map.getCell(i, j)))
                        .append(" ");
            }
            result.append("\n");
        }
        result.append("\n");
        out.print(result);
    }
}