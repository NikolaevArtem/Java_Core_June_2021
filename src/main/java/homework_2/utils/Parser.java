package homework_2.utils;

import java.util.Scanner;

public class Parser implements Parsable {

    @Override
    public void parse(Data data) {
        Scanner sc = new Scanner(data.getInValue()).useDelimiter("\n");

        if (sc.hasNextInt()) {
            data.setType(Type.INTEGER);
            if (sc.nextInt() < 0) {
                data.setType(Type.NEGATIVE_INTEGER);
            }
        } else {
            data.setType(Type.STRING);
        }
    }
}
