package jack.tools.calender;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Theme:
 * <p>
 * Description:
 *
 * @author Zhengde ZHOU
 * Created on 2019-01-04
 */
public class Calendar {

    public static final String INSERT_PREFIX = "BEGIN;\n\nINSERT INTO `calendar` (`COUNTRY`, `BRAND`, `CALENDAR_CODE`, `YEAR`," +
            " `TOTAL_WORKING_DAYS`, `TOTAL_NON_WORKING_DAYS`, `MONTH`, `YEAR_MONTH_DAY`, `NON_WORKING_DAY_FLAG`, " +
            "`WORKING_DAY_NUMBER`, `NON_WORKING_DAY_NUMBER`, `NON_WORKING_DAY_CARRIER_FLAG`, `WEEKDAY`) VALUES\n";

    public static final String INSERT_SUFFIX = "\nCOMMIT;";

//    private int id;

    private String country;

    private String brand;

    private String calendarCode;

    private int year;

    private int totalWorkingDays;

    private int totalNonWorkingDays;

    private int month;

    private LocalDate yearMonthDay;

    private boolean nonWorkingDayFlag;

    private int workingDayNumer;

    private int nonWorkingDayNumer;

    private boolean nonWorkingDayCarrierFlag;

    private String weekday;

    public Calendar(String country, String brand, String calendarCode, int year) {
        this.country = country;
        this.brand = brand;
        this.calendarCode = calendarCode;
        this.year = year;
    }

    public void setTotalWorkingDays(int totalWorkingDays) {
        this.totalWorkingDays = totalWorkingDays;
    }

    public void setTotalNonWorkingDays(int totalNonWorkingDays) {
        this.totalNonWorkingDays = totalNonWorkingDays;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYearMonthDay(LocalDate yearMonthDay) {
        this.yearMonthDay = yearMonthDay;
    }

    public void setNonWorkingDayFlag(boolean nonWorkingDayFlag) {
        this.nonWorkingDayFlag = nonWorkingDayFlag;
    }

    public void setWorkingDayNumer(int workingDayNumer) {
        this.workingDayNumer = workingDayNumer;
    }

    public void setNonWorkingDayNumer(int nonWorkingDayNumer) {
        this.nonWorkingDayNumer = nonWorkingDayNumer;
    }

    public void setNonWorkingDayCarrierFlag(boolean nonWorkingDayCarrierFlag) {
        this.nonWorkingDayCarrierFlag = nonWorkingDayCarrierFlag;
    }

    public void setWeekday(String weekday) {
        this.weekday = weekday;
    }

    public boolean isNonWorkingDayFlag() {
        return nonWorkingDayFlag;
    }

    @Override
    public String toString() {
        return "('" + country + "', '" + brand + "', '" + calendarCode + "', " + year + ", " + totalWorkingDays + ", "
                + totalNonWorkingDays + ", " + month + ", '" + this.yearMonthDay.format(DateTimeFormatter.ISO_LOCAL_DATE)
                + "', " + (nonWorkingDayFlag?1:0) + ", " + workingDayNumer + ", " + nonWorkingDayNumer + ", "
                + (nonWorkingDayCarrierFlag?1:0) + ", '" + weekday + "'),\n";
    }

}
