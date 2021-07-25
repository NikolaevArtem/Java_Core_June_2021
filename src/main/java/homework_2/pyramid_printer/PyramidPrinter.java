package homework_2.pyramid_printer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PyramidPrinter {

    private int num;

    public void run() {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            num = Integer.parseInt(reader.readLine());

            if (num < 0){
                throw new NumberFormatException();
            }

            for (int i = 0; i <= num; i++){
                for (int j = 0; j < i; j++){
                    System.out.print(num);
                }

                System.out.println();
            }
        } catch (NumberFormatException e){
            System.out.println("Only 1 non-negative integer is allowed as passed parameter");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}