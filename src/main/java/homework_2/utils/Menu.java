package homework_2.utils;

import homework_2.pyramid.PyramidPrinter;
import homework_2.traffic.TrafficLight;

import java.util.Arrays;

public class Menu {
    private boolean isWork = true;
    private final Data data = new Data();
    private final MyReader reader = new MyReader();
    private final ResultPrinter rp = new ResultPrinter();
    private Parsable parser = new Parser();
    private Executable application;

    public void start() {

        while (isWork) {
            switch (data.getStatus()) {
                case START:
                    data.setStatus(Status.READ);
                    selectApp();
                    break;
                case READ:
                    System.out.println("Введите число:");
                    data.setStatus(Status.PARSE);
                    reader.read(data);
                    reader.close();
                    break;
                case PARSE:
                    data.setStatus(Status.EXECUTE);
                    parser.parse(data);
                    break;
                case EXECUTE:
                    data.setStatus(Status.PRINT);
                    application.execute(data);
                    break;
                case PRINT:
                case ERROR:
                    rp.printResult(data);
                    isWork = false;
                    break;
                default:
                    break;
            }
        }
    }

    private void selectApp() {
        System.out.println("Выбирите приложение(цифрой):");
        Arrays.stream(Applications.values())
                .forEach(System.out::println);

        reader.read(data);
        parser.parse(data);
        if (data.getType() != Type.INTEGER) {
            data.setStatus(Status.START);
            System.out.println("Введите положительное число!");
        }

        int numApp = Integer.parseInt(data.getInValue());
        switch (numApp) {
            case 1 :
                System.out.println(Applications.PYRAMID_PRINTER);
                application = new PyramidPrinter();
                break;
            case 2 :
                System.out.println(Applications.TRAFFIC_LIGHT);
                application = new TrafficLight();
                break;
            default:
                data.setStatus(Status.START);
                System.out.println("Приложения с таким номером еще нет");
                break;
        }
    }
}
