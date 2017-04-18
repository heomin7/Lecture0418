package datetime;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

/**
 * Created by danawacomputer on 2017-04-18.
 */
public class HelloDate {

    public static void main(String[] args){
        long current = System.currentTimeMillis();
        System.out.println(current);

        LocalDate d = LocalDate.now();
        System.out.println(d);
        LocalTime t = LocalTime.now();
        System.out.println(t);

        LocalDateTime dt = LocalDateTime.now();
        System.out.println(dt);

        ZonedDateTime zdt = ZonedDateTime.now();
        System.out.println(zdt);

        LocalDate date = LocalDate.of(2016,1,23);
        System.out.println(date);
        LocalTime time = LocalTime.of(23,22,10);
        System.out.println(time);

        LocalDateTime datetime = LocalDateTime.of(date, time);
        System.out.println(datetime);

        ZonedDateTime zDatetime = ZonedDateTime.of(datetime, ZoneId.of("Asia/Seoul"));
        System.out.println(zDatetime);

        int year = d.getYear();
        System.out.println(year);
        System.out.println(d.getMonth());
        System.out.println(d.getDayOfMonth());
        System.out.println(d.getDayOfWeek());
        System.out.println(d.getDayOfYear());

        LocalDate ananymousDay = d.plus(3, ChronoUnit.DAYS);
        System.out.println(ananymousDay);
        System.out.println(ananymousDay.plusDays(5));

        LocalDate start = LocalDate.of(2017, 4, 3);
        LocalDate fifty = start.plusDays(49);
        LocalDate oneHundred = start.plusDays(99);
        LocalDate twoHundred = start.plusDays(199);
        LocalDate fiveHundred = start.plusDays(499);
        LocalDate oneThousand = start.plusDays(999);

        System.out.println("start: " + start);
        System.out.println("+50: " + fifty);
        System.out.println("+100: " + oneHundred);
        System.out.println("+200: " + twoHundred);
        System.out.println("+500: " + fiveHundred);
        System.out.println("+1000: " + oneThousand);

        long l = start.toEpochDay();
        System.out.println(l);

        LocalDate epocday = LocalDate.of(1970, 1, 1);
        System.out.println(epocday.plusDays(17259));

        //3년전 그날로부터 3달 후
        System.out.println(start.plusDays(49).plusMonths(3).minusYears(3));

        //지금까지 몇일 살았는지 계산
        LocalDate birthday = LocalDate.of(1988, 5,14);
        Period pd = Period.between(birthday, d);
        System.out.println(pd.getYears() + "-" + pd.getMonths() + "-" + pd.getDays());


        long dday = birthday.until(d, ChronoUnit.DAYS);
        System.out.println(dday);

        if(fifty.compareTo(oneHundred) > 0){
            System.out.println("fifty가 더 커요");
        }
        else{
            System.out.println("oneHundred가 더 커요");
        }

        LocalDate today = LocalDate.now();
        LocalDate nextWednesday = today.with((TemporalAdjusters.next(DayOfWeek.WEDNESDAY)));

        System.out.println(nextWednesday);





    }

}
