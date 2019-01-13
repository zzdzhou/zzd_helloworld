package jack.tools.calendar;

import jack.tools.calender.Calendar;
import jack.tools.calender.CalendarTool;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/**
 * Theme:
 * <p>
 * Description:
 *
 * @author Zhengde ZHOU
 * Created on 2019-01-08
 */
public class CalendarToolTest {

    public static final HashSet<LocalDate> NON_WORKING_DAYS = new HashSet<>();

    static {
        NON_WORKING_DAYS.add(LocalDate.of(2019, 1, 1));
        NON_WORKING_DAYS.add(LocalDate.of(2019, 2, 5));
        NON_WORKING_DAYS.add(LocalDate.of(2019, 2, 6));
        NON_WORKING_DAYS.add(LocalDate.of(2019, 2, 7));
        NON_WORKING_DAYS.add(LocalDate.of(2019, 4, 5));
        NON_WORKING_DAYS.add(LocalDate.of(2019, 4, 19));
        NON_WORKING_DAYS.add(LocalDate.of(2019, 4, 20));
        NON_WORKING_DAYS.add(LocalDate.of(2019, 4, 22));
        NON_WORKING_DAYS.add(LocalDate.of(2019, 5, 1));
        NON_WORKING_DAYS.add(LocalDate.of(2019, 5, 13));
        NON_WORKING_DAYS.add(LocalDate.of(2019, 6, 7));
        NON_WORKING_DAYS.add(LocalDate.of(2019, 7, 1));
        NON_WORKING_DAYS.add(LocalDate.of(2019, 9, 14));
        NON_WORKING_DAYS.add(LocalDate.of(2019, 10, 1));
        NON_WORKING_DAYS.add(LocalDate.of(2019, 10, 7));
        NON_WORKING_DAYS.add(LocalDate.of(2019, 12, 25));
        NON_WORKING_DAYS.add(LocalDate.of(2019, 12, 26));
    };

    @Test
    public void test() {
        int year = 2019;
        /*Instant startTime = LocalDate.of(year - 1, 1, 1).atStartOfDay().toInstant(ZoneOffset.UTC);
        Instant endTime = LocalDate.of(year, 1, 1).atStartOfDay().toInstant(ZoneOffset.UTC);
        Long days = Duration.between(startTime, endTime).toDays();
        System.out.println(days);*/

        long days1 = Duration
                .between(LocalDate.of(year - 1, 1, 1).atStartOfDay(), LocalDate.of(year, 1, 1).atStartOfDay())
                .toDays();
        System.out.println((int)days1);

    }

    @Test
    public void test1() {
        System.out.println(LocalDateTime.now());
        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println(zoneId);
        // output: Asia/Shanghai
    }


    @Test
    public void test3() {
        int year = 2019;
        LocalDateTime startTime = LocalDate.of(year - 1, 1, 1).atStartOfDay();
        Instant startInUTC = startTime.toInstant(ZoneOffset.UTC);
        System.out.println("startTime = " + startTime);
        System.out.println("startInUTC = " + startInUTC);
        System.out.println();

        LocalDateTime nowTime = LocalDateTime.now();
        Instant nowInUTC = nowTime.toInstant(ZoneOffset.UTC);
        Instant nowInDefault = nowTime.toInstant(ZoneOffset.ofHours(8));
        System.out.println("nowTime = " + nowTime);
        System.out.println("nowInUTC = " + nowInUTC);
        System.out.println("nowInDefault = " + nowInDefault);
        System.out.println();
    }

    @Test
    public void getWeek() {
        LocalDate now = LocalDate.now();
        String week1 = now.format(DateTimeFormatter.ofPattern("E", Locale.ENGLISH));
        String week2 = now.format(DateTimeFormatter.ofPattern("EEE", Locale.ENGLISH));
        String week3 = now.format(DateTimeFormatter.ofPattern("EEEE", Locale.ENGLISH));

        System.out.println(week1);
        System.out.println(week2);
        System.out.println(week3);
    }

    @Test
    public void getWeek2() {
        LocalDate now = LocalDate.now();
        System.out.println(now.getDayOfWeek().ordinal());
    }

    @Test
    public void generateCalendar() {
        try {
            List<Calendar> calendars = CalendarTool.generateCalendar("HK", "CA", "HK", 2019, NON_WORKING_DAYS);
            System.out.println(calendars);
            CalendarTool.generateSql(calendars, "C:\\Users\\zzd16\\Desktop\\zzd_helloworld\\calendar_tool_20190104\\calendar.sql");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFile() throws IOException {
        File file = new File("C:\\Users\\zzd16\\Desktop\\zzd_helloworld\\calendar_tool_20190104\\output");
        if (!file.exists()) {
            boolean newFile = file.createNewFile();

        }
    }

    @Test
    public void testXlsx() throws Exception {
        String xlsx = "C:\\Users\\zzd16\\Desktop\\zzd_helloworld\\calendar_tool_20190104\\src\\main\\resources\\Public Holidays 2019 (APAC).xlsx";
        Set<LocalDate> holidaysFromXlsx = CalendarTool.getHolidaysFromXlsx(xlsx);

        System.out.println(holidaysFromXlsx);
    }

}
