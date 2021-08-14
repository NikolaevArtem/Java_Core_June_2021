package Homework3.Immutable_Class_Task;
/*
Requirements for immutable classes
1. The class must be declared as final/

2.Fields in the class must be declared as private

3.Data members in the class must be declared as final
(So that we can’t change the value of it after object creation)

4. A parameterized constructor should initialize all the fields performing a deep copy
(So that data members can’t be modified with object reference)
5.Deep Copy of objects should be performed in the getter methods
(To return a copy rather than returning the actual object reference)

6. No setters
 */

public class Car {
    private int carID;
    private  int engine;
    private  int numberOfPreviosOwners;
    private  String make;
    private  String ownerName;

    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

    public int getEngine() {
        return engine;
    }

    public void setEngine(int engine) {
        this.engine = engine;
    }

    public int getNumberOfPreviosOwners() {
        return numberOfPreviosOwners;
    }

    public void setNumberOfPreviosOwners(int numberOfPreviosOwners) {
        this.numberOfPreviosOwners = numberOfPreviosOwners;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
}
