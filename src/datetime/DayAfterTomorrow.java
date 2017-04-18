package datetime;

import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;

/**
 * Created by danawacomputer on 2017-04-18.
 */
public class DayAfterTomorrow implements TemporalAdjuster{


    @Override
    public Temporal adjustInto(Temporal temporal) {

        return temporal.plus(2, ChronoUnit.DAYS);
    }
}
