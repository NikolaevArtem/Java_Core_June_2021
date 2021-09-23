package course_project.battleship.player;

import course_project.battleship.model.Field;
import course_project.battleship.model.Ship;
import course_project.battleship.utils.Coordinate;
import course_project.battleship.utils.Position;


public class Human extends Player {
    public Human(String name) {
        super(name);
    }

    public boolean makeTurn(Player enemy, Coordinate coordinate) {
        if (enemy.getBattlefield().getField()[coordinate.getX()][coordinate.getY()]
                .getState() == Position.State.HIT ||
                this.getMonitorField().getField()[coordinate.getX()][coordinate.getY()]
                        .getState() == Position.State.MISS) {
            System.out.println("\nYou have already hit this place!");
            return true;
        }
        if (enemy.getBattlefield().getField()[coordinate.getX()][coordinate.getY()]
                .getState() == Position.State.SHIP) {

            System.out.println("Hit!");

            this.getMonitorField().getField()[coordinate.getX()][coordinate.getY()].setState(Position.State.HIT);
            enemy.getBattlefield().getField()[coordinate.getX()][coordinate.getY()].setState(Position.State.HIT);

            Ship ship = enemy.getBattlefield().getField()[coordinate.getX()][coordinate.getY()].getShip();

            if (!ship.getDamage()) {
                System.out.println("\nThe " + ship.getDeck() + "-deck ship was destroyed!");
            }

            fillAroundHitPlace(coordinate, enemy.getBattlefield(), this.getMonitorField());
        } else {
            this.getMonitorField().getField()[coordinate.getX()][coordinate.getY()]
                    .setState(Position.State.MISS);
            return false;
        }
        return true;
    }

    @Override
    public void placeShip(Coordinate coordinate, Ship ship, int direction) {
        for (int i = 0; i < ship.getDeck(); i++) {
            if (direction == 1) {
                getBattlefield().getField()[coordinate.getX()]
                        [coordinate.getY() + i].addShip(ship);
            } else {
                getBattlefield().getField()[coordinate.getX() + i][coordinate.getY()].addShip(ship);
            }
        }
    }

    public void fillAroundHitPlace(Coordinate coordinate, Field battlefield, Field monitorField) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int xi = Math.min(Math.max((coordinate.getX() + (j - 1)), 0), monitorField.getField().length - 1);
                int yi = Math.min(Math.max((coordinate.getY() + (i - 1)), 0), monitorField.getField()[i].length - 1);
                if (monitorField.getField()[xi][yi].getState() == Position.State.EMPTY &&
                        battlefield.getField()[xi][yi].getState() == Position.State.EMPTY) {
                    monitorField.getField()[xi][yi].setState(Position.State.POINT);
                }
            }
        }
    }
}
