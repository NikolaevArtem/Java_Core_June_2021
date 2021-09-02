package course_project.sea_battle.conroller;

import course_project.sea_battle.model.Field;
import course_project.sea_battle.model.Player;
import course_project.sea_battle.model.Ship;
import course_project.sea_battle.view.PaintFieldPlayer;

import java.io.IOException;

public class SeaBattle {

    public void run() {
       Player player = new Player("Rico", new Field(10,10));
       player.addShip(new Ship(true, new int[]{2,2}, 4));
       player.addShip(new Ship(true, new int[]{4,6}, 3));
       player.addShip(new Ship(false, new int[]{0,0}, 3));
       player.addShip(new Ship(false, new int[]{7,7}, 2));
       PaintFieldPlayer paintPlayerField = new PaintFieldPlayer(player);
       //Thread paintTread = new Thread();
       paintPlayerField.paintField();
    }
}
