package homework_2.random_chars_table;

import homework_2.bufferReaders.BufferReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RandomCharsTable {

    public void run() throws IOException {
        BufferReader randomBufferReader = new BufferReader ();
        String inputString = randomBufferReader.bufferReaderConsoleForRandom ();
        try {
            var x = new ParserInputData ().parserInputRandomData (inputString);
            returnAnswer (generateArrays (x.row, x.column), x.type);
        } catch (ParserError ex) {
            System.out.print (ex.getMessage ());
            return;
        }

    }

    private char[][] generateArrays(int j, int k) {
        char[][] arr = new char[j][k];
        for (int row = 0; row < j; row++) {
            for (int col = 0; col < k; col++) {
                arr[row][col] = (char) (Math.random () * 26 + 'A');
            }
        }
        return arr;
    }

    private void returnAnswer(char[][] arr, String type) {
        List<String> result = new ArrayList<> ();
        String array = "";
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {

                array += "|" + arr[row][col] + "|";

                if ((type.equals ("even") && arr[row][col] % 2 == 0) || (type.equals ("odd") && arr[row][col] % 2 != 0)) {
                    result.add (String.valueOf (arr[row][col]));
                }
            }
            array += "\n";
        }

        System.out.println (array);
        System.out.println (type + " letters - " + String.join (", ", result));
    }
}
