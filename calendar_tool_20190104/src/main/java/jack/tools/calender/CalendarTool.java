package jack.tools.calender;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

/**
 * Theme:
 * <p>
 * Description:
 *
 * @author Zhengde ZHOU
 * Created on 2019-01-04
 */
public class CalendarTool {

    private static final Logger logger = LogManager.getLogger(CalendarTool.class);

    public static void main(String[] args) {
        try {
            String xlsx = "C:\\Users\\zzd16\\Desktop\\output\\Public Holidays 2019 (APAC).xlsx";
            List<Calendar> calendars = CalendarTool.generateCalendar("HK", "CA", "HK", 2019, getHolidaysFromXlsx(xlsx));
            CalendarTool.generateSql(calendars, "C:\\Users\\zzd16\\Desktop\\output");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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
            if (localDate.getDayOfWeek().ordinal() + 1 >= 6 || nonWorkingDays.contains(localDate)) {
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

    /**
     * 1. @param xlsxName 是一个真实存在的 .xlsx 文件的绝对路径
     * 2. xlsxName 文件只有一张工作表
     * 3. 假日日期必须位于工作表的第一列
     * 4. 假日日期从第二行开始，且格式与 1-Jan 相同
     * @param xlsxName
     * @return
     * @throws Exception
     */
    public static Set<LocalDate> getHolidaysFromXlsx(String xlsxName) throws Exception {
        File xlsxFile = new File(xlsxName);
        if (!xlsxFile.isFile()) {
            throw new Exception(String.format("%s 不是一个真实的文件", xlsxFile));
        }

        HashSet<LocalDate> calendars = new HashSet<>();
        final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("d-EE");

        Workbook workbook = WorkbookFactory.create(xlsxFile);
        Sheet sheet = workbook.getSheetAt(0);
        Optional<Date> dateOpt;
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            dateOpt = Optional.ofNullable(sheet.getRow(i)).map(row -> row.getCell(0)).map(Cell::getDateCellValue);
            if (dateOpt.isPresent()) {
                try {
                    LocalDateTime localDateTime = LocalDateTime.ofInstant(dateOpt.get().toInstant(), ZoneId.systemDefault());
                    calendars.add(LocalDate.ofYearDay(localDateTime.getYear(), localDateTime.getDayOfYear()));
                } catch (DateTimeParseException e) {
                    logger.info("%s 不是一个类似于 1-Jan 格式的日期值", dateOpt.get());
                }
            }
        }
        return calendars;
    }

}



