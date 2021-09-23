package course_project.service;

import course_project.SeaBattle;
import course_project.models.Cell;
import course_project.models.Ship;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.concurrent.Exchanger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UserThread implements Runnable {
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final Exchanger<String> exchanger;
    private final List<Ship> ships;
    private final List<Ship> userShips;
    private final Strike strikes = new Strike();
    private final Strike userStrikes = new Strike();

    public UserThread(Exchanger<String> exchanger, List<Ship> ships, List<Ship> userShips) {
        this.exchanger = exchanger;
        this.ships = ships;
        this.userShips = userShips;
    }

    public void run() {
        String message = "";
        String strStrike = "";
        boolean finished = false;

        printUserStrikes();
        printComputerStrikes();

        while (true) {

            try {
                message = exchanger.exchange("");
                if (message.length() == 2) {
                    System.out.println("Computer move is : " + message);
                }
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
                break;
            }

            if (message.length() == 2) {
                if (message.matches(SeaBattle.CELL_REGEX)) {

                    int y = Character.getNumericValue(message.charAt(0));
                    char x = message.charAt(1);

                    if (!strikes.makeStrike(y, x, userShips)) {
                        printComputerStrikes();
                        try {
                            exchanger.exchange("computerTurn");
                        } catch (InterruptedException ex) {
                            System.out.println(ex.getMessage());
                            break;
                        }
                        continue;
                    } else {
                        printComputerStrikes();
                    }

                } else {
                    System.out.println("Out of field!");
                }
            }

            System.out.println("Enter the cell in format [int+char]: ");
            String line = null;
            try {
                line = reader.readLine();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

            if ("exit".equals(line)) {
                try {
                    exchanger.exchange("finish");
                } catch (InterruptedException ex) {
                    System.out.println(ex.getMessage());
                    break;
                }
                break;
            }

            if (line != null && line.matches(SeaBattle.CELL_REGEX)) {

                int y = Character.getNumericValue(line.charAt(0));
                char x = line.charAt(1);

                if (!userStrikes.makeStrike(y, x, ships)) {
                    printUserStrikes();
                    continue;
                } else {
                    printUserStrikes();
                }

            } else {
                System.out.println("Out of field!");
                continue;
            }

            long userRemainder = userShips.stream()
                    .flatMap(e -> e.getShipCells().stream())
                    .filter(e -> !e.isBeaten())
                    .count();

            long computerRemainder = ships.stream()
                    .flatMap(e -> e.getShipCells().stream())
                    .filter(e -> !e.isBeaten())
                    .count();

            if (computerRemainder == 0 || userRemainder == 0) {
                finished = true;
                String loser = computerRemainder == 0 ? "COMPUTER" : "USER";
                System.out.println(loser + " ships are sunk! Game over");
            }

            if (finished) {
                try {
                    exchanger.exchange("finished");
                } catch (InterruptedException ex) {
                    System.out.println(ex.getMessage());
                    break;
                }
                break;
            } else {
                try {
                    exchanger.exchange("computerTurn");
                } catch (InterruptedException ex) {
                    System.out.println(ex.getMessage());
                    break;
                }
            }
        }
    }

    void printUserStrikes() {
        System.out.println("Computer's field");

        System.out.format("%5s"," ");

        List<Character> hor = IntStream.iterate(0, i -> i + 1)
                .limit(SeaBattle.FIELD_SIZE)
                .boxed()
                .map(e -> (char) (e + 'a'))
                .collect(Collectors.toList());

        for  (Character character : hor) {
            System.out.format("%5s", character);
        }

        System.out.println();

        for (int i = 0; i < SeaBattle.FIELD_SIZE; i++) {

            System.out.format("%5s", i);

            for (int j = 0; j < SeaBattle.FIELD_SIZE; j++) {

                Cell tmpUserCell = new Cell();
                tmpUserCell.setDigit(i);
                tmpUserCell.setLetter((char) (j + 'a'));
                String mark = "-";

                if (userStrikes.getStrikes().contains(tmpUserCell)) {
                    mark = "X";
                }

                for (Ship ship : ships) {
                    for (Cell cell : ship.getShipCells()) {
                        if (cell.equals(tmpUserCell)) {
                            if (cell.isBeaten()) {
                                mark = "0";
                            }
                        }
                    }
                }

                System.out.format("%5s", mark);
            }
            System.out.println();
        }
    }

    void printComputerStrikes() {
        System.out.println("User's field");

        System.out.format("%5s"," ");

        List<Character> hor = IntStream.iterate(0, i -> i + 1)
                .limit(SeaBattle.FIELD_SIZE)
                .boxed()
                .map(e -> (char) (e + 'a'))
                .collect(Collectors.toList());

        for  (Character character : hor) {
            System.out.format("%5s", character);
        }

        System.out.println();

        for (int i = 0; i < SeaBattle.FIELD_SIZE; i++) {

            System.out.format("%5s", i);

            for (int j = 0; j < SeaBattle.FIELD_SIZE; j++) {

                Cell tmpUserCell = new Cell();
                tmpUserCell.setDigit(i);
                tmpUserCell.setLetter((char) (j + 'a'));
                String mark = "-";

                if (strikes.getStrikes().contains(tmpUserCell)) {
                    mark = "X";
                }

                for (Ship ship : userShips) {
                    for (Cell cell : ship.getShipCells()) {
                        if (cell.equals(tmpUserCell)) {
                            if (cell.isBeaten()) {
                                mark = "@";
                            } else {
                                mark = "0";
                            }
                        }
                    }
                }

                System.out.format("%5s", mark);
            }
            System.out.println();
        }
    }

}
