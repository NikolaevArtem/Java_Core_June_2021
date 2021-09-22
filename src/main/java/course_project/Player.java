package course_project;

public class Player {

    private GameField field;
    private int numHitCells;

    public Player() {
        this.field = new GameField(true);
        this.numHitCells = 0;
    }

    public GameField getField() {
        return field;
    }

    public int getNumHitCells() {
        return numHitCells;
    }

    public void increaseNumHitCells() {
        numHitCells++;
    }

    public void printField(Player comp) {
        System.out.println("   Your field:                 Field of opponent: ");
        StringBuilder letters = new StringBuilder("A B C D E F G H I J");
        System.out.print("   ");
        printWithUnderline(letters);
        System.out.print("         ");
        printWithUnderline(letters);
        System.out.println("");

        for (int i = 1; i < 11; i++) {
            StringBuilder s = new StringBuilder();
            if (i != 10) s.append(" ");
            s.append(i);

            s.append("|");
            if (i == 10) {
                System.out.print(s);
                s = s.delete(0,s.length());
            }
            for (int j = 1; j < 11; j++) {
                s.append(humanSymbolToPrint(field.cells[j][i]));

                if (j != 10) s.append(" ");
            }
            if (i == 10) {
                printWithUnderline(s);
                s = s.delete(0,s.length());
            }

            s.append("|     ");
            if (i != 10) s.append(" ");
            s.append(i);
            s.append("|");
            if (i == 10) {
                System.out.print(s);
                s = s.delete(0,s.length());
            }

            for (int j = 1; j < 11; j++) {
                s.append(compSymbolToPrint(comp.field.cells[j][i]));

                if (j != 10) s.append(" ");
            }
            if (i == 10) {
                printWithUnderline(s);
                System.out.println("|");
            } else {
                System.out.println(s + "|");
            }

        }
    }

    private String humanSymbolToPrint(GameField.CellStatus cellStatus) {
        String s;
        if (cellStatus == GameField.CellStatus.FAULT)
            s = "-";
        else if (cellStatus == GameField.CellStatus.HIT)
            s = "X";
        else if (cellStatus == GameField.CellStatus.SHIP)
            s = "#";
        else s = " ";

        return s;
    }

    private String compSymbolToPrint(GameField.CellStatus cellStatus) {
        String s;
        if (cellStatus == GameField.CellStatus.FAULT)
            s = "-";
        else if (cellStatus == GameField.CellStatus.HIT)
            s = "X";
        else s = " ";

        return s;
    }

    private void printWithUnderline(StringBuilder s) {
        System.out.print("\033[0;4m" + s + "\033[0;0m");
    }

}
