package course_project.sea_battle.view;

import java.util.HashMap;
import java.util.Map;

public class Speaker {

    final private static Map<String, String> speaker;

    static {
        speaker = new HashMap<>();
        speaker.put("shotHit", "Hit!");
        speaker.put("shotMiss", "Miss!");
        speaker.put("coordinateFalse", "Not correct coordinates! Try again.");
        speaker.put("dialogName", "Write you Name:");
        speaker.put("lose1", "LOSE");
        speaker.put("win", "Winner: ");
        speaker.put("correct", "Successfully");
        speaker.put("error", "ERROR:");
        speaker.put("shot", "Player shot:");
        speaker.put("autoGenerate", "Do you want to automatically arrange the ships?\nPress Y-yes/N-no");
        speaker.put("notCorrect", "Not correct data");
        speaker.put("queuePlayer", "You turn, press number, a space and letter:");
        speaker.put("queueII", "Turn Bot!");
        speaker.put("repeatShot", "Repeat shot;-)))");
        speaker.put("fieldNotEmpty", "This coordinate is occupied by another ship");
        speaker.put("sizeShipBad", "you can't create a ship of this size");
        speaker.put("inputInstruction", "The first element is the location of the ship vertically - 1 horizontally-2.\n" +
                "Then a space, coordinates of the first number, a space, a letter.\n" +
                "Space, the length of the ship. input.");
}

    public static void voice(String dialogName) {
        System.out.println(speaker.get(dialogName));
    }
    public static void voice(String dialogName, String add) {
        System.out.println(speaker.get(dialogName) + " " + add);
    }
}
