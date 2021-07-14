package homework.task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task_2_2 {
    // The Pyramid printer, or rather triangle printer.

   public static void main(String[] args){
       int sizeOfPyramid = getInput();

       printPyramid(sizeOfPyramid);
   }

    public static int getInput(){
        String pSize = null;
        int result = 0;

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            pSize = reader.readLine();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (pSize != null) {
                result = Integer.parseInt(pSize);
            }
        }
        catch (NumberFormatException e) {
            System.out.println("Wrong input, only integers are allowed!");
            System.exit(0);         // I don't know how to manage this place w/o System.exit, but would like to ;)
        }                                 // once again, yep
        return result;
    }

    public static void printPyramid(int i){
       int rows = i;
       for (int j = 0; j < rows; j++ ){
           System.out.println(getRow(j));
       }
    }

    public static String getRow(int i){
       StringBuilder row = new StringBuilder();
       for (int j = 0; j <= i; j++){
           row.append('x');
       }
       return row.toString();
    }
}
