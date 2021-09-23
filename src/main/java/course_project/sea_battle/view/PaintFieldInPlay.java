package course_project.sea_battle.view;

import course_project.sea_battle.model.ModelPlayer;

public class PaintFieldInPlay {

    String EMPTY = "  " + "\u001B[34m" + '.' + "\u001B[0m";
    String SHOT  = "  " + "\u001B[33m" + 'X' + "\u001B[0m";
    String MISS  = "  " + "\u001B[37m" + 'o' + "\u001B[0m";
    String GATHA = "  " + "\u001B[31m" + 'X' + "\u001B[0m";

    ModelPlayer player;
    ModelPlayer II;

    public PaintFieldInPlay(ModelPlayer player, ModelPlayer II) {
        this.player = player;
        this.II = II;
    }

    public void paintFields() {

        System.out.println(player.getName() + " field:                          " + II.getName() + " field: ");
        System.out.println("    A  B  C  D  E  F  G  H  I  J         A  B  C  D  E  F  G  H  I  J");
        for (int i = 0; i < 10; i++) {
            if (i == 9) System.out.print((i + 1) + "");
            else System.out.print((i + 1) + " ");
            for (int j = 0; j < 10; j++) {
                int current = player.getPlayerField().getField()[i][j];
                String paint         = EMPTY;
                if(current==5) paint = SHOT;
                if(current==3) paint = MISS;
                if(current==7) paint = GATHA;

                System.out.print(paint);
            }

            if (i == 9) System.out.print("     " + (i+1) + "");
            else System.out.print("     " + (i+1) + " ");
            for (int j = 0; j < 10; j++) {
                int current = II.getPlayerField().getField()[i][j];
                String paint         = EMPTY;
                if(current==5) paint = EMPTY;
                if(current==3) paint = MISS;
                if(current==7) paint = GATHA;

                System.out.printf(paint);
            }
            System.out.println();
        }
    }



}
