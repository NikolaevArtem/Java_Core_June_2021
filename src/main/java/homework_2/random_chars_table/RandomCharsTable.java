package homework_2.random_chars_table;

import homework_2.WrongInputException;

import java.io.IOException;

public class RandomCharsTable {

    public void run() {
        try {
            InputReader inputReader = new InputReader();
            Table table = inputReader.readTableParams();

            table.fillTable();
            table.printTable();

            StrategyCharacterSet strategyCharacterSet = new StrategyCharacterSet();

            strategyCharacterSet.fillCharacterSet(table);
            strategyCharacterSet.printCharacterSet(table.getStrategy());

        } catch (WrongInputException | IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
