package himmat.crickme.Utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Himmat on 24-11-2017.
 */

public class AppUtility {
    static DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");

    public static Date GetDateFromString(String dateString){
        try {
            return dateFormat.parse(dateString);
        }
        catch (Exception ex){

        }
        return null;
    }

    public static String GetStringFromDate(Date date){
        return dateFormat.format(date);
    }
}
