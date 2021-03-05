package date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;
import java.util.stream.IntStream;
import org.apache.commons.lang3.StringUtils;

public class ConvertDataJava8 {

    private static final String PATTERN_DDMMYYYY = "dd/MM/yyyy";
    private static final String PATTERN_YYYYMMDD = "yyyy-MM-dd";
    private static boolean couldEmpty;
    private static boolean beforeOrEqualThanToday;

    public static void main(String[] args) throws Exception {

        OffsetDateTime dateTime = OffsetDateTime.parse(
                "2018-09-16T08:10:00+0100",
                DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssZ")
        );
        System.out.println("Date: " + dateTime.format(DateTimeFormatter.ofPattern(PATTERN_DDMMYYYY)));
        print(getDefaultDBOffsetFormatTime("2021-03-01T14:36:42+01:00"));

        print(getDefaultDBFormatTime("1970-01-07T00:00:00Z"));
        print(getDefaultDBFormatTime2("1972-01-07"));
        print(getDefaultDBFormatTime2("1973-01-07T01:20:30Z"));
        print(getDefaultDBFormatTime3("1980-01-07T00:00:00Z"));
        print(getDefaultDBFormatTime3("1981-01-07T01:02:03Z"));
        print(getDefaultDBFormatTime3("1982-01-07T01:02:03Z"));
        print(getDateDefaulFormatTime2("1985-01-07T01:20:30Z"));
        System.out.println();
        print(getDefaultDBFormatTime4("1990-01-07T01:02:03Z"));
        print(getDefaultDBFormatTime4("1991-01-07 01:20:30"));
        print(getDefaultDBFormatTime4("1992-01-07"));

        //randomTests();

        //checkConvertions();

        //checkDates();
    }

    private static void randomTests() {
        System.out.println("13/13/1234".substring(0, "13/13/1234".lastIndexOf('/') + 1));

        LocalDate dateBefore = LocalDate.parse("16/04/2020", DateTimeFormatter.ofPattern(PATTERN_DDMMYYYY));
        System.out.println("BEFORE: " + dateBefore.isBefore(LocalDate.now().plusDays(1)));
        beforeOrEqualThanToday = true;
        System.out.println("beforeOrEqualThanToday [true]");
        System.out.println("COMPARE Before: " + ((beforeOrEqualThanToday && dateBefore.isAfter(LocalDate.now())) ? false : true));
        System.out.println("COMPARE Compare: " + ((beforeOrEqualThanToday && dateBefore.compareTo(LocalDate.now()) > 0) ? false : true));
        beforeOrEqualThanToday = false;
        System.out.println("beforeOrEqualThanToday [false]");
        System.out.println("COMPARE Before: " + ((beforeOrEqualThanToday && dateBefore.isAfter(LocalDate.now())) ? false : true));
        System.out.println("COMPARE Compare: " + ((beforeOrEqualThanToday && dateBefore.compareTo(LocalDate.now()) > 0) ? false : true));

    }

    private static void checkConvertions() throws Exception {
        printUpdateYear(updateYear("13/12/84"));
        printUpdateYear(updateYear("10/12/1984"));
        System.out.println();
        print(updateYearJava8("11/12/1984"));
        print(updateYearJava8("13/12/84"));
        print(updateYearJava8("13/12/03"));
        print(updateYearJava8("13/12/2003"));
        print(updateYearJava8("13/12/22"));
        print(updateYearJava8("13/12/25"));
        System.out.println();
        print(getDataBaseFormat("01/01/1985"));
        print(getDefaultFormat("1984-12-13"));
        System.out.println();
        print(getDefaultFormatTime("13/12/1984 12:00:22"));
        print(DateTimeFormatter.ISO_LOCAL_DATE_TIME.toString());
        print(getDefaultDBFormatTime("1974-01-07T00:00:00Z"));
        print(getDateDefaulFormatTime("13/12/1984 12:00:22").toString());
        System.out.println();
        System.out.println("isValidFormat [true]: " + isValidFormat("13/12/1984"));
        System.out.println("isValidFormat [false]: " + isValidFormat("2000-12-12"));

    }

    private static void printUpdateYear(String date) {
        System.out.println("Date updateYear: " + date);
    }

    private static void print(String date) {
        System.out.println("Date: " + date);
    }

