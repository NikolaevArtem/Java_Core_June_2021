package course_project.sea_battle.model;

public class Field {

    int[][] field;

    public Field(int a, int b) {
        field = new int[a][b];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                field[i][j] = 0;
            }
        }
    }

    public void addShip(Ship ship){
        int[] a = ship.getPosition();
        for(int i = 0; i < ship.getSize(); i++){
            if (ship.getOrientation()) {
                field[a[0]+i][a[1]] = 5;
            } else field[a[0]][a[1]+i] = 5;
        }

    }

    public int[][] getField() {
        return field;
    }

}
