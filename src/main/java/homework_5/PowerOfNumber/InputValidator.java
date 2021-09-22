package homework_5.PowerOfNumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputValidator {


    private boolean validate(String[] parameters) {

        if (parameters.length > 2) {
            errorMsg();
        }
        try {
            int a = Integer.parseInt(parameters[0]);
            int b = Integer.parseInt(parameters[1]);
            if (a >= 0 && b>= 0){
                return true;
            }
            else {
                errorMsg();
            }

        }
        catch (NumberFormatException | ArrayIndexOutOfBoundsException e){
            errorMsg();
        }

        return false;

    }

    public int[] input() {
        System.out.println("Enter the base and exponent. [a b]");
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] parameters = bufferedReader.readLine().split(" ");
            if (validate(parameters)) {
                return new int [] {Integer.parseInt(parameters[0]), Integer.parseInt(parameters[1])};
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (NullPointerException e) {
            errorMsg();
        }
        return new int[0];
    }

    private void errorMsg(){
        System.out.println("Only 2 non-negative integers are allowed.");
    }
}
