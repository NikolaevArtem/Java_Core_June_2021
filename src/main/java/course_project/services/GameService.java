package course_project.services;

import course_project.enums.Response;
import course_project.objects.GameData;
import course_project.objects.Move;

import java.util.ArrayList;
import java.util.List;

public class GameService {

    public void run() {
        UserService userService = new UserService();
        userService.printWelcomeMessage();
        GameData data = new GameData(new ShipLocationGenerator());
        processMoves(userService, data);
    }

    private void processMoves(UserService userService, GameData data) {
        boolean gotWinner = false;
        List<Move> lastHit = new ArrayList<>();
        while (!gotWinner) {
            Response response;
            do {
                response = processUserMove(userService, data);
                userService.printComputerResponse(response);
                if (response == Response.KILLED) {
                    if (data.isComputerFleetEmpty()) {
                        userService.printUserWinMessageAndExit();
                        gotWinner = true;
                        break;
                    }
                }
            } while (response == Response.HIT || response == Response.KILLED || response == Response.VISITED);
            if (gotWinner) break;
            do {
                Move nextMove = MoveGenerator.generate(data.getUserField(), lastHit);
                response = processComputerMove(userService, nextMove);
                if (response == Response.HIT || response == Response.KILLED) {
                    lastHit.add(nextMove);
                }
                data.saveComputerMoveResult(response, nextMove, lastHit);
                if (response == Response.KILLED) {
                    lastHit.clear();
                    if (data.isUserFleetEmpty()) {
                        userService.printComputerWinMessageAndExit();
                        data.getComputerField().printField();
                        gotWinner = true;
                        break;
                    }
                }
            } while (response == Response.HIT || response == Response.KILLED);
        }
    }

    private Response processComputerMove(UserService userService, Move move) {
        return userService.completeComputerMove(move);
    }

    private Response processUserMove(UserService userService, GameData gameData) {
        return gameData.getResponseFromComputer(userService.getMove());
    }

}
