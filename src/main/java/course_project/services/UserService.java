package course_project.services;

import course_project.objects.Move;
import course_project.enums.Response;

import java.io.IOException;

public class UserService {

    private final String MOVE_MESSAGE = "Make your move (e. g. D4): ";
    private final String RESPONSE_MESSAGE = "\tEnter 0, you have no ship on this cell,\n" +
            "\tEnter 1, if part of your ship is on this cell,\n" +
            "\tEnter 2, if there is last/only not killed part os your ship.\n" +
            "\tEnter a response (a digit from 0 to 2):";
    private final String VISITED_ALREADY_MESSAGE = "You have checked this cell already! Try to make a move again.";
    private final String WRONG_MOVE_FORMAT_MESSAGE = "Wrong input format. Try again:";
    private final InputService inputService;

    public UserService() {
        inputService = new InputService();
    }

    public Move getMove() {
        System.out.println(MOVE_MESSAGE);
        String input = inputService.getInput();
        input = input.toUpperCase();
        while (!isValidMove(input)) {
            System.out.println(WRONG_MOVE_FORMAT_MESSAGE);
            input = inputService.getInput();
        }
        return new Move(input);
    }

    public Response completeComputerMove(Move move) {
        System.out.println("Computer's move: " + move);
        System.out.println(RESPONSE_MESSAGE);
        String input = inputService.getInput();
        while (!isValidMoveResponse(input)) {
            System.out.println(WRONG_MOVE_FORMAT_MESSAGE);
            input = inputService.getInput();
        }
        return Response.values()[Integer.parseInt(input)];
    }

    public boolean isValidMoveResponse(String input) {
        if (input != null) {
            return input.matches("[0-2]");
        }
        return false;
    }

    public boolean isValidMove(String input) {
        if (input != null) {
            return input.matches("[A-J](10|[1-9])");
        }
        return false;
    }

    public void printComputerResponse(Response response) {
        if (response == Response.VISITED) {
            System.out.println(VISITED_ALREADY_MESSAGE);
        } else {
            if (response == Response.MISSED) {
                System.out.println("Computer has no ship there. It's computer's turn to make a move.");
            } else if (response == Response.HIT) {
                System.out.println("You have hit the computer's ship. It's your turn ta make a move again!");
            } else {
                System.out.println("You have destroyed one of computer's ships entirely. It's your turn ta make a move again!");
            }
        }
    }

    public void closeBuffer() {
        try {
            inputService.closeBuffer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
