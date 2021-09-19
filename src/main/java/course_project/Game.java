package course_project;

import base.BaseClazz;
import course_project.services.FieldPrinter;
import course_project.services.PlayerController;
import course_project.ship.abstracts.SinglePartShip;
import course_project.ship.models.Player;
import course_project.ship.abstracts.TypeShip;

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;

import static course_project.services.GameService.*;

public class Game extends BaseClazz {

    private final Player player = new Player("player");
    private final Player computer = new Player("computer");

    public static Scanner scanner = new Scanner(System.in);

    private static final Function<Player, Stream<SinglePartShip>> convert =
            elem -> elem
                    .getShips()
                    .values()
                    .stream()
                    .flatMap(e -> e
                            .stream()
                            .flatMap(l -> l.getList().stream()));

    @Override
    public void run() {
        initPlayer(computer);
        initPlayer(player);
        startGame();
    }

    private void startGame() {
        Player aim = computer;
        Player attacker = player;
        while (!(player.isEmptyShips() || computer.isEmptyShips())) {
            FieldPrinter.printFiled(convert.apply(attacker), attacker.getHitsMap());
            if (playersHit(aim, attacker)) {
                System.out.println("Вражеский корабль подбит");
            } else {
                aim = (aim == computer ? player : computer);
                attacker = (attacker == computer ? player : computer);
                clearConsole();
                System.out.println("Промах. В следующий раз повезет");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Победил " + attacker.getName());
    }

    private void initPlayer(Player gamer) {

        FieldPrinter.printFieldForInit(convert.apply(gamer));
        PlayerController.initShipLists(gamer, TypeShip.SINGLE_DECK, 4);
        FieldPrinter.printFieldForInit(convert.apply(gamer));
        PlayerController.initShipLists(gamer, TypeShip.DOUBLE_DECK, 3);
        FieldPrinter.printFieldForInit(convert.apply(gamer));
        PlayerController.initShipLists(gamer, TypeShip.THREE_DECK, 2);
        FieldPrinter.printFieldForInit(convert.apply(gamer));
        PlayerController.initShipLists(gamer, TypeShip.FOUR_DECK, 1);
    }

    private void initPlayer1(Player gamer) {
        PlayerController.addToList(gamer, TypeShip.SINGLE_DECK, "A10", "V", 1);
        PlayerController.addToList(gamer, TypeShip.SINGLE_DECK, "D9", "V", 1);
        PlayerController.addToList(gamer, TypeShip.SINGLE_DECK, "F9", "V", 1);
        PlayerController.addToList(gamer, TypeShip.SINGLE_DECK, "G6", "V", 1);
        PlayerController.addToList(gamer, TypeShip.DOUBLE_DECK, "A1", "H", 2);
        PlayerController.addToList(gamer, TypeShip.DOUBLE_DECK, "J3", "V", 2);
        PlayerController.addToList(gamer, TypeShip.DOUBLE_DECK, "I9", "V", 2);
        PlayerController.addToList(gamer, TypeShip.THREE_DECK, "D1", "V", 3);
        PlayerController.addToList(gamer, TypeShip.THREE_DECK, "B5", "V", 3);
        PlayerController.addToList(gamer, TypeShip.FOUR_DECK, "G1", "H", 4);
    }

    private void clearConsole() {
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

}