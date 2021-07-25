package Homework2.Pyramid_Printer;

public class PyramidPrinter {
    public static final char X = 'x';
    public static final char SPACE = ' ';

    public char[][] getPyramidArray(int size) {
        char pyramid[][] = new char[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i < j) {
                    pyramid[i][j] = SPACE;
                } else {
                    pyramid[i][j] = X;
                }
            }
        }
        return pyramid;
    }
}



