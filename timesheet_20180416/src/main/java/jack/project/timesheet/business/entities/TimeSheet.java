package jack.project.timesheet.business.entities;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "timesheet")
@Table(name = "timesheet")
public class TimeSheet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Date date;

    private String activity;

    private String type;

    private String resource;

    private double days;

    private String description;

    public TimeSheet() {
    }

    public TimeSheet(Date date, String activity, String type, String resource, double days, String description) {
        this.date = date;
        this.activity = activity;
        this.type = type;
        this.resource = resource;
        this.days = days;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public double getDays() {
        return days;
    }

    public void setDays(double days) {
        this.days = days;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
