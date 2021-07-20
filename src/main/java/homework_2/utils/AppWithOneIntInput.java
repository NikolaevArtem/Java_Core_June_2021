package homework_2.utils;

import java.util.Scanner;

public abstract class AppWithOneIntInput extends App{
    protected int data;
    @Override
    protected void parseData() {
        Scanner sc = new Scanner(inputStr).useDelimiter("\n");
        if (sc.hasNextInt()) {
            data = sc.nextInt();
            if (data < 0) {
                error = ERR_NEGATIVE_MSG;
            }
        } else {
            error = ERR_STRING_MSG;
        }
    }
}
