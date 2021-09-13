package lesson_17;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class Main {

  public static void main(String[] args) throws ParseException {
    newDateTime();
  }

  // жизнь будет проще, если вы будете воспринимать его как
  // простую обертку над внутренним полем типа long
  // в котором хранится количество миллисекунд с того-самого-момента
  // Date: почти все методы deprecated
  private static void oldDateTime() throws ParseException {
    // "the epoch", namely January 1, 1970, 00:00:00 GMT.

    final long now = System.currentTimeMillis();
    final long nanoTime = System.nanoTime();
    System.out.println(nanoTime);

    // Date
    final Date date = new Date();
    System.out.println("date = " + date);

    // Calendar
    final Calendar calendar = GregorianCalendar.getInstance();
    System.out.println("calendar.get(Calendar.HOUR_OF_DAY) = " + calendar.get(Calendar.HOUR_OF_DAY));
    calendar.add(Calendar.HOUR_OF_DAY, -2);
    System.out.println("calendar.get(Calendar.HOUR_OF_DAY) = " + calendar.get(Calendar.HOUR_OF_DAY));
    calendar.set(2016, Calendar.JANUARY, 5, 12, 30, 0);
    System.out.println(calendar.getTime());

    final TimeZone timeZone = calendar.getTimeZone();
    System.out.println("timeZone.toZoneId() = " + timeZone.toZoneId());

    // DateFormat
    final SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
    System.out.println("dateFormat.format(date) = " + dateFormat.format(date));
    final Date parsed = dateFormat.parse("13 September 2021");
    System.out.println("parsed = " + parsed);

    final Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    final java.sql.Date date1 = new java.sql.Date(System.currentTimeMillis());
    final Time time = new Time(System.currentTimeMillis());
  }

  // immutable
  // easier to use and understand
  // easier to work with timezones
  private static void newDateTime() {
    final LocalDateTime now = LocalDateTime.now();
    System.out.println("now = " + now);
    final LocalDateTime of = LocalDateTime.of(2021, 5, 7, 5, 30);
    System.out.println("of = " + of);
    final LocalDateTime parse = LocalDateTime.parse("2015-02-20T05:30");
    System.out.println("parse = " + parse);

    final LocalDateTime plus = now.plus(5, ChronoUnit.DAYS);
    System.out.println("plus = " + plus);

    final String format = now.format(DateTimeFormatter.ISO_TIME);
    System.out.println("format = " + format);

    // Period & Duration & Instant

    final int years = Period.between(LocalDate.MIN, LocalDate.MAX).getYears();
    System.out.println("years = " + years);
    final LocalDateTime plus1 = now.plus(Duration.ofDays(3));

    final Instant instant = plus1.toInstant(ZoneOffset.UTC);
    final Date from = Date.from(instant);
    final Instant now1 = Instant.now();
  }

}
