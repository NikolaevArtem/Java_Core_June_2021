package course_project.sea_battle.conroller;

import course_project.sea_battle.model.Player;
import course_project.sea_battle.model.Ship;
import course_project.sea_battle.view.Speaker;

import java.io.BufferedReader;
import java.io.IOException;

public class Dialog {

    private final BufferedReader reader;

    public Dialog(final BufferedReader reader) {
        this.reader = reader;
    }

    public Ship reader() {
        try {

            String dateShip = reader.readLine();
            if (dateShip.matches("[1-2] [0-9][0]* [0-9][0]* [1-4]")) {
                String[] dateShipSplit = dateShip.split(" ");
                boolean orient = dateShipSplit[0].equals("2");
                int start = Integer.parseInt(dateShipSplit[1]) - 1;
                int end = Integer.parseInt(dateShipSplit[2]) - 1;
                int size = Integer.parseInt(dateShipSplit[3]);
                if (start >= 0 && start <= 9 && end >= 0 && end <= 9 && size >= 1 && size <= 4) {
                    return new Ship(orient, start, end, size);
                }

            } else {
                System.out.println("Not correct data:");
            }
        } catch (IOException e) {
            System.out.println("Not correct data");
        }
        return null;
    }

    public String namePlayerGet() {
        try {
            String name = reader.readLine();
            return name;
        } catch (Exception e) {

        }
        return "Bad Name";
    }

    public String shotPlayer(Player player) {
        try {
            String shot = reader.readLine();
            if (shot.matches("[0-9][0]* [0-9][0]*")) {
                String shotSpek = player.shot(shot);
                switch (shotSpek) {
                    case "1":
                        Speaker.speakHit();
                        break;
                    case "2":
                        Speaker.speakMiss();
                        break;
                    case "3":
                        Speaker.speakSecondShot();
                        break;
                    default:
                }
                return shotSpek;

            } else {
                Speaker.speakNotCorrectCoordinates();
            }
        } catch (Exception e) {

        }
        return "incorrect coordinates";
    }
}
