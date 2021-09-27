package homework_3;



/*
Immutable class means that once an object is created, we cannot change its content. In Java, all the wrapper classes (like Integer, Boolean, Byte, Short) and String class is immutable. We can create our own immutable class as well.

Following are the requirements:

- The class must be declared as final (So that child classes can’t be created)
- Data members in the class must be declared as private (So that direct access is not allowed)
- Data members in the class must be declared as final (So that we can’t change the value of it after object creation)
- A parameterized constructor should initialize all the fields performing a deep copy (So that data members can’t be modified with object reference)
- Deep Copy of objects should be performed in the getter methods (To return a copy rather than returning the actual object reference)
- No setters (To not have the option to change the value of the instance variable)
 */



public final class MyImmutableElectricGuitarESP {

    private final boolean hasActivePickups;
    private final int yearOfManufacture;
    private final String brandOfPickups;

    public MyImmutableElectricGuitarESP(boolean hasActivePickups) {
        this.hasActivePickups = hasActivePickups;
        this.yearOfManufacture = 2004;
        this.brandOfPickups = "EMG";
    }

    public MyImmutableElectricGuitarESP(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
        this.brandOfPickups = "Gibson";
        this.hasActivePickups = false;
    }

    public MyImmutableElectricGuitarESP(String brandOfPickups) {
        this.brandOfPickups = brandOfPickups;
        this.hasActivePickups = false;
        this.yearOfManufacture = 2006;
    }

    public MyImmutableElectricGuitarESP(boolean hasActivePickups, int yearOfManufacture, String brandOfPickups) {
        this.hasActivePickups = hasActivePickups;
        this.yearOfManufacture = yearOfManufacture;
        this.brandOfPickups = brandOfPickups;
    }

    public boolean isHasActivePickups() {
        return hasActivePickups;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public String getBrandOfPickups() {
        return brandOfPickups;
    }

    public MyImmutableElectricGuitarESP getNewMyImmutableElectricGuitarESP(boolean newHasActivePickups){
        return new MyImmutableElectricGuitarESP(newHasActivePickups);
    }

    public MyImmutableElectricGuitarESP getNewMyImmutableElectricGuitarESP(int newYearOfManufacture){
        return new MyImmutableElectricGuitarESP(newYearOfManufacture);
    }

    public MyImmutableElectricGuitarESP getNewMyImmutableElectricGuitarESP(String newBrandOfPickups){
        return new MyImmutableElectricGuitarESP(newBrandOfPickups);
    }

    public MyImmutableElectricGuitarESP getNewMyImmutableElectricGuitarESP(boolean newHasActivePickups, int newYearOfManufacture, String newBrandOfPickups){
        return new MyImmutableElectricGuitarESP(newHasActivePickups, newYearOfManufacture, newBrandOfPickups);
    }

    public MyImmutableElectricGuitarESP getNewMyImmutableElectricGuitarESP(MyImmutableElectricGuitarESP previousMyImmutableElectricGuitarESP, boolean newHasActivePickups){
        return new MyImmutableElectricGuitarESP(newHasActivePickups, previousMyImmutableElectricGuitarESP.getYearOfManufacture(), previousMyImmutableElectricGuitarESP.getBrandOfPickups());
    }

    public MyImmutableElectricGuitarESP getNewMyImmutableElectricGuitarESP(MyImmutableElectricGuitarESP previousMyImmutableElectricGuitarESP, int newYearOfManufacture){
        return new MyImmutableElectricGuitarESP(previousMyImmutableElectricGuitarESP.isHasActivePickups(), newYearOfManufacture, previousMyImmutableElectricGuitarESP.getBrandOfPickups());
    }

    public MyImmutableElectricGuitarESP getNewMyImmutableElectricGuitarESP(MyImmutableElectricGuitarESP previousMyImmutableElectricGuitarESP, String newBrandOfPickups){
        return new MyImmutableElectricGuitarESP(previousMyImmutableElectricGuitarESP.isHasActivePickups(), previousMyImmutableElectricGuitarESP.getYearOfManufacture(), newBrandOfPickups);
    }

}
