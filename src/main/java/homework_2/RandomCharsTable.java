package homework_2;

import java.util.*;
import java.util.regex.PatternSyntaxException;
import java.util.stream.Collectors;

/**
 * Создать приложение "RandomCharsTable"
 *
 * Считывает один раз, в одну строчку 2 числа и строку - длину и ширину таблицы/двумерного массива, и стратегию
 * (even или odd)
 *
 * Печатает таблицу, заполненную случайно сгенерированными буквами от A до Z.
 *
 * Печатает в одну строку, через запятую, все четные или нечетные буквы в таблице в зависимости от выбранной
 * стратегии (A = 65, B = 66 и т.д.)
 *
 * AC:
 *
 * input - 2 2 even, output -
 *     | A | E |
 *     | G | D |
 *     Even letters - G, D
 *
 * input - 2 3 odd, output -
 *     | L | P | X |
 *     | S | N | Q |
 *     Odd letters - S, Q
 *
 * Любая ошибка с некорректным вводом/0 на месте длины_ширины/числом параметров:
 * output - Passed parameters should match the format [positive integer] [positive integer] [even|odd]
 */

public class RandomCharsTable {
    private static int rows = 0;
    private static int columns = 0;
    private static String strategy = null;

    public static void generateTable(){
        parseInput();
        char[][] charsTable = new char[rows][columns];
        List<Character> letters = new ArrayList<>();
        Random r = new Random();

        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                //[65-90]
                int rand = r.nextInt(26) + 'A';
                charsTable[i][j] = (char) rand;

                if (strategy.equals("even") && rand%2 == 0){
                    letters.add((char) rand);
                } else if(strategy.equals("odd") && rand%2 != 0) {
                    letters.add((char) rand);
                }
            }
        }

        for(int i=0; i< rows; i++){
            System.out.print("| ");
            for(int j=0; j<columns; j++){
                System.out.print(charsTable[i][j] + " | ");
            }
            System.out.println();
        }
        String capitalizeStrategy = strategy.substring(0,1).toUpperCase() + strategy.substring(1).toLowerCase();
        System.out.print(capitalizeStrategy + " letters - ");
        String result = letters.stream()
                .map(n -> String.valueOf(n))
                .collect(Collectors.joining(", "));

        System.out.println(result);
    }

    private static void parseInput(){
        Scanner scan = new Scanner(System.in);
        boolean validInput = false;
        String[] inputParams = null;
        String errorMsg = "Passed parameters should match the format [positive integer] [positive integer] [even|odd]";

        while (validInput == false){
            if(scan.hasNextLine()) {
                String inputStr = scan.nextLine();

                try {
                    inputParams = inputStr.split(" ");
                } catch (PatternSyntaxException exc) {
                    System.out.println(errorMsg);
                }

                rows = Integer.parseInt(inputParams[0]);
                columns = Integer.parseInt(inputParams[1]);
                strategy = inputParams[2];

                if (strategy.equals("even") || strategy.equals("odd")){
                    validInput = true;
                } else {
                    System.out.println(errorMsg);
                }

            } else {
                System.out.println(errorMsg);
            }
        }
    }
}
