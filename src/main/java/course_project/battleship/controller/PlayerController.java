package course_project.battleship.controller;

import course_project.battleship.player.Player;

public interface PlayerController {

    void placeShips(Player player);

    void makeTurns(Player player1, Player player2);
}
