package homework_5.PowerOfNumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputValidator {

    PowerOfNumber powerOfNumber;

    public void run(PowerOfNumber powerOfNumber) {
        System.out.println("Enter the base and exponent. [a b]");
        this.powerOfNumber = powerOfNumber;
        input();
    }

    private void validate(String[] parameters) {

        if (parameters.length > 2) {
            errorMsg();
        }

        try {
            int a = Integer.parseInt(parameters[0]);
            int b = Integer.parseInt(parameters[1]);
            if (a >= 0 && b>= 0){
                powerOfNumber.input(a, b);
            }
            else {
                errorMsg();
            }

        }
        catch (NumberFormatException | ArrayIndexOutOfBoundsException e){
            errorMsg();
        }

    }

    private void input() {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] parameters = bufferedReader.readLine().split(" ");
            validate(parameters);
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (NullPointerException e) {
            errorMsg();
        }
    }

    private void errorMsg(){
        System.out.println("Only 2 non-negative integers are allowed.");
    }
}
