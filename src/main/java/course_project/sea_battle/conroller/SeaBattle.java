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

            ModelPlayer player = new ModelPlayer(PlayerName, new Field(10, 10));
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
            play.paintFields();
            do {
                if (whoCanGo) {
                    Speaker.voice("queuePlayer");
                    String shot1 = dialog.shotPlayer(IIPlayer);
                    Speaker.voice("shot", shot1);

                    if ("Hit! And Kill!".equals(shot1)||"Hit!".equals(shot1)) {
                        whoCanGo = true;
                    } else {
                        whoCanGo = false;
                    }


                } else {
                    Thread.sleep(1000);
                    String shot2 = player.autoShot();
                    Speaker.voice("queueII", shot2);

                    if ("Hit! And Kill!".equals(shot2)||"Hit!".equals(shot2)) {
                        whoCanGo = false;
                    } else {
                        whoCanGo = true;
                    }
                    Thread.sleep(1000);
                }
                Thread.sleep(1000);
                play.paintFields();
            } while (!player.lose() && !IIPlayer.lose());

            if (player.lose()) {
                Speaker.voice("lose1", player.getName());
            } else Speaker.voice("lose1", IIPlayer.getName());

        } catch (Exception e) {
            System.out.println(e + " FAIL");
        }
    }
}
