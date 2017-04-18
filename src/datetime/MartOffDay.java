package datetime;

import java.time.LocalDate;

/**
 * Created by danawacomputer on 2017-04-18.
 */
public class MartOffDay {
    public static void main(String[] args){
        LocalDate today = LocalDate.now();

        LocalDate nextMartOffDay = today.with(new TheDayMartOff());

        System.out.println(nextMartOffDay);
    }
}
