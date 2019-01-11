package jack.tools.calender;

import org.apache.commons.lang3.StringUtils;
import sun.util.resources.CalendarData;

import java.io.*;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static com.sun.deploy.cache.Cache.exists;

/**
 * Theme:
 * <p>
 * Description:
 *
 * @author Zhengde ZHOU
 * Created on 2019-01-04
 */
public class CalendarTool {

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


    public static List<Calendar> generateCalendar(String country, String brand, String calendarCode, int year, Set<LocalDate> nonWorkingDays)
            throws Exception {
        if (StringUtils.isBlank(country) || StringUtils.isBlank(brand) || StringUtils.isBlank(calendarCode)
                || year > LocalDate.now().getYear() + 1 || year < LocalDate.now().getYear()) {
            throw new Exception("参数错误");
        }

        List<Calendar> calendars = new ArrayList<>();
        final int totalDays = (int) Duration
                .between(LocalDate.of(year - 1, 1, 1).atStartOfDay(), LocalDate.of(year, 1, 1).atStartOfDay())
                .toDays();
        int workingDayNumer = 0;
        int nonWorkingDayNumer = 0;
        final DateTimeFormatter weekFormatter = DateTimeFormatter.ofPattern("E", Locale.ENGLISH);

        LocalDate localDate;
        for (int i = 1; i <= totalDays; i++) {
            localDate = LocalDate.ofYearDay(year, i);
            Calendar calendar = new Calendar(country, brand, calendarCode, year);
            // done
            calendar.setMonth(localDate.getMonthValue());
            // done
            calendar.setYearMonthDay(localDate);
            // done
            if (localDate.getDayOfWeek().ordinal() + 1 >= 6 || nonWorkingDays.contains(localDate)/*todo*/) {
                calendar.setNonWorkingDayFlag(true);
                nonWorkingDayNumer++;
            } else {
                calendar.setNonWorkingDayFlag(false);
                workingDayNumer++;
            }
            // done
            calendar.setWorkingDayNumer(workingDayNumer);
            // done
            calendar.setNonWorkingDayNumer(nonWorkingDayNumer);
            // done
            calendar.setNonWorkingDayCarrierFlag(calendar.isNonWorkingDayFlag());
            // done
            calendar.setWeekday(localDate.format(weekFormatter).toUpperCase());
            calendars.add(calendar);
        }

        for (Calendar item : calendars) {
            item.setTotalWorkingDays(workingDayNumer);
            item.setTotalNonWorkingDays(nonWorkingDayNumer);
        }
        return calendars;
    }

    public static void generateSql(List<Calendar> calendars, String pathDir) throws Exception {
        if (calendars == null || calendars.size() == 0) {
            throw new Exception("calendars 参数错误");
        }
        String filename = calendars.get(0).getBrand() + "_" + calendars.get(0).getCountry() + "_calendar.sql";
        // 输出文件的目录必须存在，文件本身可以不存在
        File parentDir = new File(pathDir);
        if (!parentDir.exists() && !parentDir.mkdirs()) {
            throw new IOException(String.format("目录 %s 不存在且创建失败", parentDir));
        }
        BufferedWriter out = new BufferedWriter(new FileWriter(pathDir + File.separator + filename));
        out.write(Calendar.INSERT_PREFIX); // 输出之前可以不需要输入，可直接输出指定内容
        for (int i = 0; i < calendars.size(); i++) {
            if (i == calendars.size() - 1) {
                out.write(calendars.get(i).toString() + ";\n");
            } else {
                out.write(calendars.get(i).toString() + ",\n");
            }
        }
        out.write(Calendar.INSERT_SUFFIX);
        out.close();
    }

    private boolean isNonWorkingDay(LocalDate date, Set<LocalDate> nonWorkingDays) {
        if (date.getDayOfWeek().ordinal() + 1 >= 6 || nonWorkingDays.contains(date)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        try {
            List<Calendar> calendars = CalendarTool.generateCalendar("HK", "CA", "HK", 2019, CalendarTool.NON_WORKING_DAYS);
            CalendarTool.generateSql(calendars, "C:\\Users\\zzd16\\Desktop\\output");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
