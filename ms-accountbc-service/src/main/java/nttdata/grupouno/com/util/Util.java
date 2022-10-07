package nttdata.grupouno.com.util;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class Util {

    private Util(){

    }

    public static String dateTimeToString(Date date){
        DateFormat formatter = new SimpleDateFormat("yyyy.MM.dd HH.mm.ss");
        return formatter.format(date);
    }

    public static Date stringToDateTime(String dateString) {
        SimpleDateFormat formatter=new SimpleDateFormat("yyyy.MM.dd HH.mm.ss");
        if (dateString == null){
            return null;
        }
        try {
            return formatter.parse(dateString);
        } catch (ParseException e) {
            return null;
        }
    }
}
