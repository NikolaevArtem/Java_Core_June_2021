package homework_2.random_chars_table;


import java.util.Scanner;

public class RandomCharsTable {
    protected static final int MIN_ASCII_CODE = 65;
    protected static final int MAX_ASCII_CODE = 90;
    protected static final String ERR_MSG = "Passed parameters should match the format [positive integer] [positive integer] [even|odd]";
    int cols = 0; int rows = 0;
    String strategy = "";
    boolean exceptionWasThrown;

    public void run(){
        System.out.println("Enter the dimensions of matrix and required strategy : two integers and required strategy - even|odd, delimiter - space character))");
        readAndValidateInput();
        if (exceptionWasThrown) {
            System.out.println(ERR_MSG);
        } else {
            int [][] matrix = createCharsTable(cols, rows);
            printCharsTable(matrix, strategy);
        }

    }

    protected void readAndValidateInput (){
        try (Scanner scanner = new Scanner(System.in)) {
            int paramCount = 0;
            String tempStr = "";
            String inString = scanner.nextLine();
            if (inString.matches("\\d+\\s\\d+\\s[odevn]{3,4}")){
                for (int i = 0; i < inString.length(); i++) {
                    char c = inString.charAt(i);
                    if (c != ' ') {
                        tempStr = tempStr + c;
                    }
                    else {
                        if (paramCount == 0) {
                            cols = Integer.parseInt(tempStr);
                            paramCount++;
                            tempStr = "";
                            continue;
                        }
                        if (paramCount == 1) {
                            rows = Integer.parseInt(tempStr);
                            paramCount++;
                            tempStr = "";
                        }
                    }
                }
            }
            else {
                throw new IllegalArgumentException();
            }
            strategy = tempStr;
            if ((!strategy.equals("even") && !strategy.equals("odd")) || cols <= 0 || rows <= 0) {
                throw new IllegalArgumentException();
            }
        } catch (RuntimeException e) {
            exceptionWasThrown = true;
        }

    }

    public int[][] createCharsTable(int col, int row){
        int [][] matrix = new int[col][row];
        for (int i = 0; i < col; i++){
            for (int j = 0; j < row; j++){
                matrix [i][j] = rnd(MIN_ASCII_CODE, MAX_ASCII_CODE);
            }
        }
        return matrix;

    }

    public void printCharsTable (int[][] matrix, String strategy){
       String tempStr;
       boolean evStrat = strategy.equals("even");
       String stratHeader = (evStrat) ? "Even letters - " : "Odd letters - ";
       String stratRes = "";
       for (int i = 0; i < matrix.length; i++ ) {
           tempStr = "";
           for (int j = 0; j < matrix[0].length; j++){
               tempStr = tempStr + (char) matrix[i][j] + "|";
                if (evStrat && matrix[i][j] % 2 == 0) {
                    stratRes = (stratRes.equals("")) ? (char) matrix[i][j] + "," : stratRes + " " + (char) matrix[i][j] + ",";
                }
                if (!evStrat && matrix[i][j] % 2 == 1) {
                   stratRes = (stratRes.equals("")) ? (char) matrix[i][j] + "," : stratRes + " " + (char) matrix[i][j] + ",";
                }
           }
           System.out.println("|" + tempStr);
       }
       stratRes = (stratRes.length() > 1) ? stratRes.substring(0, stratRes.length() - 1) : stratRes;
        System.out.println(stratHeader + stratRes);

    }

    public static int rnd(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;

    }

}
