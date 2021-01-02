package date;

import java.util.Calendar;
import java.util.Date;

public class LogicaDataSchedule {
    
    private final static String NEXT = "next";
    private final static String PREVIEW = "preview";
    private final static String TODAY = "today";
    
    private static Date dateStart;

    public static void main(String[] args) {
        dateStart = new Date();
        Date dateTest = getDateTeste();
        
        System.out.println(getDirection(dateTest));
        

    }

    private static Date getDateTeste() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2018, 4, 20, 10, 10, 0);
        return calendar.getTime();
    }
    
    private static String getDirection(Date data) {
        Calendar calendarReceived = Calendar.getInstance();
        calendarReceived.setTime(data);
        
        Calendar calendarStartDate = Calendar.getInstance();
        calendarStartDate.setTime(dateStart);
        
        if (isMoreThanOneMonth(calendarReceived.get(Calendar.MONTH), calendarStartDate.get(Calendar.MONTH))) {
            return TODAY;
        }
        
        
        return "";
    }
    
    private static boolean isMoreThanOneMonth(int monthReceived, int monthStart) {
        return ((monthReceived - monthStart) > 1 || (monthStart - monthReceived) > 1 );
    }

}
