package course_project.seaBattle;


import java.util.Arrays;

import static course_project.seaBattle.Field.*;

public class Computer {
    private String name;

    public String getName() {
        return name;
    }

    public Computer(String name) {
        this.name = name;
        for (int i = 0; i < computer_field.length; i++) {
            Arrays.fill(computer_field[i], '*');
            Arrays.fill(fake_field[i], '*');
        }
    }
}