package course_project.services;

import course_project.objects.Move;
import course_project.enums.Response;

import java.io.IOException;

public class UserService {

    private final InputService inputService;

    public UserService() {
        inputService = new InputService();
    }

    public Move getMove() {
        printMoveMessage();
        String input = inputService.getInput();
        while (!isValidMove(input)) {
            System.out.println("Wrong input format. Try again:");
            input = inputService.getInput();
        }
        return new Move(input);
    }

    public Response completeComputerMove(Move move) {
        printMove(move);
        printResponseMessage();
        String input = inputService.getInput();
        while (!isValidMoveResponse(input)) {
            System.out.println("Wrong input format. Try again:");
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
            printVisitedAlreadyMessage();
        } else {
            System.out.println(response);
        }
    }

    public void printMove(Move move) {
        System.out.println("Computer move: " + move);
    }

    public void printWelcomeMessage() {
        System.out.println("Welcome to Sea Battle! You do the first move!");
    }

    public void printMoveMessage() {
        System.out.println("Make your move (e. g. D4): ");
    }

    public void printResponseMessage() {
        System.out.println("0 - missed, 1 - hit, 2 - killed.\nEnter a response:");
    }

    public void printVisitedAlreadyMessage() {
        System.out.println("You have checked this cell already! Try to make a move again.");
    }

    public void printUserWinMessageAndExit() {
        System.out.println("You won! Congratulations!!!");
        try {
            inputService.closeBuffer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printComputerWinMessageAndExit() {
        System.out.println("Computer won!");
        try {
            inputService.closeBuffer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
