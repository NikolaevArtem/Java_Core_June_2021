package homework_2.pyramid_printer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputValidator {

    private void errorMsg() {
        System.out.println("Only 1 non-negative integer is allowed as passed parameter.");
    }

    public int input() {
        int height = 0;

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            height = Integer.parseInt(bufferedReader.readLine());
            if (height < 0) {
                throw new IllegalArgumentException();
            }
        } catch (IOException e) {
            System.out.println("Something went wrong.");
        } catch (IllegalArgumentException e) {
            errorMsg();
        }
        return height;
    }
}
