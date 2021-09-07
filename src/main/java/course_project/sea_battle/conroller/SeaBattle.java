package course_project.sea_battle.conroller;

import course_project.sea_battle.model.Field;
import course_project.sea_battle.model.Player;
import course_project.sea_battle.model.Ship;
import course_project.sea_battle.view.PaintFieldPlayer;
import course_project.sea_battle.view.Speaker;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SeaBattle {

    public void run() {
      try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
          Dialog dialog = new Dialog(reader);
          Speaker.speakYouName();
          Player player = new Player("TTTTTTT", new Field(10, 10));
          PaintFieldPlayer paintPlayerField = new PaintFieldPlayer(player);
          while (!player.readyToGame()){
          player.addShip(dialog.reader());
          paintPlayerField.paintField();
          }
         // player.addShip(new Ship(true, 3, 4, 4));
        //  player.addShip(new Ship(false, 1, 6, 2));
       //   player.addShip(new Ship(true, 6, 8, 1));
          paintPlayerField.paintField();
//     while (true){
//         System.out.println(dialog.shotPlayer(player));
//         paintPlayerField.paintField();
//     }

      } catch (Exception ignored){

      }





    }
}
