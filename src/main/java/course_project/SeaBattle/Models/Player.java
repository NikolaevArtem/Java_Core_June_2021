package course_project.SeaBattle.Models;

import java.util.List;

public class Player {
    private String name;
    private Grid grid;
    private List<Ship> shipList;
    private int remainingAliveSquares;
    private Player enemy;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ship> getShipList() {
        return shipList;
    }

    public void setShipList(List<Ship> shipList) {
        this.shipList = shipList;
    }

    public Grid getGrid() {
        return grid;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }


    public Player getEnemy() {
        return enemy;
    }

    public void setEnemy(Player enemy) {
        this.enemy = enemy;
    }

    public int getRemainingAliveSquares() {
        return remainingAliveSquares;
    }

    public void setRemainingAliveSquares(int remainingAliveSquares) {
        this.remainingAliveSquares = remainingAliveSquares;
    }

    //    public Grid getBoard() {
//        return grid;
//    }

//    public int numberOfSquaresOfShips(List<Ship> ships) {
//        int sumOfAllSquares = 0;
//        for (Ship ship : ships) {
//            sumOfAllSquares += ship.getShipType().label;
//        }
//        return sumOfAllSquares;
//    }



//    public boolean  handleShot(int x, int y) {
//        for( Ship ship : ships) {
//            for(Square square : ship.getFields()) {
//
//                if(square.getY() == y && square.getX() == x && square.getSquareStatus().equals(SquareStatus.SHIP)) {
//                    square.setSquareStatus(SquareStatus.HIT);
//                    board.getSquare(x,y).setSquareStatus(SquareStatus.HIT);
//                    System.out.println("You hit a ship!");
//                    return true;
//                } else if(square.getY() == y && square.getX() == x && square.getSquareStatus().equals(SquareStatus.HIT)){
//                    square.setSquareStatus(SquareStatus.HIT);
//                    board.getSquare(x,y).setSquareStatus(SquareStatus.HIT);
//                    System.out.println("Already Hit");
//                    return  false;
//                }
//            }
//        }
//        board.getSquare(x,y).setSquareStatus(SquareStatus.MISSED);
//        System.out.println("Miss!");
//        return  false;
//    }
}
