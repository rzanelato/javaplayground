package time;

public class TimeTestSystemNano {
    
    private static final long NANO_TO_SECONDS = 1000000000;

    public static void main(String[] args) {
        long time = 9791830805100L;
        
        long timeToSeconds = (System.nanoTime() - time) / NANO_TO_SECONDS;
        
        System.out.println("Time nano: " + time);
        System.out.println("Time to Seconds: " + timeToSeconds);

    }

}
