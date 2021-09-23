package SeaBattle;

import java.util.Arrays;

import static SeaBattle.StartGame.COUNT;

public interface WinnerChecker {

     static boolean isWinnerExist(char[][] board, int currentShot) {
        if(Arrays.stream(board).flatMap((item)->new String(item).chars().mapToObj(a->(char)a)).noneMatch(e -> e == '0')){
            System.out.println("Game Over, you are winner !!!");
            return true;
        }
        if(COUNT <= currentShot){
            System.out.println("Your shells are out, try again");
            return true;
        }
        return false;
    }
}
