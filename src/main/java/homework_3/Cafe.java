package homework_3;

/**
 * Immutable class has next characteristics: <p>
 * - it's final, to prevent breaking immutability through inheritance <p>
 * - it has private and final fields so client doesn't have direct access <p>
 * - it uses "defencive copying": doesn't work with reference type directly,
 * but copies objects into own fields, and returns copies of it's own objects instead of direct references <p>
 * - it has no setter methods for fields <p>
 * - if there is need to change it's fields it returns a new object <p>
 * Immutable class is extremely well encapsulated!
 */

public final class Cafe {

   private final StringBuilder name;
   private final double averageCheck;
   private final int seats;

   public Cafe(StringBuilder name, double check, int seats) {
       this.name = new StringBuilder(name);
       averageCheck = check;
       this.seats = seats;
   }

    public Cafe(double check, int seats) {
        this.name = null;
        averageCheck = check;
        this.seats = seats;
    }

    public StringBuilder getName() {
       if (name != null) {
           return new StringBuilder(name);
       }
       return new StringBuilder("Nameless cafe");
    }

    public double getAverageCheck() {
       return averageCheck;
    }

    public int getSeats() {
       return seats;
    }

    public Cafe changeNumOfSeats(int newSeats) {
       return new Cafe(name, averageCheck, newSeats);
    }

    public static void main(String[] args) {
        StringBuilder name = new StringBuilder("Bushe");
        Cafe cafe = new Cafe(name, 1100.0, 40);

        StringBuilder cafeName = cafe.getName();
        System.out.println("Cafe's name: " + cafeName);

        name.append("2");
        System.out.println("Altered name var: " + name);
        System.out.println("Cafe's name after alteration: " + cafe.getName());

        cafeName.append("10");
        System.out.println("Cafe's name after alteration through received reference : " + cafe.getName());

        Cafe modifiedCafe = cafe.changeNumOfSeats(45);
        System.out.println("Does modified cafe is the same cafe? - " + (cafe == modifiedCafe));
    }
}
