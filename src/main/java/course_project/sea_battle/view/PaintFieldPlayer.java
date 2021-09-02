package course_project.sea_battle.view;

import course_project.sea_battle.model.Player;

public class PaintFieldPlayer {

        Player player;

        public PaintFieldPlayer(Player player) {
            this.player = player;
        }
    //9972 ships 9967 shot (char) 9949
        public void paintField() {
            System.out.println(player.getName() + " field: ");
            System.out.println("    A   B   C  D   E  F   J   H  I   G");
            for (int i = 0; i < 10; i++) {
                if (i == 9) System.out.print((i + 1) + " ");
                else System.out.print((i + 1) + "  ");
                for (int j = 0; j < 10; j++) {
                    int current = player.getPlayerFild().getField()[i][j];
                    char paint = (char) 9949;
                    if(current==5) paint = (char) 9972;
                    System.out.print(" " + paint + " ");
                }
                System.out.println();
            }
        }


}
