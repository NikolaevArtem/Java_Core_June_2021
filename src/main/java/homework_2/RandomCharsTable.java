package homework_2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static homework_2.BufferReader.bufferReaderConsoleForRandom;

public class RandomCharsTable {
    public static void main(String[] args) throws IOException {
        String inputString = bufferReaderConsoleForRandom();
        String[] arrayWithInputData = inputString.split(" ");

        int row = Integer.parseInt(arrayWithInputData[0]);
        int column = Integer.parseInt(arrayWithInputData[1]);
        String typeOfParity = arrayWithInputData[2];

        returnAnswer(generateArrays (row, column), typeOfParity);
    }

    private static char[][] generateArrays(int j, int k){
        char[][] arr = new char[j][k];
        for (int row = 0; row < j; row ++) {
            for (int col = 0; col < k; col++) {
                arr[row][col] = (char) (Math.random () * 26 + 'A');
            }
        }
        return arr;
    }

    private static void returnAnswer(char[][] arr, String type){
        List<String > result = new ArrayList<> ();
        String array = "";
        for (int row = 0; row < arr.length; row ++) {
            for (int col = 0; col < arr[row].length; col++) {

                array += "|" + arr[row][col] + "|";

                if ((type.equals ("even") && arr[row][col] % 2 == 0) || (type.equals ("odd") && arr[row][col] % 2 != 0)) {
                        result.add(String.valueOf(arr[row][col]));
                }
            }
            array += "\n";
        }

        System.out.println(array);
        System.out.println(type + " letters - " + String.join(", ",  result));
    }
}
