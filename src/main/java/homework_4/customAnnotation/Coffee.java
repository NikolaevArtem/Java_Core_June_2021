package homework_4.customAnnotation;

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

    @AskForCoffeeAnnotation("Give me please this one!")
    public void askForCoffee() throws NoSuchMethodException {
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



