package homework_2.utils;

import java.util.Scanner;

public abstract class AppWithOneIntInput extends App{

    protected int data;

    @Override
    protected void parseData() {
        final String ERR_NON_VALID_DATA_MSG = "Only 1 non-negative integer is allowed as passed parameter";
        Scanner sc = new Scanner(inputStr).useDelimiter("\n");
        if (sc.hasNextInt()) {
            data = sc.nextInt();
            if (data < 0) {
                error = ERR_NON_VALID_DATA_MSG;
            }
        } else {
            error = ERR_NON_VALID_DATA_MSG;
        }
    }
}
