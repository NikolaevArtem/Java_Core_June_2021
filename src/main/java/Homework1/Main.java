package Homework1;

import java.util.Scanner;

public class Main {
    public final String RED = "\u001b[31m";


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.next();

        while (!word.equals("ошибка")){

            System.out.println(word + ": " + word.length()/2);

            break;
        }
        if (word.equals("ошибка")){
            System.out.println("\u001b[31m" + " ТРЕВОГА");
        }


    }
}
