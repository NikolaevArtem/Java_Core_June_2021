package homework_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class Random_Chars_Table {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(reader.readLine());
        int y = Integer.parseInt(reader.readLine());
        String word = reader.readLine();
        char[][] table = new char[x][y];
        int helper;
        ArrayList<Character> resultEven = new ArrayList<>();
        ArrayList<Character> resultOdd = new ArrayList<>();

        for(int i=0; i<x;i++){
            for (int j=0; j<y; j++){
                helper = getRandomNumber();
                table[i][j] = (char) helper;
                if(helper%2==0){
                    resultEven.add((char) helper);
                } else {
                    resultOdd.add((char) helper);
                }

            }
        }
        for(int i=0; i<x;i++){
            for (int j=0; j<y; j++){
                System.out.print("|"+table[i][j]);
            }
            System.out.print("|");
            System.out.println();
        }
        if(word.equals("even")){
            for(Character i: resultEven){
                System.out.print(i+",");
            }
        } else if(word.equals("odd")){
            for(Character i: resultOdd){
                System.out.print(((char)i)+",");
            }
        }

    }
    public static int getRandomNumber() {
        return (int) ((Math.random() * (90 - 65)) + 65);
    }
}
