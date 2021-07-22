package homework_3;

public final class ImmutableClass {
    final String name;
    final int number;

    public ImmutableClass() {
        this.name = "DefaultName";
        this.number = 0;
    }

    public ImmutableClass(String str, int number) {
        this.name = str;
        this.number = number;
    }

    public ImmutableClass(int number, String str) {
        this.number = number;
        this.name = str;
    }

    public String getData() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public final Object newObjectMethod() {
        return new ImmutableClass("fromMethodCreated", 1);
    }

}
