package course_project;

public abstract class Player {
    private final Field field = new Field();

    abstract public void move();

    public void printField(boolean forFoe) {
        this.field.print(forFoe);
    }

}
