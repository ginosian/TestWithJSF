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

    public static boolean isBeforeToday(Date date){
        return date.before(MUtil.getCurrentDate());
    }

    public static boolean isAlphabeticData(String data){
        return data.chars().allMatch(Character::isLetter);
    }

    public static boolean isValidString(String data){
        return data != null && !data.isEmpty();
    }
}
