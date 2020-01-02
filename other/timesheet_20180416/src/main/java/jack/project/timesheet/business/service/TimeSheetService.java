package jack.project.timesheet.business.service;

import jack.project.timesheet.business.dao.TSDao;
import jack.project.timesheet.business.entities.TimeSheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("tSServie")
public class TimeSheetService {

    @Autowired
    private TSDao tSDao;

    public Integer AddOneTimeSheet(Date date, String activity, String type, String resource, double days, String description) {
        TimeSheet ts = new TimeSheet(date, activity, type, resource, days, description);
        Integer id = tSDao.save(ts);
        return id;
    }

    public List<TimeSheet> getAllActivities() {
        return tSDao.getAll();
    }

    public TimeSheet getTimesheetById(Integer id) {
        return tSDao.getTimesheetById(id);
    }
}
