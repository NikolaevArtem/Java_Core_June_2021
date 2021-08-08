package homework_3;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        ImmutableClassTerminator terminator = new ImmutableClassTerminator(2077, "T100");
        int year = terminator.getDepartureYear();
        String model = terminator.getModel();
        Date date = terminator.getTimeTravelDate();

        System.out.println(year);
        System.out.println(model);

        System.out.println(date);
        date.setTime(0);
        System.out.println(date);
        System.out.println(terminator.getTimeTravelDate()); //field does not change

        ImmutableClassTerminator newTerminator = terminator.changeTimeTravelDate(new Date(1212121212121L));
        Date newDate = newTerminator.getTimeTravelDate();
        System.out.println(newDate);
    }
}
