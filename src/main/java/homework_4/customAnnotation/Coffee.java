package homework_4.customAnnotation;

import lombok.Data;
import lombok.SneakyThrows;

@Data
@ClassCoffeeAnnotation(price = 100)
public class Coffee {
    int price;
    boolean hasMilk;
    ClassCoffeeAnnotation.Size size;

    public Coffee() {
        ClassCoffeeAnnotation annotation = this.getClass().getAnnotation(ClassCoffeeAnnotation.class);

        this.price = annotation.price();
        this.hasMilk = annotation.hasMilk();
        this.size = annotation.size();
    }

    @SneakyThrows
    @AskForCoffeeAnnotation("Give me please this one!")
    public void askForCoffee(){
        System.out.println(this.getClass().getMethod("askForCoffee").getDeclaredAnnotation(AskForCoffeeAnnotation.class).value());
    }

    @StartMakingCoffee
    public void createCoffee(){
        //Some business logic
    }

    @StopMakingCoffee
    public void stopCoffee(){
        //Some business logic
    }
}



