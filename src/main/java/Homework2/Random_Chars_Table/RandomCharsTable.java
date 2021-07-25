package Homework2.Random_Chars_Table;
/*
Создать приложение "RandomCharsTable"

Считывает 2 числа и строку - длину и ширину таблицы/двумерного массива,
и стратегию (even или odd).
Печатает таблицу, заполненную случайно сгенерированными буквами от A до Z.

Печатает в одну строку, через запятую, все четные или нечетные буквы в таблице
в зависимости от выбранной стратегии (A = 65, B = 66 и т.д.)

AC:
input - 2 2 even, output -
		| A | E |
		| G | D |
		Even letters - G, D
input - 2 3 odd, output -
		| L | P | X |
		| S | N | Q |
		Odd letters - S, Q
 */

public class RandomCharsTable {

    static char randomChar   (int min, int max) {
        min = 65;
        max = 90;
        max -= min;

        char randomCh = (char) ((int) (Math.random() * ++max) + min);

        return randomCh;
    }

     char [][] getRandomCharTable (int length, int height){
        char [][] randomCharTable = new char[length][height];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < height; j++) {
               char ch = randomChar(65, 90);
               randomCharTable[i][j] = ch;
            }
        }
        return randomCharTable;
    }
    public void printRandomChartable(char getRand){

    }

}
