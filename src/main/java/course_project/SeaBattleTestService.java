package course_project;

import lombok.Data;

@Data
public class SeaBattleTestService {
    public SeaBattleTestService(Player player1, Player player2) {
        fillFields(player1, 0);
        fillFields(player2, 1);
    }

    private void fillFields(Player player, int coordinateShift) {
        Field field = player.getField();
        field.drawTestShips(getMatrix(coordinateShift));
    }

    private int[][][] getMatrix(int cs) {
        int[][][] matrix = {
                {{4, 0}, {2 + cs, 0 + cs}, {2 + cs, 3 + cs}},
                {{3, 0}, {0 + cs, 2 + cs}, {0 + cs, 4 + cs}},
                {{3, 0}, {6 + cs, 8 + cs}, {8 + cs, 8 + cs}},
                {{2, 0}, {5 + cs, 2 + cs}, {5 + cs, 3 + cs}},
                {{2, 0}, {5 + cs, 5 + cs}, {5 + cs, 6 + cs}},
                {{2, 0}, {7 + cs, 1 + cs}, {8 + cs, 1 + cs}},
                {{1, 0}, {0 + cs, 0 + cs}, {0 + cs, 0 + cs}},
                {{1, 0}, {1 + cs, 8 + cs}, {1 + cs, 8 + cs}},
                {{1, 0}, {3 + cs, 6 + cs}, {3 + cs, 6 + cs}},
                {{1, 0}, {7 + cs, 4 + cs}, {7 + cs, 4 + cs}}
        };
        return matrix;
    }

}
