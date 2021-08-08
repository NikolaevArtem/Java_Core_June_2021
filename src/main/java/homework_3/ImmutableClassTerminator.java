package homework_3;

/*                                  How to make Immutable Objects:
    1. Don't provide "setter" methods — methods that modify fields or objects referred to by fields.
    2. Make all fields final and private.
    3. Don't allow subclasses to override methods. The simplest way to do this is to declare the class as final.
       A more sophisticated approach is to make the constructor private and construct instances in factory methods.
    4. If the instance fields include references to mutable objects, don't allow those objects to be changed:
         - Don't provide methods that modify the mutable objects.
         - Don't share references to the mutable objects. Never store references to external, mutable objects passed to
           the constructor; if necessary, create copies, and store references to the copies. Similarly, create copies
           of your internal mutable objects when necessary to avoid returning the originals in your methods.
*/

import java.util.Date;

public final class ImmutableClassTerminator {
    private final int departureYear;
    private final String model;
    private final Date timeTravelDate;

    public ImmutableClassTerminator(int departureYear, String model, Date timeTravelDate) {
        this.departureYear = departureYear;
        this.model = model;
        this.timeTravelDate = timeTravelDate;
    }

    public ImmutableClassTerminator(int departureYear, Date timeTravelDate) {
        this.departureYear = departureYear;
        this.model = "T100";
        this.timeTravelDate = timeTravelDate;
    }

    public ImmutableClassTerminator(int departureYear, String model) {
        this.departureYear = departureYear;
        this.model = model;
        this.timeTravelDate = new Date();
    }

    public int getDepartureYear() {
        return departureYear;
    }

    public String getModel() {
        return model;
    }

    public Date getTimeTravelDate() {
        return (Date) timeTravelDate.clone();
    }

    public ImmutableClassTerminator changeTimeTravelDate(Date newTimeTravelDate) {
        return new ImmutableClassTerminator(departureYear, model, newTimeTravelDate);
    }
}
