package jack.tools.calendar;

import org.junit.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * Theme:
 * <p>
 * Description:
 *
 * @author Zhengde ZHOU
 * Created on 2019-01-08
 */
public class CalendarToolTest {

    @Test
    public void test() {
        int year = 2019;
        Duration between = Duration.between(LocalDate.of(year - 1, 1, 1), LocalDate.of(year, 1, 1));
        int totalWorkingDays = (int) between.toDays();
        System.out.println(totalWorkingDays);
    }

    @Test
    public void test1() {
        System.out.println(LocalDateTime.now());
        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println(zoneId);
        // output: Asia/Shanghai
    }

}
