package datetime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

/**
 * Created by danawacomputer on 2017-04-18.
 */
public class TheDayMartOff implements TemporalAdjuster{

    @Override
    public Temporal adjustInto(Temporal temporal) {

        LocalDate theDay = LocalDate.from(temporal);
        LocalDate twoWeek =
                theDay.with(TemporalAdjusters.dayOfWeekInMonth(2, DayOfWeek.THURSDAY));
        LocalDate fourWeek =
                theDay.with(TemporalAdjusters.dayOfWeekInMonth(4, DayOfWeek.THURSDAY));


        if(theDay.isBefore(twoWeek)){
            return twoWeek;
        }
        else if(theDay.isEqual(twoWeek)){
            return twoWeek;
        }
        else if(theDay.isBefore(fourWeek)){
            return fourWeek;
        }
        else if(theDay.isEqual(fourWeek)){
            return fourWeek;
        }
        else if(theDay.isAfter(twoWeek)){
            return theDay.plusMonths(1).with(TemporalAdjusters.
                    dayOfWeekInMonth(2, DayOfWeek.THURSDAY));
        }

        return null;
    }
}
//2, 4주 목요일