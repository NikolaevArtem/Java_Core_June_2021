package homework_3;

// The class must be declared as final (So that child classes can’t be created)
// Data members in the class must be declared as private (So that direct access is not allowed)
// Data members in the class must be declared as final (So that we can’t change the value of it after object creation)
// A parameterized constructor should initialize all the fields performing a deep copy (So that data members can’t be modified with object reference)
// Deep Copy of objects should be performed in the getter methods (To return a copy rather than returning the actual object reference)
// No setters (To not have the option to change the value of the instance variable)

public final class ImmutableClass {

    private final String string;
    private final int intVal;
    private final StringBuilder stringBuilder;

    private ImmutableClass(String string, int intVal, StringBuilder stringBuilder) {
        this.string = string;
        this.intVal = intVal;
        this.stringBuilder = new StringBuilder(stringBuilder);
    }

    private ImmutableClass() {
        this.string = "defaultVal";
        this.intVal = 0;
        this.stringBuilder = new StringBuilder("defaultValue");
    }

    @Override
    public String toString() {
        return "ImmutableClass{" +
                "string='" + string + '\'' +
                ", intVal=" + intVal +
                ", stringBuilder=" + stringBuilder +
                '}';
    }

    public String getString() {
        return string;
    }

    public StringBuilder getStringBuilder() {
        return new StringBuilder(stringBuilder);
    }
    public ImmutableClass createNewObj() {
        return new ImmutableClass();
    }

    public static void main(String[] args) {
        StringBuilder secondName = new StringBuilder("SecondName");
        ImmutableClass item = new ImmutableClass("Name", 12, secondName);

        System.out.println("Just created item: " + item);
        System.out.println(item.getStringBuilder());

        System.out.println("");

        secondName.append("NEW");
        System.out.println("Item after changes: " + item);
        System.out.println( "from object = " + item.getStringBuilder() + "; from variable = " + secondName);
    }
}