package homework_4.annotation;

@DefaultUserInfo(
        name = "Nikita",
        id = 1
)
public class Profile {

    private final String name;
    private final int id;

    public Profile() {
        name = Profile.class.getDeclaredAnnotation(DefaultUserInfo.class).name();
        id = Profile.class.getDeclaredAnnotation(DefaultUserInfo.class).id();
    }

    public Profile(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}