    private static String updateYear(String stringDate) {
        int year = Integer.parseInt(stringDate.substring(stringDate.length() - 2, stringDate.length()));
        if (year < 100) {
            boolean isYearBelow = (Calendar.getInstance().get(Calendar.YEAR) - year) < 2000;
            year += isYearBelow ? 1900 : 2000;
            return stringDate.substring(0, stringDate.length() - 2).concat(Integer.toString(year));
        }
        return stringDate;
    }

    private static String updateYearJava8(String stringDate) throws Exception {
        String yearDate = Optional.ofNullable(stringDate)
                                  .filter(value -> stringDate.split("/").length == 3)
                                  .map(yearValue -> yearValue.split("/")[2])
                                  .orElseThrow(() -> new Exception("Erro dd/MM/yy or dd/MM/yyyy"));
        return LocalDate.parse(getNewDate(stringDate, getYear(yearDate)), DateTimeFormatter.ofPattern(PATTERN_DDMMYYYY))
                        .format(DateTimeFormatter.ofPattern(PATTERN_YYYYMMDD));
    }

    private static String getNewDate(String oldDate, String year) {
        return oldDate.substring(0, oldDate.lastIndexOf('/') + 1).concat(year);
    }

    private static String getYear(String yearDate) {
        return Optional.ofNullable(yearDate)
                       .filter(yearValue -> yearValue.length() <= 2)
                       .map(ConvertDataJava8::convertYear)
                       .orElse(yearDate);
    }

    private static String convertYear(String yearToConvert) {
        return Optional.of(yearToConvert)
                       .filter(yearInt -> (LocalDate.now().getYear() - Integer.valueOf(yearInt)) < 2000)
                       .map(newYear -> "19" + newYear)
                       .orElseGet(() -> "20".concat(yearToConvert));
    }


    private static String convertStrDate(String date, String formatIn, String formatOut) {
        return LocalDate.parse(date, DateTimeFormatter.ofPattern(formatIn))
                        .format(DateTimeFormatter.ofPattern(formatOut));
    }

    private static String getDataBaseFormat(String strDate) {
        return convertStrDate(strDate, PATTERN_DDMMYYYY, PATTERN_YYYYMMDD);
    }

    private static String getDefaultFormat(String strDate) {
        return convertStrDate(strDate, PATTERN_YYYYMMDD, PATTERN_DDMMYYYY);
    }

