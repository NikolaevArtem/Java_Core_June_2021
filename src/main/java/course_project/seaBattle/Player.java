package course_project.seaBattle;


import java.util.Arrays;

import static course_project.seaBattle.Field.*;

public class Player {
    private String name;
    public String getName() {
        return name;
    }

    public Player(String name) {
        this.name = name;
        for (int i = 0; i < player_field.length; i++) {
            Arrays.fill(player_field[i], '*');
        }
    }
}