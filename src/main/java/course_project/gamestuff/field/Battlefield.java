package course_project.gamestuff.field;

import course_project.gamestuff.player.Player;
import course_project.gamestuff.ships.*;

import java.util.Collection;
import java.util.LinkedList;

import static course_project.services.conversation.DialogueMenu.*;
import static course_project.utils.AroundDestroyedShipMarker.*;
import static course_project.utils.RandomCellPositionGenerator.generateRandomForCell;
import static course_project.utils.RandomShipDirectionGenerator.generateRandomDirection;
import static course_project.utils.ShipOnBattlefieldPlacer.*;

/**
 * Battlefield is Field for the Player(owner) of this object.
 * It stores all ships available for adding,
 * and then for removing on destroy to find out who is winner in the game.
 */
public class Battlefield extends Field {

    private final Collection<Ship> availableShips;

    public Battlefield() {
        super();
        this.availableShips = new LinkedList<>();
        initAvailableShips();
    }

    private void initAvailableShips() {
        availableShips.add(new ExtraLargeShip());
        availableShips.add(new LargeShip());
        availableShips.add(new LargeShip());
        availableShips.add(new MiddleShip());
        availableShips.add(new MiddleShip());
        availableShips.add(new MiddleShip());
        availableShips.add(new SmallShip());
        availableShips.add(new SmallShip());
        availableShips.add(new SmallShip());
        availableShips.add(new SmallShip());
    }

    public Collection<Ship> getAvailableShips() {
        return this.availableShips;
    }

    public boolean addShipOnBattlefield(Ship ship, Cell toCell, boolean isHorizontal) {
        if (isEnoughSpaceToPlaceShip(toCell, ship.getSize(), isHorizontal)) {
            return isHorizontal ?
                    addRowOfCells(this, toCell, ship) :
                    addColumnOfCells(this, toCell, ship);
        }
        return false;
    }

    // onDestroy
    public void availableShipsDecrease(Ship ship) {
        this.availableShips.remove(ship);
    }

    public boolean hasAvailableShips() {
        return countOfAvailableShips() > 0;
    }

    public int countOfAvailableShips() {
        return this.availableShips.size();
    }

    public static void addShipsManually(Player currentPlayer) {
        printPlayerShipPlacingHelp();
        currentPlayer.getField().getAvailableShips().forEach(ship -> {
                    currentPlayer.getField().printField();
                    Cell toPos;
                    boolean isHorizontal = true;
                    do {
                        printSetPositionMessage(ship.getName(), ship.getSize());
                        String[] pos = getShipPlacingInput().split(" ");
                        int x = Integer.parseInt(pos[0].substring(1)) - 1;
                        int y = Integer.parseInt(String.valueOf(pos[0].charAt(0) - LOWERCASE_A));
                        toPos = currentPlayer.getField().getCellByPosition(x, y);
                        if (pos.length == 2) {
                            isHorizontal = "h".equals(pos[1]);
                        }
                    } while (!currentPlayer.getField().addShipOnBattlefield(ship, toPos, isHorizontal));
                }
        );
    }

    public static void addShipsAuto(Player currentPlayer) {
        currentPlayer.getField().getAvailableShips().forEach(ship -> {
                    Cell toPos;
                    boolean isHorizontal;
                    do {
                        toPos = currentPlayer.getField().getCellByPosition(generateRandomForCell(),
                                generateRandomForCell());
                        isHorizontal = generateRandomDirection();
                    } while (!currentPlayer.getField().addShipOnBattlefield(ship, toPos, isHorizontal));
                }
        );
    }

    public void setAroundShipCellsAsHit(Player currentPlayer, Ship ship) {
        if (ship.getSize() == 1) {
            fillAroundSmallShip(currentPlayer, ship);
        } else {
            if (ship.isHorizontal()) {
                fillAroundHorizontalShip(currentPlayer, ship);
            } else {
                fillAroundVerticalShip(currentPlayer, ship);
            }
        }
    }

}
