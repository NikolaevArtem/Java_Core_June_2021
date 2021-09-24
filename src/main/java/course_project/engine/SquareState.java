package course_project.engine;

import lombok.Getter;

import static course_project_1.utils.ConsoleColors.*;

@Getter
public enum SquareState {

    NONE(CYAN_BACKGROUND + " " + RESET),
    MISS(YELLOW + "º" + RESET),
    HIT(RED_BOLD + "•" + RESET);

    private String squareSymbol;

    SquareState (String squareSymbol) {
        this.squareSymbol = squareSymbol;
    }

}