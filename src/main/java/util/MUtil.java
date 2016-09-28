package util;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by marta.ginosyan on 9/27/2016.
 */
public class MUtil {

    public static Date getCurrentDate(){
        Calendar cal = Calendar.getInstance();
        return cal.getTime();
    }
}
