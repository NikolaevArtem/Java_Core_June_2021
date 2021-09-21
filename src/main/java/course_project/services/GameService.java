package course_project.services;

import course_project.enums.Response;
import course_project.objects.GameData;
import course_project.objects.Move;

import java.util.ArrayList;
import java.util.List;

public class GameService {

    private final String WELCOME_MESSAGE = "Welcome to Sea Battle! You are playing with the computer now!";
    private final String USER_WIN_MESSAGE = "You won! Congratulations!!!";
    private final String COMPUTER_WIN_MESSAGE = "Computer won!";

    public void run() {
        UserService userService = new UserService();
        System.out.println(WELCOME_MESSAGE);
        GameData data = new GameData(new ShipLocationGenerator());
        processMoves(userService, data);
    }

    private void processMoves(UserService userService, GameData data) {
        List<Move> lastHit = new ArrayList<>();
        boolean isUsersTurn = true;
        while (!isGameFinished(data)) {
            if (isUsersTurn) {
                processUserMoves(userService, data);
                isUsersTurn = false;
            } else {
                processComputerMoves(userService, data, lastHit);
                isUsersTurn = true;
            }
        }
        finishGame(data, userService);
    }

    private void processUserMoves(UserService userService, GameData gameData) {
        Response response;
        do {
            response = gameData.getResponseFromComputer(userService.getMove());
            userService.printComputerResponse(response);
            if (response == Response.KILLED) {
                if (isGameFinished(gameData)) return;
            }
        } while (response == Response.HIT || response == Response.KILLED || response == Response.VISITED);
    }

    private void processComputerMoves(UserService userService, GameData data, List<Move> lastHit) {
        Response response;
        do {
            Move nextMove = MoveGenerator.generate(data.getUserField(), lastHit);
            response = userService.completeComputerMove(nextMove);
            if (response == Response.HIT || response == Response.KILLED) {
                lastHit.add(nextMove);
            }
            data.saveComputerMoveResult(response, nextMove, lastHit);
            if (response == Response.KILLED) {
                lastHit.clear();
                if (isGameFinished(data)) return;
            }
        } while (response == Response.HIT || response == Response.KILLED);
    }

    private boolean isGameFinished(GameData data) {
        return data.isComputerFleetEmpty() || data.isUserFleetEmpty();
    }

    private void finishGame(GameData data, UserService userService) {
        if (data.isUserFleetEmpty()) {
            System.out.println(COMPUTER_WIN_MESSAGE);
            data.getComputerField().printField();
        }
        if (data.isComputerFleetEmpty()) {
            System.out.println(USER_WIN_MESSAGE);
        }
        userService.closeBuffer();
    }

}
