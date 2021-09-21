package couse_project;

import java.io.IOException;
import java.util.HashMap;

public class Displayer {

    private final String columns = "   А Б В Г Д Е Ж З И К\n";
    private final String row = "%2d %s %s %s %s %s %s %s %s %s %s\n";
    private final HashMap<Integer, String> mapSymbols = new HashMap<Integer, String>() {{
        put(0, " ");  // пустая клетка
        put(1, Color.setColor("■", Color.blue));  // корабль
        put(2, Color.setColor("□", Color.yellow)); // подбитый корабль
        put(3, Color.setColor("X", Color.red)); // разрушенный корабль
        put(4, Color.setColor("*", Color.white)); // промах
    }};
    private final HashMap<Integer, String> radarSymbols = new HashMap<Integer, String>() {{
        put(0, " ");  // пустая клетка
        put(1, " ");  // корабль
        put(2, Color.setColor("□", Color.yellow)); // подбитый корабль
        put(3, Color.setColor("X", Color.red)); // разрушенный корабль
        put(4, Color.setColor("*", Color.white)); // промах
    }};

    public void clearScreen() throws IOException, InterruptedException {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win")) {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } else if (os.contains("nix") || os.contains("nux")) {
            new ProcessBuilder("terminal", "/c", "clear").inheritIO().start().waitFor();
        }
        System.out.println();
    }

    public void displayMap(SeaMap map) {
        StringBuilder mapImage = new StringBuilder();
        mapImage.append(columns);
        for (int i = 0; i < map.size()[0]; i++) {
            mapImage.append(String.format(row, i + 1,
                    mapSymbols.get(map.getCell(i, 0)), mapSymbols.get(map.getCell(i, 1)),
                    mapSymbols.get(map.getCell(i, 2)), mapSymbols.get(map.getCell(i, 3)),
                    mapSymbols.get(map.getCell(i, 4)), mapSymbols.get(map.getCell(i, 5)),
                    mapSymbols.get(map.getCell(i, 6)), mapSymbols.get(map.getCell(i, 7)),
                    mapSymbols.get(map.getCell(i, 8)), mapSymbols.get(map.getCell(i, 9))));
        }
        mapImage.append("\n");
        System.out.print(mapImage);
    }

    public void displayRadar(SeaMap radar) {
        StringBuilder radarImage = new StringBuilder();
        radarImage.append(columns);
        for (int i = 0; i < radar.size()[0]; i++) {
            radarImage.append(String.format(row, i + 1,
                    radarSymbols.get(radar.getCell(i, 0)), radarSymbols.get(radar.getCell(i, 1)),
                    radarSymbols.get(radar.getCell(i, 2)), radarSymbols.get(radar.getCell(i, 3)),
                    radarSymbols.get(radar.getCell(i, 4)), radarSymbols.get(radar.getCell(i, 5)),
                    radarSymbols.get(radar.getCell(i, 6)), radarSymbols.get(radar.getCell(i, 7)),
                    radarSymbols.get(radar.getCell(i, 8)), radarSymbols.get(radar.getCell(i, 9))));
        }
        radarImage.append("\n");
        System.out.print(radarImage);
    }
}
