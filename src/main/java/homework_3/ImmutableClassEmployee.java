package homework_3;

import java.util.Date;

//1. Declare your class as final,
// so other classes will not be able to extend it and break its immutability
final class ImmutableClassEmployee {

    //2. Mark all the fields private. So, they they can't be accessed outside the class
    //3. Mark all fields final as well. So, no one can modify them anywhere else apart from the constructor.
    private final int id;
    private final String name;
    private final Date dateOfBirth;

    //4. Provide an argument constructor with all initialization logic
    public ImmutableClassEmployee(int id, String name, Date dateOfBirth) {
        this.id = id;
        this.name = name;
        //5. Initialize all your fields by deeply copying them if they are not immutable by nature
        this.dateOfBirth = new Date(dateOfBirth.getTime());
    }

    //6. Do not provide setters of your fields
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    //7. Instead of returning objects from the getters
    // return a deep copy of them if this objects are not immutable by nature
    public Date getDateOfBirth() {
        return new Date(dateOfBirth.getTime());
    }

    @Override
    public String toString() {
        return "ImmutableClassEmployee{" +
                "id = " + id +
                ", name = '" + name + '\'' +
                ", dateOfBirth = " + dateOfBirth +
                ", dateOfBirth = " + dateOfBirth + "}";
    }
}
