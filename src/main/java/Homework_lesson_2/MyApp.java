package Homework_lesson_2;

public class MyApp {
    public static void main(String... args) {
        if (args.length == 0) return;
        for (String arg :
                args) {
            if (arg.equalsIgnoreCase("ошибка")) {
                System.err.println("Тревога!");
                return;
            } else {
                switch (arg.length()%10) {
                    case 1:
                        System.out.println(arg + ": " + arg.length() + " буква");
                        break;
                    case 2:
                    case 3:
                    case 4:
                        System.out.println(arg + ": " + arg.length() + " буквы");
                        break;
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                    case 0:
                        System.out.println(arg + ": " + arg.length() + " букв");
                        break;
                    default:
                        System.err.println("Тут должна быть ошибка, но обойдемся этим сообщением");
                }
            }
        }
    }
}
