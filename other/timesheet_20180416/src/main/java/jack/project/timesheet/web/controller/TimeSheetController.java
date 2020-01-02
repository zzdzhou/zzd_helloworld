package jack.project.timesheet.web.controller;

import jack.project.timesheet.business.entities.TimeSheet;
import jack.project.timesheet.business.service.TimeSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.List;

@Controller
@RequestMapping("/activity")
public class TimeSheetController {

    @Autowired
    private TimeSheetService tSService;

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/add")
    public String addOneActivityPage() {
        return "add";
    }

    @GetMapping("/add/result")
    public String addOneActivity(@RequestParam(name = "activity_date") Date date, @RequestParam(name = "activity")String activity,
                                 @RequestParam(name = "type") String type, @RequestParam(name = "resouce") String resouce,
                                 @RequestParam(name = "days") double days, @RequestParam(name = "description") String description,
                                 Model model) {
        Integer newId = tSService.AddOneTimeSheet(date, activity, type, resouce, days, description);
        model.addAttribute("ac", tSService.getTimesheetById(newId));
        return "add";
    }

    @GetMapping("/all")
    public String getAllActivities(Model model) {
        model.addAttribute("allAc", tSService.getAllActivities());
        return "all";
    }

    @GetMapping("/test")
    public String testData() {
        tSService.AddOneTimeSheet(new Date(System.currentTimeMillis()), "DSMID-10602", "support",
                "Zhengde ZHOU", 0.2, "[BEM] Creating an address using SWSE API");
        tSService.AddOneTimeSheet(new Date(System.currentTimeMillis()), "DSMID-10599", "support",
                "Zhengde ZHOU", 0.4, "[JLC][PRD] Reset password issue");
        return "home";
    }

}