    private static String getDefaultFormatTime(String date) {
        return ZonedDateTime.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))
                            .with(LocalTime.of(0, 0, 0, 0))
                            .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    private static String getDefaultDBFormatTime(String date) {
        LocalDateTime offset = LocalDateTime.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'"));
        return offset.format(DateTimeFormatter.ofPattern(PATTERN_DDMMYYYY));
    }

    private static String getDefaultDBOffsetFormatTime(String date) {
        OffsetDateTime offset = OffsetDateTime.parse(date);
        return offset.format(DateTimeFormatter.ofPattern(PATTERN_DDMMYYYY));
    }

    private static String getDefaultDBFormatTime2(String date) throws ParseException {
        SimpleDateFormat sdfIn = new SimpleDateFormat(PATTERN_YYYYMMDD);
        Date birthDate = sdfIn.parse(date);
        SimpleDateFormat sdfOut = new SimpleDateFormat(PATTERN_DDMMYYYY);
        return sdfOut.format(birthDate);
    }

    private static String getDefaultDBFormatTime4(String date) throws ParseException {
        try {
            SimpleDateFormat sdfIn = new SimpleDateFormat(PATTERN_YYYYMMDD);
            Date newDate = sdfIn.parse(date);
            return newDate.toInstant()
                          .atZone(ZoneId.systemDefault())
                          .format(DateTimeFormatter.ofPattern(PATTERN_DDMMYYYY));
        } catch (ParseException e) {
            return "";
        }
    }

    private static String getDefaultDBFormatTime3(String date) {
        Instant offset = Instant.parse(date);
        return offset.toString();
    }

    private static Date getDateDefaulFormatTime(String dateTime) {
        LocalDateTime local = LocalDateTime.parse(dateTime, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return Date.from(local.with(LocalTime.of(11, 22, 44)).atZone(ZoneId.systemDefault()).toInstant());
    }

    private static String getDateDefaulFormatTime2(String dateTime) {
        LocalDateTime local = LocalDateTime.parse(dateTime, DateTimeFormatter.ISO_ZONED_DATE_TIME);
        return local.format(DateTimeFormatter.ofPattern(PATTERN_DDMMYYYY));
    }

    private static boolean isValidFormat(String dateTime) {
        try {
            LocalDate.parse(dateTime, DateTimeFormatter.ofPattern(PATTERN_DDMMYYYY));
        } catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }

    private static void checkDates() {
        System.out.println("Checklist: couldEmpty, beforeDate, Pattern");
        String defaultDate = "13/12/1984";
        couldEmpty = true;
        beforeOrEqualThanToday = true;
        System.out.println("couldEmpty [true]: " + isValid(defaultDate));
        System.out.println("couldEmpty [true]: " + isValid(""));
        couldEmpty = false;
        System.out.println("couldEmpty [true]: " + isValid(defaultDate));
        System.out.println("couldEmpty [false]: " + isValid(""));

        System.out.println("pattern [true]: " + isValid(defaultDate));
        System.out.println("pattern [false]: " + isValid("02/02/84"));

        //String testFutureDate = LocalDate.now().plusDays(1).format(DateTimeFormatter.ofPattern(PATTERN_DDMMYYYY));
        String testFutureDate = LocalDate.parse("10/10/2100", DateTimeFormatter.ofPattern(PATTERN_DDMMYYYY))
                                         .plusDays(1)
                                         .format(DateTimeFormatter.ofPattern(PATTERN_DDMMYYYY));
        String testTodayDate = LocalDate.now().format(DateTimeFormatter.ofPattern(PATTERN_DDMMYYYY));

        System.out.println("beforeDateTrue [true]: " + isValid(defaultDate));
        System.out.println("beforeDateTrue [true]: " + isValid(testTodayDate));
        System.out.println("beforeDateTrue [false]: " + isValid(testFutureDate));
        beforeOrEqualThanToday = false;
        System.out.println("beforeDateFalse [true]: " + isValid(defaultDate));
        System.out.println("beforeDateFalse [true]: " + isValid(testTodayDate));
        System.out.println("beforeDateFalse [true]: " + isValid(testFutureDate));

        couldEmpty = true;
        beforeOrEqualThanToday = true;
        System.out.println("beforeDateTrue [true]: " + isValid(defaultDate));
        System.out.println("beforeDateTrue [true]: " + isValid(testTodayDate));
        System.out.println("beforeDateTrue [false]: " + isValid(testFutureDate));
        beforeOrEqualThanToday = false;
        System.out.println("beforeDateFalse [true]: " + isValid(defaultDate));
        System.out.println("beforeDateFalse [true]: " + isValid(testTodayDate));
        System.out.println("beforeDateFalse [true]: " + isValid(testFutureDate));

    }

    public static boolean isValid(String dateValue) {
        boolean isDateExists = Optional.ofNullable(dateValue).filter(StringUtils::isNotBlank).isPresent();
        boolean isValidFormat = isDateExists && isValidFormat(dateValue);
        boolean isBeforeDate = isValidFormat && Optional.ofNullable(dateValue)
                                                        .map(dateToConvert -> LocalDate.parse(
                                                                dateToConvert,
                                                                DateTimeFormatter.ofPattern(PATTERN_DDMMYYYY)
                                                        ))
                                                        .filter(localDate -> beforeOrEqualThanToday && localDate.isAfter(
                                                                LocalDate.now()))
                                                        .map(result -> false)
                                                        .orElse(true);

        boolean isValid = (couldEmpty && !isDateExists) || isBeforeDate;
        System.out.print("Test [" + ajust(dateValue) + "] -> isDateExists[" + isDateExists + "] -> isValidFormat[" + isValidFormat + "] -> isBeforeDate[" + isBeforeDate + "] -> ");
        return isValid;
    }

    private static String ajust(String dateValue) {
        if (dateValue.length() < 10) {
            StringBuilder builder = new StringBuilder();
            builder.append(dateValue);
            IntStream.range(dateValue.length(), 10).forEach(action -> builder.append(" "));
            return builder.toString();
        }
        return dateValue;
    }

}
