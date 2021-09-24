package course_project.ships;

import lombok.Getter;

@Getter
public enum ShipSize {
    SUBMARINE(3),
    DESTROYER(2),
    CRUISER(4),
    BATTLESHIP(5),
    CARRIER1(3),
    CARRIER2(3);

    private int size;

    ShipSize(int size){
        this.size = size;
    }
}