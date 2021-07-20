package homework_3;

import java.util.Arrays;

public final class ImmutableTask {

//    Requirements for immutable class:
//    The class must be declared as final (So that child classes can’t be created)
//    Data members in the class must be declared as private (So that direct access is not allowed)
//    Data members in the class must be declared as final (So that we can’t change the value of it after object creation)
//    A parameterized constructor should initialize all the fields performing a deep copy (So that data members can’t be modified with object reference)
//    Deep Copy of objects should be performed in the getter methods (To return a copy rather than returning the actual object reference)
//    No setters (To not have the option to change the value of the instance variable)
//    To change class properties, class should have methods which return a new instance of a class with new properties

    private final String name;
    private final String description;
    private final int estimation;
    private final String[] additionalInfo;

    public ImmutableTask(String name) {
        this.name = name;
        this.description = "";
        this.estimation = 0;
        this.additionalInfo = new String[]{};
    }

    public ImmutableTask(String name, String description) {
        this.name = name;
        this.description = description;
        this.estimation = 0;
        this.additionalInfo = new String[]{};
    }

    public ImmutableTask(String name, String description, int estimation) {
        this.name = name;
        this.description = description;
        this.estimation = estimation;
        this.additionalInfo = new String[]{};
    }

    public ImmutableTask(String name, String description, int estimation, String[] additionalInfo) {
        this.name = name;
        this.description = description;
        this.estimation = estimation;
        //since array contains immutable values, shallow copy is OK
        this.additionalInfo = additionalInfo.clone();
        }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getEstimation() {
        return estimation;
    }

    public String[] getAdditionalInfo() {
        //since array contains immutable values, shallow copy is OK
        return additionalInfo.clone();
    }

    public ImmutableTask changeName (String newName){
        //since class is immutable return a new instance with changed property
        return new ImmutableTask(newName, getDescription(), getEstimation(), getAdditionalInfo());
    }

    public ImmutableTask changeDescription (String newDescription){
        //since class is immutable return a new instance with changed property
        return new ImmutableTask(getName(), newDescription, getEstimation(), getAdditionalInfo());
    }

    public ImmutableTask changeAdditionalInfo(int index, String value){
        if (index + 1 > additionalInfo.length){
            throw new RuntimeException("Index of AdditionalInfo is out of bounds");
        }
        String[] newArray = getAdditionalInfo();
        newArray[index] = value;
        //since class is immutable return a new instance with changed property
        return new ImmutableTask(getName(), getDescription(), getEstimation(), newArray);
    }

    @Override
    public String toString() {
        return String.format("name: %s\ndescription: %s\nestimation: %s\nadditionalInfo: %s",
                getName(),
                getDescription(),
                getEstimation(),
                Arrays.deepToString(getAdditionalInfo()));
    }
}

