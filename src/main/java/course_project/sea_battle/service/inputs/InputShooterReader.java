package course_project.sea_battle.service.inputs;

import course_project.sea_battle.boards.Board;
import course_project.sea_battle.model.Player;
import course_project.sea_battle.model.Point;
import course_project.sea_battle.model.Ship;
import course_project.sea_battle.model.Shot;
import lombok.SneakyThrows;

import java.util.*;
import java.util.stream.Collectors;

import static course_project.sea_battle.view.BoardPrinter.showBoards;

public class InputShooterReader extends InputReader {
    private int x;
    private int y;
    private Shot shot;
    private Ship currentShip;
    private Random random = new Random();

    private static final String MAKESHOT = ", make your shot in format: [A6] or [b1]";
    private static final String INPUTERROR = "Input should be like this: [A7] or [b2]. Try again!";
    private static final String CHECKED = "Cell is checked. Make another shot!";
    private static final String KILLALL = ", you destroyed all enemy ships. Congratulations!";
    private static final String NEXTMOVE = "Press ENTER to finish your move";
    private static final String COMPUTERMOVE = "Computer is thinking...";

    public InputShooterReader(Scanner scanner) {
        this.scanner = scanner;
    }

    @SneakyThrows
    public void checkAndValidatePlayerShot(Player player1, Player player2) {
        if (!player1.isComputer()) {
            if (!player2.isComputer()) {
                showBoards(player1);
            }
            System.out.println(player1.getName() + MAKESHOT);
        }

        while (true) {

            if (!player1.isComputer()) {
                String input = readLine();
                if (!isValidInput(input)) continue;
            } else {
                defineShot();
            }
            if (isShooted(player1, player2)) continue;

            if (player1.isComputer()) {
                System.out.println(COMPUTERMOVE);
                Thread.sleep(2000);
            }

            getShotResult(player2);
            putOnBoard(player1.getMyShots(), new Point(x, y), shot);
            putOnBoard(player2.getMyBoard(), new Point(x, y), shot);

            if (!isGameContinue(player1, player2, shot)) break;
        }
    }

    public void defineShot() {
        x = random.nextInt(10);
        y = random.nextInt(10);
    }

    public boolean isValidInput(String input) {
        if (input.matches("[a-jA-J]([1-9]|10)")) {
            y = Character.getNumericValue(input.charAt(0)) - 10;
            x = Integer.parseInt(input.substring(1)) - 1;
            return true;
        } else {
            System.out.println(INPUTERROR);
            return false;
        }
    }

    public boolean isShooted(Player me, Player enemy) {
        if (enemy.getMyBoard().getBoard()[x][y] == 3 || enemy.getMyBoard().getBoard()[x][y] == 2) {
            if (!me.isComputer()) {
                System.out.println(CHECKED);
            }
            return true;
        }
        return false;
    }

    public void getShotResult(Player enemy) {
        if (enemy.getMyBoard().getBoard()[x][y] == 1) {
            findOutHitOrKilled(enemy);
        } else {
            shot = Shot.MISS;
        }
    }

    public void findOutHitOrKilled(Player enemy) {
        for (Ship ship : enemy.getMyShips()) {
            if (ship.getCoordinates().contains(new Point(x, y))) {
                ship.setLives(ship.getLives() - 1);
                if (ship.getLives() == 0) {
                    shot = Shot.KILLED;
                    currentShip = ship;
                } else {
                    shot = Shot.HIT;
                }
            }
        }
    }

    public static void putOnBoard(Board board, Point shotPoint, Shot shot) {
        int[][] tempBoard = board.getBoard();
        if (shot == Shot.MISS) {
            tempBoard[shotPoint.getX()][shotPoint.getY()] = 2;
        } else {
            tempBoard[shotPoint.getX()][shotPoint.getY()] = 3;
        }
        board.setBoard(tempBoard);
    }

    public void fillCellsAroundDestroyedShip(Ship ship, Player me, Player enemy) {

        List<Point> coordinatesOfTheShip = ship.getCoordinates();
        Set<Point> coordinatesAroundTheShip = new HashSet<>();
        for (Point point : coordinatesOfTheShip) {
            int x1 = point.getX();
            int y1 = point.getY();

            if (x1 > 0) {
                coordinatesAroundTheShip.add(new Point(x1 - 1, y1));
            }
            if (y1 > 0) {
                coordinatesAroundTheShip.add(new Point(x1, y1 - 1));
            }
            if (x1 < 9) {
                coordinatesAroundTheShip.add(new Point(x1 + 1, y1));
            }
            if (y1 < 9) {
                coordinatesAroundTheShip.add(new Point(x1, y1 + 1));
            }
            if (x1 > 0 && y1 > 0) {
                coordinatesAroundTheShip.add(new Point(x1 - 1, y1 - 1));
            }
            if (x1 < 9 && y1 < 9) {
                coordinatesAroundTheShip.add(new Point(x1 + 1, y1 + 1));
            }
            if (x1 > 0 && y1 < 9) {
                coordinatesAroundTheShip.add(new Point(x1 - 1, y1 + 1));
            }
            if (x1 < 9 && y1 > 0) {
                coordinatesAroundTheShip.add(new Point(x1 + 1, y1 - 1));
            }
        }

        int[][] enemyMainBoard = enemy.getMyBoard().getBoard();

        Set<Point> filteredPointsAround = coordinatesAroundTheShip.stream()
                .distinct()
                .filter(e -> (enemyMainBoard[e.getX()][e.getY()] == 0))
                .collect(Collectors.toSet());

        for (Point point : filteredPointsAround) {
            putOnBoard(me.getMyShots(), point, Shot.MISS);
            putOnBoard(enemy.getMyBoard(), point, Shot.MISS);
        }
    }

    @SneakyThrows
    public boolean isGameContinue(Player me, Player enemy, Shot shot) {
        if (shot == Shot.KILLED) {
            System.err.println("KILLED!");
            System.out.println(enemy.getName() + " has " + enemy.countShips() + " ship(s) left.");
            fillCellsAroundDestroyedShip(currentShip, me, enemy);
            Thread.sleep(500);
            if (!me.isComputer()) {
                showBoards(me);
            } else {
                showBoards(enemy);
            }
            if (enemy.countShips() == 0) {
                System.out.println(me.getName() + KILLALL);
                printBigSpace(!me.isComputer() && !enemy.isComputer());
                return false;
            } else {
                if (!me.isComputer()) {
                    System.out.println(me.getName() + MAKESHOT);
                }
            }
        } else if (shot == Shot.HIT) {
            System.err.println("HIT!");
            Thread.sleep(500);
            if (!me.isComputer()) {
                showBoards(me);
                System.out.println(me.getName() + MAKESHOT);
            } else {
                showBoards(enemy);
            }

        } else if (shot == Shot.MISS) {
            System.err.println("MISS!");
            Thread.sleep(500);
            if (!me.isComputer()) {
                showBoards(me);
            } else {
                showBoards(enemy);
            }
            printBigSpace(!me.isComputer() && !enemy.isComputer());
            return false;
        }
        return true;
    }

    public void printBigSpace(boolean hasSence) {
        if (hasSence) {
            System.out.println(NEXTMOVE);
            readLine();
            System.out.println("\n\n\n\n\n\n\n\n\n\n");
        }
    }

}
