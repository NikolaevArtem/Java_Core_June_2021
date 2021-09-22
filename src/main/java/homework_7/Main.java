package homework_7;

public class Main {
    public static void main(String[] args) {
        Kitten kitten = new Kitten("Murzik", "simple kitten", "2020");
        KittenToCatFunction kittenToCatFunction = (k) -> {
            int yearOfBirth = 0;
            try
            {
                yearOfBirth = Integer.parseInt(k.getYearOfBirth());
            }
            catch (NumberFormatException nfe)
            {
                System.out.println("NumberFormatException: " + nfe.getMessage());
            }

            return new Cat(k.getName(), k.getBreed(), 2021-yearOfBirth);
        };
        Cat cat = kittenToCatFunction.grow(kitten);

        System.out.println(kitten);
        System.out.println(cat);
    }
}
