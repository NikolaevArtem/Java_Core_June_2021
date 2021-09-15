package course_project.sea_battle.conroller;

import course_project.sea_battle.model.Field;
import course_project.sea_battle.model.ModelPlayer;
import course_project.sea_battle.view.PaintFieldInPlay;
import course_project.sea_battle.view.Speaker;

import java.util.Scanner;

public class SeaBattle extends Thread {

    public void run() {
        try (Scanner scanner = new Scanner(System.in)) {
            Dialog dialog = new Dialog(scanner);
            Speaker.voice("dialogName");
            String PlayerName = dialog.namePlayerGet();

            ModelPlayer player = new ModelPlayer("PlayerName", new Field(10, 10));
            ModelPlayer IIPlayer = new ModelPlayer("BOT2", new Field(10, 10));
            Speaker.voice("autoGenerate");
            boolean choiceGenerate = dialog.autoGenerate();

            if (choiceGenerate) {
                player.autoGenerateShips();
            } else {
                dialog.generateShips(player);
            }
            IIPlayer.autoGenerateShips();

            PaintFieldInPlay play = new PaintFieldInPlay(player, IIPlayer);
            boolean whoCanGo = true;
            do {
                play.paintFields();
                if (whoCanGo) {
                    Speaker.voice("queuePlayer");
                    String shot1 = dialog.shotPlayer(IIPlayer);

                    if ("7".equals(shot1)) {
                        whoCanGo = true;
                    } else {
                        whoCanGo = false;
                    }
                    Speaker.voice("shot", shot1);
                    Thread.sleep(1000);
                } else {
                    String shot2 = player.autoShot();
                    Speaker.voice("queueII", shot2);
                    Thread.sleep(1000);
                    if ("7".equals(shot2)) {
                        whoCanGo = false;
                    } else {
                        whoCanGo = true;
                    }
                }

            } while (!player.lose() && !IIPlayer.lose());

            if (player.lose()) {
                Speaker.voice("lose1", player.getName());
            } else Speaker.voice("lose1", IIPlayer.getName());

        } catch (Exception e) {
            System.out.println(e + " FAIL");
        }


    }
}
