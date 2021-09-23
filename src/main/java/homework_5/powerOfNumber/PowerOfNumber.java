package homework_5.powerOfNumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PowerOfNumber {
    private static final String ERROR = "Only 2 non-negative integers are allowed";

    public void run() {
        System.out.println("Please, input 2 non-negative numbers:");
        try {
            String input = bufferedReaderReadConsole();
            int[] array = validateInput(input);
            int i1 = array[0];
            int i2 = array[1];
            System.out.println(powerN(i1, i2));
        } catch (IOException | IllegalArgumentException ex) {
            System.out.println(ERROR);
        }
    }

    private String bufferedReaderReadConsole() throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String str = reader.readLine();
            if (str == null) {
                throw new IllegalArgumentException();
            }
            return str;
        }
    }

    private int[] validateInput(String s) {
        String[] array = s.trim().replaceAll("( )+", " ").split(" ");
        if (array.length != 2) {
            throw new IllegalArgumentException();
        }
        int i1 = Integer.parseInt(array[0]);
        int i2 = Integer.parseInt(array[1]);
        if (i1 < 0 || i2 < 0) {
            throw new IllegalArgumentException();
        }
        return new int[]{i1, i2};
    }

    public int powerN(int base, int n) {
        if (n < 1) return 1;
        return base * (powerN(base, n - 1));
    }
}

