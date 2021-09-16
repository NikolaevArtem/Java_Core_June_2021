package course_project.sea_battle.conroller;

import course_project.sea_battle.model.CoordinateTranslator;
import course_project.sea_battle.model.ModelPlayer;
import course_project.sea_battle.model.Ship;
import course_project.sea_battle.view.PaintFieldPlayer;
import course_project.sea_battle.view.Speaker;
import java.util.Scanner;

public class Dialog {

    private final Scanner reader;

    public Dialog(final Scanner reader) {
        this.reader = reader;
    }

    public void generateShips(ModelPlayer player) {
        PaintFieldPlayer paint = new PaintFieldPlayer(player);
        Speaker.voice("inputInstruction");
        while (!player.readyToGame()) {
            paint.paintField();
            String dateShip = reader.nextLine();
            tryAddShipInField(dateShip, player);
        }
    }

    public String namePlayerGet() {
        try {
            String name = reader.nextLine();
            return name;
        } catch (Exception e) {

        }
        return "Empty";
    }

    public String shotPlayer(ModelPlayer player) {
           while (true) {
               String shot = reader.nextLine();
               if (shot.matches("(([1-9])|([1][0])) [a-jA-J]")) {
                   return player.shot(shot);
               } else {
                   Speaker.voice("notCorrect");
               }
           }
    }

    public boolean autoGenerate() {
        while (true) {
            String choice = reader.nextLine();
            if (choice.matches("y|n")) {
                if (choice.equals("y")) {
                    return true;
                }
                if (choice.equals("n")) {
                    return false;
                }
            } else {
                Speaker.voice("notCorrect");
            }
        }
    }

    private void tryAddShipInField(String dateShip, ModelPlayer player){
        if (dateShip.matches("[1-2] (([1-9])|([1][0])) [a-jA-J] [1-4]")) {

            String[] dateShipSplit = dateShip.split(" ");
            boolean orient = dateShipSplit[0].equals("2");
            int start = Integer.parseInt(dateShipSplit[1]) - 1;
            int end = CoordinateTranslator.coordinate(dateShipSplit[2]);
            int size = Integer.parseInt(dateShipSplit[3]);

            String message = player.addShip(new Ship(orient, start, end, size));
            Speaker.voice(message);
        } else {
            Speaker.voice("notCorrect");
        }
    }

}
