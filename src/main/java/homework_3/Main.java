package homework_3;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        ImmutableClassTerminator terminator = new ImmutableClassTerminator(2077, "T100");
        Date date = terminator.getTimeTravelDate();

        System.out.println(date);
        date.setTime(0);
        System.out.println(date);
        System.out.println(terminator.getTimeTravelDate()); //field does not change

        ImmutableClassTerminator newTerminator = terminator.changeTimeTravelDate(new Date(1212121212121L));
        Date newDate = newTerminator.getTimeTravelDate();
        System.out.println(newDate);

        final Date date1 = new Date();
        final ImmutableClassTerminator t100 = new ImmutableClassTerminator(2077, "T100", date1);
        System.out.println(t100);
        date1.setTime(111111111111L);
        System.out.println(t100);

        t100.getTimeTravelDate().setTime(111111111111L);
        System.out.println(t100);
    }
}
