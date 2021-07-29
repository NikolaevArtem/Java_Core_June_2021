package homework_2.random_chars_table;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputParser {

    private int strategyFlag;

    private void errorMsg(){
        System.out.println("Passed parameters should match the format [positive integer] " +
                "[positive integer] [even|odd]");
    }


    public void input() {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] subString = bufferedReader.readLine().split(" ");
            checkSetParameters(subString);
        } catch (IOException e) {
            System.out.println("Something went wrong.");
        } catch (NullPointerException | IllegalArgumentException | ArrayIndexOutOfBoundsException e) {
            errorMsg();
        }
    }

    private void checkSetParameters(String[] subString) {
        int tableLength = Integer.parseInt(subString[0]);
        int tableWidth = Integer.parseInt(subString[1]);
        String strategy = subString[2];
        if (tableLength < 1 || tableWidth < 1) {
            errorMsg();
        }
        if (subString.length > 3){
            errorMsg();
        }
        if ("even".equals(strategy)) {
            strategyFlag = 0;
        } else if ("odd".equals(strategy)) {
            strategyFlag = 1;
        } else {
            errorMsg();
        }

       new TableCharPrinter().tableCharPrinter(tableLength, tableWidth, strategyFlag);
    }

}
