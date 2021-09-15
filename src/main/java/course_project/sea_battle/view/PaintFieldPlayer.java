package course_project.sea_battle.view;

import course_project.sea_battle.model.ModelPlayer;

public class PaintFieldPlayer {

        ModelPlayer player;

        public PaintFieldPlayer(ModelPlayer player) {
            this.player = player;
        }

        public void paintField() {

            System.out.println(player.getName() + " field: ");
            System.out.println("    A   B   C  D   E  F   G   H  I   J");
            for (int i = 0; i < 10; i++) {
                if (i == 9) System.out.print((i + 1) + "");
                else System.out.print((i + 1) + " ");
                for (int j = 0; j < 10; j++) {
                    int current = player.getPlayerField().getField()[i][j];
                    String paint         = "  " + "\u001B[34m" + '\u26C6' + "\u001B[0m";
                    if(current==5) paint = "  " + "\u001B[33m" + '\u26F4' + "\u001B[0m";
                    if(current==3) paint = "  " + "\u001B[37m" + '\u2716' + "\u001B[0m";
                    if(current==7) paint = "  " + "\u001B[31m" + '\u26F4' + "\u001B[0m";

                    System.out.printf(paint);

                }
                System.out.println();
            }
        }


}
