package SeaBattle;

public interface InputValidator {

    static boolean isInvalidInputData(int col, int row, char[][] board) {
        if(row < 0 || row > 9) {
            System.out.println("Invalid input, allowed values like 'a5'");
            return true;
        } else if(col == -1) {
            System.out.println("Invalid input, please repeat input ");
            return true;
        } else if(board[row][col] == 'x') {
            System.out.println("Already bombed, please repeat input ");
            return true;
        } else if(board[row][col] == '0') {
            System.out.println("HIT!");
            board[row][col] = 'X';
        } else {
            board[row][col] = 'x';
        }
        return false;
    }
}
