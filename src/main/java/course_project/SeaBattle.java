package course_project;

import course_project.components.Coordinate;
import course_project.components.PlayingField;
import course_project.util.PlayingFieldPrinter;
import course_project.util.UserInputReader;
import course_project.util.ship_placer.ComputerShipPlacer;
import course_project.util.ship_placer.UserShipPlacer;

import java.util.Random;
import java.util.Scanner;

public class SeaBattle {

    final PlayingField playersField = new PlayingField();
    final PlayingField enemyField = new PlayingField();
    final PlayingFieldPrinter printer = new PlayingFieldPrinter();
    private final Scanner scanner = new Scanner(System.in);
    private final Random randomGenerator = new Random();
    private boolean isHit;

    public void playVsComputer() {
        placePlayersShips();
        placeComputerShips();
        makeMoves();
        closeInput();
        defineWinner();
    }

    void placePlayersShips() {
        new UserShipPlacer(scanner).placeShips(playersField);
    }

    void placeComputerShips() {
        new ComputerShipPlacer().placeShips(enemyField);
    }

    private void makeMoves()  {
        while (!playersField.getPlayersShips().isEmpty() && !enemyField.getPlayersShips().isEmpty()) {
            Coordinate shotCoordinate;
            do {
                System.out.println("Enemy field:");
                printer.printShotCells(enemyField);
                shotCoordinate = UserInputReader.getInputForShot(scanner);
                playersShot(shotCoordinate);
                delayPrint();
            } while (isHit);

            do {
                enemyShot();
                delayPrint();
                System.out.println("Your field:");
                printer.printField(playersField);
            } while (isHit);
        }
    }

    void playersShot(Coordinate point) {
        isHit = enemyField.placeShot(point);
    }

    private void delayPrint() {
        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void enemyShot() {
        Coordinate cell = createCellToShoot();
        System.out.println("Computer shoot at : " + cell);
        isHit = playersField.placeShot(cell);
    }

    private Coordinate createCellToShoot() {
        Coordinate cellToShoot;
        do {
            int x = randomGenerator.nextInt(10);
            int y = randomGenerator.nextInt(10);
            cellToShoot = new Coordinate(x, y);
        } while (playersField.isCellShot(cellToShoot));

        return cellToShoot;
    }

    private void closeInput() {
        scanner.close();
    }

    private void defineWinner() {
        if (enemyField.getPlayersShips().isEmpty()) {
            System.out.println("Player won!");
        } else {
            System.out.println("Computer won!");
        }
    }
}
