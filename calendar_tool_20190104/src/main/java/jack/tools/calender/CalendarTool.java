package jack.tools.calender;

import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Theme:
 * <p>
 * Description:
 *
 * @author Zhengde ZHOU
 * Created on 2019-01-04
 */
public class CalendarTool {


    public static List<Calendar> generateCalendar(String country, String brand, String calendarCode, int year, Set<LocalDate> nonWorkingDays)
            throws Exception {
        if (StringUtils.isBlank(country) || StringUtils.isBlank(brand) || StringUtils.isBlank(calendarCode)
                || year > LocalDate.now().getYear() + 1 || year < LocalDate.now().getYear()) {
            throw new Exception("参数错误");
        }

        List<Calendar> calendars = new ArrayList<>();
        int totalWorkingDays = Period.between(LocalDate.of(year, 1, 1), LocalDate.of(year-1, 1, 1)).getDays();
        for (int i = 1; i < 365; i++) {
            Calendar calendar = new Calendar(country, brand, calendarCode, year);
            calendar.setTotalNonWorkingDays(totalWorkingDays);
        }



        return calendars;

    }


    public static void generateSql(List<Calendar> calendars, String path) {

    }

    public static void main(String[] args) {

    }



}
