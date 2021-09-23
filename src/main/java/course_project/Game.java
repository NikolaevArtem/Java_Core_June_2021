package course_project;

import base.BaseClazz;
import course_project.services.FieldPrinter;
import course_project.services.GameService;
import course_project.services.PlayerController;
import course_project.ship.abstracts.SinglePartShip;
import course_project.ship.models.Player;
import course_project.ship.abstracts.ShipType;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;

import static course_project.services.GameService.*;

public class Game extends BaseClazz {

    private static String MISS = "Промах. В следующий раз повезет";

    private final Player player = new Player("player1");
    private final Player computer = new Player("player2");

    public static Scanner scanner = new Scanner(System.in);

    private static final Function<Player, Stream<SinglePartShip>> convert =
            elem -> elem
                    .getMapShips()
                    .values()
                    .stream()
                    .flatMap(e -> e
                            .stream()
                            .flatMap(l -> l.getList().stream()));

    @Override
    public void run() {
        player.getMapShips().putAll(GameService.getNewPlayerWithRandomShips(player.getName()).getMapShips());
        computer.getMapShips().putAll(GameService.getNewPlayerWithRandomShips(computer.getName()).getMapShips());
        startGame();
    }

    private void startGame() {
        Player aim = computer;
        Player attacker = player;
        while (!(player.isEmptyHealthShips() || computer.isEmptyHealthShips())) {
            FieldPrinter.printFiled(convert.apply(attacker), attacker.getHitsMap(), attacker.getDamageList().stream());
            String result = playersHit(aim, attacker);
            if (!result.equals(MISS)) {
                System.out.println(result);
            } else {
                aim = (aim == computer ? player : computer);
                attacker = (attacker == computer ? player : computer);
                clearConsole();
                System.out.println(result);
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                clearConsole();
            }
        }
        FieldPrinter.printFiled(convert.apply(attacker), attacker.getHitsMap(), attacker.getDamageList().stream());
        System.out.println("Победил " + attacker.getName());
    }

    private void initPlayer(Player gamer) {
        FieldPrinter.printFieldForInit(convert.apply(gamer));
        PlayerController.initShipLists(gamer, ShipType.SINGLE_DECK, 4);
        FieldPrinter.printFieldForInit(convert.apply(gamer));
        PlayerController.initShipLists(gamer, ShipType.DOUBLE_DECK, 3);
        FieldPrinter.printFieldForInit(convert.apply(gamer));
        PlayerController.initShipLists(gamer, ShipType.THREE_DECK, 2);
        FieldPrinter.printFieldForInit(convert.apply(gamer));
        PlayerController.initShipLists(gamer, ShipType.FOUR_DECK, 1);
    }

    private void initPlayer1(Player gamer) {
        PlayerController.addToList(gamer, ShipType.SINGLE_DECK, "A10", "V", 1);
        PlayerController.addToList(gamer, ShipType.SINGLE_DECK, "D9", "V", 1);
        PlayerController.addToList(gamer, ShipType.SINGLE_DECK, "F9", "V", 1);
        PlayerController.addToList(gamer, ShipType.SINGLE_DECK, "G6", "V", 1);
        PlayerController.addToList(gamer, ShipType.DOUBLE_DECK, "A1", "H", 2);
        PlayerController.addToList(gamer, ShipType.DOUBLE_DECK, "J3", "V", 2);
        PlayerController.addToList(gamer, ShipType.DOUBLE_DECK, "I9", "V", 2);
        PlayerController.addToList(gamer, ShipType.THREE_DECK, "D1", "V", 3);
        PlayerController.addToList(gamer, ShipType.THREE_DECK, "B5", "V", 3);
        PlayerController.addToList(gamer, ShipType.FOUR_DECK, "G1", "H", 4);
    }

    private void clearConsole() {
        for (int i = 0; i < 20; i++) {
            System.out.println();
        }
    }

}