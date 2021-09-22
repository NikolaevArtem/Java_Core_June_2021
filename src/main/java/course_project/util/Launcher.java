package course_project.util;

import course_project.parts.Bot;
import course_project.parts.GameField;
import course_project.parts.Player;

import java.util.Scanner;

public class Launcher {
    public static void launch() {
        GameField field = new GameField();
        GameField botField = new GameField();
        String name = startInfo();
        Player player = new Player(name, field, botField);
        Bot bot = new Bot(field);
        Game gameSession = new Game(player, bot);
        gameSession.startGame();
    }

    private static String startInfo() {
        System.out.println("Морской бой:\n" +
                "* Поля сражений генерируются случайно.\n" +
                "* Формат ввода:\n" +
                "  Буква латинского алфавита от A до J (регистр не важен)\n" +
                "  и цифра от 1 до 10 слитно.\n" +
                "  Например b4 или J7.\n" +
                "-----------------\n" +
                "Введите ваше имя: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
