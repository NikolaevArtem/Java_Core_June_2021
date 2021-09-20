package course_project.sea_battle.service;

import course_project.sea_battle.model.Player;
import course_project.sea_battle.model.Point;
import course_project.sea_battle.model.Ship;
import course_project.sea_battle.model.Shot;
import course_project.sea_battle.boards.Board;

import java.util.*;
import java.util.stream.Collectors;

import static course_project.sea_battle.view.BigSpace.bigSpace;
import static course_project.sea_battle.view.BoardPrinter.showBoards;

public class Engine {
    private final Scanner scanner;
    private int x;
    private int y;
    private boolean isGameOver = false;
    private Shot shot;
    private Ship currentShip;

    private static final String MAKESHOT = ", make your shot in format: [A6] or [b1]";
    private static final String INPUTERROR = "Input should be like this: [A7] or [b2]. Try again!";
    private static final String CHECKED = "Cell is checked. Make another shot!";
    private static final String KILLALL = ", you destroyed all enemy ships. Congratulations!";

    public Engine(Scanner scanner) {
        this.scanner = scanner;
    }

    public void checkAndValidatePlayerShot(Player player1, Player player2) {
        showBoards(player1);
        System.out.println(player1.getName() + MAKESHOT);

        while (!isGameOver) {
            String input = scanner.nextLine();

            if (!isValidInput(input)) continue;
            if (isShooted(player2)) continue;
            if (!checkCell(player2)) continue;

            putOnMyBoard(player1.getMyShots());
            putOnEnemyBoard(player2.getMyBoard());

            if (!isGameContinue(player1, player2, shot)) break;
        }
    }

    public boolean isGameContinue(Player me, Player enemy, Shot shot) {
        if (shot == Shot.KILLED) {
            fillCellsAroundDestroyedShip(currentShip, me, enemy);
            showBoards(me);
            if (isGameOver) {
                System.out.println(me.getName() + KILLALL);
                bigSpace();
            } else {
                System.out.println(me.getName() + MAKESHOT);
            }
        } else if (shot == Shot.HIT) {
            showBoards(me);
            System.out.println(me.getName() + MAKESHOT);
        } else if (shot == Shot.MISS) {
            showBoards(me);
            bigSpace();
            return false;
        }
        return true;
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

    public boolean isShooted(Player enemy) {
        if (enemy.getMyBoard().getBoard()[x][y] == 3 || enemy.getMyBoard().getBoard()[x][y] == 2) {
            System.out.println(CHECKED);
            return true;
        }
        return false;
    }

    public boolean checkCell(Player enemy) {

        if (enemy.getMyBoard().getBoard()[x][y] == 1) {
            findOutHitOrKilled(enemy);
        } else {
            shot = Shot.MISS;
            System.err.println("MISS");
        }
        return true;
    }

    public void findOutHitOrKilled(Player enemy) {
        for (Ship ship : enemy.getMyShips()) {
            if (ship.getCoordinates().contains(new Point(x, y))) {
                ship.setLives(ship.getLives() - 1);
                if (ship.getLives() == 0) {
                    System.err.println("KILLED!");
                    shot = Shot.KILLED;
                    System.out.println(enemy.getName() + " has " + enemy.countShips() + " ship(s) left.");
                    currentShip = ship;
                    if (enemy.countShips() == 0) {
                        isGameOver = true;
                    }
                } else {
                    shot = Shot.HIT;
                    System.err.println("HIT!");
                }
                break;
            }
        }
    }

    public void putOnMyBoard(Board board) {
        int[][] tempBoard = board.getBoard();
        if (shot == Shot.MISS) {
            tempBoard[x][y] = 2;
        } else {
            tempBoard[x][y] = 3;
        }
        board.setBoard(tempBoard);
    }

    public void putOnEnemyBoard(Board board) {
        int[][] tempBoard = board.getBoard();
        if (shot == Shot.MISS) {
            tempBoard[x][y] = 2;
        } else {
            tempBoard[x][y] = 3;
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

        int[][] myShots = me.getMyShots().getBoard();
        int[][] enemyMainBoard = enemy.getMyBoard().getBoard();

        Set<Point> filteredPointsAround = coordinatesAroundTheShip.stream()
                .distinct()
                .filter(e -> (enemyMainBoard[e.getX()][e.getY()] == 0))
                .collect(Collectors.toSet());

        for (Point point : filteredPointsAround) {
            myShots[point.getX()][point.getY()] = 2;
            enemyMainBoard[point.getX()][point.getY()] = 2;
        }

        me.getMyShots().setBoard(myShots);
        enemy.getMyBoard().setBoard(enemyMainBoard);
    }

}
