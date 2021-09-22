package homework_2.random_chars_table;

public class TableCharPrinter {

    public void tableCharPrinter(int tableLength, int tableWidth, int strategyFlag) {

        LettersPrinter lettersPrinter = new LettersPrinter();

        for (int i = 0; i < tableLength; i++) {
            System.out.print("|");
            for (int j = 0; j < tableWidth; j++) {
                char currentChar = randomChar();
                lettersPrinter.strategyStringBuilder(currentChar, strategyFlag);
                System.out.print(currentChar + "|");
            }
            System.out.print("\n");
        }
        lettersPrinter.lettersPrint(strategyFlag);
    }

    private char randomChar() {
        return (char) (65 + Math.random() * 26);
    }
}
