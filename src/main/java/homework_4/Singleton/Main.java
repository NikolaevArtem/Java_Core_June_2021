package homework_4.Singleton;

/*
 *Example of using Singleton
 */

public class Main {
    public static void main(String[] args) {

        Circle myCircle = Circle.getInstance();
        myCircle.setColor("green");

        Circle myCircle2 = Circle.getInstance();
        myCircle2.setColor("red");

        System.out.println(myCircle.getColor()); // red
        System.out.println(myCircle2.getColor()); // red
        System.out.println(myCircle == myCircle2); // true
    }
}
