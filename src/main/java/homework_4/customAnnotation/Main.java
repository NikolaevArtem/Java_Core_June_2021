package homework_4.customAnnotation;

import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {

        Coffee myCoffee = new Coffee();

        System.out.println("Size: " + myCoffee.size);
        System.out.println("With milk: " + myCoffee.hasMilk);
        System.out.println("Price: " + myCoffee.price + "₽");

        myCoffee.askForCoffee();
        System.out.println();

        boolean hasStart=false;
        boolean hasStop=false;

        Method[] method = Class.forName("homework_4.customAnnotation.Coffee").getMethods();
        for(Method md: method){
            if(md.isAnnotationPresent(StartMakingCoffee.class)) {hasStart=true;}
            if(md.isAnnotationPresent(StopMakingCoffee.class)) {hasStop=true;}
        }

        System.out.println("Start making coffee - " + hasStart);
        System.out.println("Making nice coffee...");
        System.out.println("Stop making coffee - " + hasStop);
    }

}
