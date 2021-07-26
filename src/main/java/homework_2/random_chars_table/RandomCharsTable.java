package homework_2.random_chars_table;

import java.util.Scanner;

public class RandomCharsTable {

    public void run(){
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        String[] str = input.split(" ");

            try{
                int n = Integer.parseInt(str[0]);
                int m = Integer.parseInt(str[1]);
                String strategy = str[2];
                if(str.length == 3 && n > 0 && m > 0 && (strategy.equals("odd") || strategy.equals("even"))) {
                    char[][] table = printTable(n, m);
                    printResult(table, strategy);
                }
                else
                    System.out.println("Passed parameters should match the format [positive integer] [positive integer] [even|odd]");

            }catch (NumberFormatException | ArrayIndexOutOfBoundsException e){
                System.out.println("Passed parameters should match the format [positive integer] [positive integer] [even|odd]");
            }
    }

    public static char[][] printTable(int n, int m){
        char[][] charsTable = new char[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++){
                int number = (int)(Math.random() * 26) + 65;
                charsTable[i][j] = (char) number;
                System.out.print("|" + charsTable[i][j] + "|");
            }
            System.out.println();
        }
        return charsTable;
    }

    public static void printResult(char[][] table, String strategy){
        int n = table.length;
        int m = table[0].length;
        if(strategy.equals("odd")){
            System.out.print("Odd letters - ");
            for(int i = 0; i < n; i++)
                for(int j = 0; j < m; j++){
                    if((int) table[i][j] % 2 == 0)
                        System.out.print(table[i][j] + ", ");

                }

        }else{
            System.out.print("Even letters - ");
            for(int i = 0; i < n; i++)
                for(int j = 0; j < m; j++){
                    if((int) table[i][j] % 2 != 0)
                        System.out.print(table[i][j] + ", ");

                }
        }
    }
}
