package couse_project;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Player {
    final private String name;
    private final SeaMap map;
    private final SeaMap radar;
    final private String[] commands = new String[]{
            "А1", "А2", "А3", "А4", "А5", "А6", "А7", "А8", "А9", "А10",
            "Б1", "Б2", "Б3", "Б4", "Б5", "Б6", "Б7", "Б8", "Б9", "Б10",
            "В1", "В2", "В3", "В4", "В5", "В6", "В7", "В8", "В9", "В10",
            "Г1", "Г2", "Г3", "Г4", "Г5", "Г6", "Г7", "Г8", "Г9", "Г10",
            "Д1", "Д2", "Д3", "Д4", "Д5", "Д6", "Д7", "Д8", "Д9", "Д10",
            "Е1", "Е2", "Е3", "Е4", "Е5", "Е6", "Е7", "Е8", "Е9", "Е10",
            "Ж1", "Ж2", "Ж3", "Ж4", "Ж5", "Ж6", "Ж7", "Ж8", "Ж9", "Ж10",
            "З1", "З2", "З3", "З4", "З5", "З6", "З7", "З8", "З9", "З10",
            "И1", "И2", "И3", "И4", "И5", "И6", "И7", "И8", "И9", "И10",
            "К1", "К2", "К3", "К4", "К5", "К6", "К7", "К8", "К9", "К10",
    };
    final private HashMap<String, Integer> commandsMap = new HashMap<String, Integer>() {{
        put("А", 0);
        put("Б", 1);
        put("В", 2);
        put("Г", 3);
        put("Д", 4);
        put("Е", 5);
        put("Ж", 6);
        put("З", 7);
        put("И", 8);
        put("К", 9);
    }};

    public Player(String name, SeaMap map, SeaMap radar) {
        this.name = name;
        this.map = map;
        this.radar = radar;
    }

    public boolean shoot() {
        Scanner in = new Scanner(System.in);
        System.out.println("Ваш ход:");
        String command = in.nextLine();

        if (Arrays.asList(commands).contains(command)) {
            System.out.println(command.toUpperCase().charAt(0));

            int x = commandsMap.get((Character.toString(command.toUpperCase().charAt(0))));
            int y = Integer.parseInt(Character.toString(command.charAt(1))) - 1;

            if (radar.isFreeEnterCell(x, y)) {
                return radar.registerShot(x, y);
            }
        } else {
            System.out.println("Ошибка формата данных");
            System.out.println("Попробуйте, пожалуйста, ещё раз");
        }

        shoot();
        return false;
    }

    public SeaMap getMap() {
        return map;
    }

    public SeaMap getRadar() {
        return radar;
    }
}