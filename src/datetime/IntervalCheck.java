package datetime;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.Scanner;

/**
 * Created by danawacomputer on 2017-04-18.
 */
public class IntervalCheck {
    public static void main(String[] args){
        Instant start = Instant.now();
        someAlgorithm();
        Instant end = Instant.now();

        Duration duration = Duration.between(start, end);
        long millis = duration.toMillis();
        System.out.println(millis);

        LocalDate now = LocalDate.now();

        LocalDate theDay = now.with(new DayAfterTomorrow());
    //    System.out.println(theDay);

        Scanner scanner = new Scanner(System.in);

        System.out.println("input date: ");
        String line = scanner.nextLine();

        String[] number = line.split("-");

        LocalDate today = LocalDate.of(Integer.parseInt(number[0]),
                Integer.parseInt(number[1]), Integer.parseInt(number[2]));

        LocalDate firstday = today.withDayOfMonth(1);

        LocalDate twoWeek = firstday.with(TemporalAdjusters.dayOfWeekInMonth(2, DayOfWeek.THURSDAY));
        LocalDate fourWeek = firstday.with(TemporalAdjusters.dayOfWeekInMonth(4, DayOfWeek.THURSDAY));

        System.out.println("first day: " + firstday);
        System.out.println("two week: " + twoWeek);
        System.out.println("four week: " + fourWeek);

        if(today.isBefore(twoWeek)){
            System.out.println(twoWeek);
        }
        else if(today.isEqual(twoWeek)){
            System.out.println(twoWeek);
        }
        else if(today.isBefore(fourWeek)){
            System.out.println(fourWeek);
        }
        else if(today.isEqual(fourWeek)){
            System.out.println(fourWeek);
        }
        else if(today.isAfter(twoWeek)){
            System.out.println(today.plusMonths(1).with(TemporalAdjusters.dayOfWeekInMonth(2, DayOfWeek.THURSDAY)));
        }

        System.out.println(today.with(new DayAfterTomorrow()));
    }

    public static void someAlgorithm(){

        long acc = 0L;
        for(int i = 0; i < 10_000_000; i++){
            acc += i;
        }
    }
}
