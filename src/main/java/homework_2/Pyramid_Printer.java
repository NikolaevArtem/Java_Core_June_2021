package homework_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Pyramid_Printer {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int x = 0;
        try {
            x = Integer.parseInt(reader.readLine());
            if(x<=0){
                throw new ArithmeticException();
            }
        }catch (ArithmeticException e){
            System.out.println("Число отрицательное");
            return;

        }catch (Exception e){
            System.out.println("Ошибка");
        }

        for (int i=1; i<=x;i++){
            System.out.println(getX(i));
        }


    }
    public static String getX(int score){
        StringBuilder result = new StringBuilder();

        for(int i=0;i<score; i++){
            result.append("x");
        }
        return result.toString();
    }


}
