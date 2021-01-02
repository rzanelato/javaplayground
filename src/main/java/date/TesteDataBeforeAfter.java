package date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TesteDataBeforeAfter {
    
    private static int daysRange = 0;

	public static void main(String[] args) {
	    /*
		Calendar dataIni = Calendar.getInstance();
		Calendar dataFim1 = Calendar.getInstance();
		Calendar dataFim2 = Calendar.getInstance();
		
		dataFim1.set(Calendar.HOUR_OF_DAY, 0);
		dataFim1.set(Calendar.MINUTE, 0);
		dataFim2.set(Calendar.HOUR_OF_DAY, 17);
		dataFim1.set(Calendar.MINUTE, 0);
		
		Date dateIni = dataIni.getTime();
		
		
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy : HH:mm");
		
		System.out.println("Data Ini " + format.format(dateIni));
		System.out.println("Data Fim1 " + format.format(dataFim1.getTime()));
		System.out.println("Data Fim2 " + format.format(dataFim2.getTime()));
		
		System.out.println("\nDATE");
		System.out.println("DataBefore 1 -> " + dateIni.before(dataFim1.getTime()));
		System.out.println("DataBefore 2 -> " + dateIni.before(dataFim2.getTime()));
		
		System.out.println("DataAfter 1 -> " + dateIni.after(dataFim1.getTime()));
		System.out.println("DataAfter 2 -> " + dateIni.after(dataFim2.getTime()));
		
		System.out.println("\nCALENDAR");
		System.out.println("DataBefore 1 -> " + dataIni.before(dataFim1));
		System.out.println("DataBefore 2 -> " + dataIni.before(dataFim2));
		
		System.out.println("DataAfter 1 -> " + dataIni.after(dataFim1));
		System.out.println("DataAfter 2 -> " + dataIni.after(dataFim2));
		
		dataFim1.add(Calendar.DATE, 5);
		dataFim2.add(Calendar.DATE, 5);
		
		System.out.println("DataAfter 1 -> " + (dataIni.getTimeInMillis() >= dataFim1.getTimeInMillis()));
		System.out.println("DataAfter 2 -> " + (dataIni.getTimeInMillis() >= dataFim2.getTimeInMillis()));
		
		System.out.println("\nHOUR MINUTE");
		System.out.println("Hora ini: " + dataIni.get(Calendar.HOUR_OF_DAY));
		System.out.println("Hora Fim1: " + dataFim1.get(Calendar.HOUR_OF_DAY));
		System.out.println("Hora Fim2: " + dataFim2.get(Calendar.HOUR_OF_DAY));
		
		System.out.println("HoraAfter 1 -> " + (dataIni.get(Calendar.HOUR_OF_DAY) >= dataFim1.get(Calendar.HOUR_OF_DAY)));
		System.out.println("HoraAfter 2 -> " + (dataIni.get(Calendar.HOUR_OF_DAY) >= dataFim2.get(Calendar.HOUR_OF_DAY)));
		
		System.out.println("\nTeste mesma hora e dia");
		dataFim1.set(Calendar.HOUR_OF_DAY, 13);
		System.out.println("Hora igual -> " + (dataIni.get(Calendar.HOUR_OF_DAY) >= dataFim1.get(Calendar.HOUR_OF_DAY)));
		*/
		testeLogicaTimeline();
	}
	
	private static void testeLogicaTimeline() {
	    System.out.println("\nTimeLine Test");
	    daysRange = 1;
	    refreshEndDate(9,10,0,0,9,10,0,0);
	    refreshEndDate(9,10,7,0,9,10,16,0);
	    refreshEndDate(9,10,7,0,9,10,1,0);
	    System.out.println();
	    daysRange = 3;
	    refreshEndDate(9,10,0,0,11,10,0,0);
	    refreshEndDate(9,10,7,0,11,10,16,0);
	    refreshEndDate(9,10,7,0,11,10,1,0);
	    
	    
	}
	
	private static void refreshEndDate(int dayS, int monthS, int hourS, int minuteS, int dayE, int monthE, int hourE, int minuteE) {
        Calendar calendarStart = Calendar.getInstance();
        calendarStart.setTime(getStartDate(dayS, monthS, hourS, minuteS));
        System.out.println("###Inicio:###");
        setEndDate(calendarStart.getTime());
        calendarStart.add(Calendar.DATE, daysRange-1);
        System.out.println("Provavel:");
        setEndDate(calendarStart.getTime());
        
        Calendar calendarEnd = Calendar.getInstance();
        calendarEnd.setTime(getEndDate(dayE, monthE, hourE, minuteE));
        System.out.println("Calculada:");
        setEndDate(calendarEnd.getTime());
        
        boolean isTimeStartBeforeTimeEnd = (calendarStart.get(Calendar.HOUR_OF_DAY) < calendarEnd.get(Calendar.HOUR_OF_DAY));
        boolean isDayEndEqualDayStart = (calendarEnd.get(Calendar.DAY_OF_MONTH) == calendarStart.get(Calendar.DAY_OF_MONTH));
        System.out.println("isTimeStartBeforeTimeEnd(" + isTimeStartBeforeTimeEnd + ") - isDayEndEqualDayStart("+ isDayEndEqualDayStart + ")");
        System.out.println("Result:");
        if (isTimeStartBeforeTimeEnd && !isDayEndEqualDayStart) {
            calendarEnd.add(Calendar.DATE, -1);
            setEndDate(calendarEnd.getTime());
        }
        if (!isTimeStartBeforeTimeEnd && isDayEndEqualDayStart) {
            calendarEnd.add(Calendar.DATE, 1);
            setEndDate(calendarEnd.getTime());
        }
        System.out.println("###Fim###");
    }
	
	private static Date getStartDate(int day, int month, int hour, int minute) {
	    return createDate(day, month, hour, minute);
	}
	
	private static Date getEndDate(int day, int month, int hour, int minute) {
	    return createDate(day, month, hour, minute);
	}
	
	private static Date createDate(int day, int month, int hour, int minute) {
	    Calendar dateCreated = Calendar.getInstance();
	    dateCreated.set(Calendar.DAY_OF_MONTH, day);
	    dateCreated.set(Calendar.MONTH, (month - 1));
	    dateCreated.set(Calendar.HOUR_OF_DAY, hour);
	    dateCreated.set(Calendar.MINUTE, minute);
	    
	    return dateCreated.getTime();
	}
	
	private static void setEndDate(Date data) {
	    SimpleDateFormat defaultDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        System.out.println(defaultDateFormat.format(data));
	    
	}

}
