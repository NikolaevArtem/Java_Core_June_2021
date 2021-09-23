package course_project;

import course_project.Utils.ConsoleHandling.Printer;
import course_project.Utils.GameHandler.Handler;

public class SeaBattle {
    final Printer printer = new Printer();
    final Handler handler = new Handler();

    public void play(){
    printer.printGreeting();

    handler.start();
    do{
        handler.makeMoves();
    }
    while (!handler.endOfGame());




    printer.printGoodbye();


    }



}
