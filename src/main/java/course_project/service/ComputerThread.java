package course_project.service;

import course_project.SeaBattle;
import course_project.models.Cell;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Exchanger;

public class ComputerThread implements Runnable {
    private final Exchanger<String> exchanger;
    private String message = "";
    private final List<Cell> usedCells = new ArrayList<>();
    private final Random random = new Random();

    public ComputerThread(Exchanger<String> ex) {
        this.exchanger = ex;
    }

    public void run() {

        boolean computerTurn = false;

        while (true) {
            if (computerTurn) {
                while (true) {

                    if (usedCells.size() == 100) {
                        try {
                            message = exchanger.exchange("finished");
                        } catch (InterruptedException ex) {
                            System.out.println(ex.getMessage());
                            break;
                        }
                        break;
                    }

                    Cell cell = new Cell();
                    cell.setDigit(random.nextInt(SeaBattle.FIELD_SIZE));
                    cell.setLetter((char) (random.nextInt(SeaBattle.FIELD_SIZE) + 'a'));
                    if (!usedCells.contains(cell)) {
                        message = String.valueOf(cell.getDigit()) + String.valueOf(cell.getLetter());
                        usedCells.add(cell);
                        try {
                            message = exchanger.exchange(message);
                        } catch (InterruptedException ex) {
                            System.out.println(ex.getMessage());
                            break;
                        }
                        computerTurn = false;
                        break;
                    }
                }
            }

            try {
                message = exchanger.exchange(message);
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
                break;
            }

            if ("computerTurn".equals(message)) {
                computerTurn = true;
            }

            if ("finished".equals(message)) {
                break;
            }
        }
    }





}
