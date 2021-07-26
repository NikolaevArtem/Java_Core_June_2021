package Homework2.Random_Chars_Table;
/*
3) Создать приложение "RandomCharsTable"
Считывает один раз, в одну строчку 2 числа и строку - длину и ширину таблицы/двумерного массива,
и стратегию (even или odd)
Печатает таблицу, заполненную случайно сгенерированными буквами от A до Z.
Печатает в одну строку, через запятую, все четные или нечетные буквы в таблице в зависимости
от выбранной стратегии (A = 65, B = 66 и т.д.)
AC:

input - 2 2 even, output -
		| A | E |
		| G | D |
		Even letters - G, D

input - 2 3 odd, output -
		| L | P | X |
		| S | N | Q |
		Odd letters - S, Q
Любая ошибка с некорректным вводом/0 на месте длины_ширины/числом параметров:
output - Passed parameters should match the format [positive integer] [positive integer] [even|odd]
Доп. функционал можно сделать выбором мода при старте приложения (через args)
 */

public class RandomCharsTable {

    //получаю случайные числа
    static char getRandomChar(int min, int max) {
        min = 65;
        max = 90;
        max -= min;
        char randomCh = (char) ((int) (Math.random() * ++max) + min);
        return randomCh;
    }

    //складываю случайые числа в массив
    public static char [][] getRandomCharsTable(int length, int height){
        char [][] randomCharTable = new char[length][height];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < height; j++) {
               char ch = getRandomChar(65, 90);
               randomCharTable[i][j] = ch;
            }
        }
        return randomCharTable;
    }


}


