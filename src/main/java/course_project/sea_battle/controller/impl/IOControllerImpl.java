package course_project.sea_battle.controller.impl;

import course_project.sea_battle.controller.IOController;

import java.util.Scanner;

public final class IOControllerImpl implements IOController {
    //только для тестов. Я не знаю как сделать иначе, теперь сканер не финален и это ужасно.
    private Scanner scanner = new Scanner(System.in).useDelimiter("\n");

    @Override
    public String dialog(String msg) {
        System.out.println(msg);
        return scanner.nextLine();
    }

    @Override
    public void clr() {
        print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

    @Override
    public void print(String msg) {
        System.out.println(msg);
    }

    @Override
    public void close() {
        scanner.close();
    }

    //только для тестов. Я не знаю как сделать иначе
    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    private IOControllerImpl() {}

    public static IOControllerImpl getInstance() {
        return IOControllerImpl.Holder.INSTANCE;
    }

    private static class Holder {
        static final IOControllerImpl INSTANCE = new IOControllerImpl();
    }
}
