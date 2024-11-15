package sg.edu.nus.iss.vttp_day12_lecture.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sg.edu.nus.iss.vttp_day12_lecture.model.Student;

@Controller
@RequestMapping("/studentlist")
public class StudentController {

    List<Student> students = new ArrayList<>();
    

    @RequestMapping(path = {"", "/allStudents"}, method=RequestMethod.GET)
    public String studentListing(Model model) throws ParseException {

        // convert a date string to epoch (long)
        String dob = "18 Dec 1975 10:25:00.000 SGT";
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy HH:mm:ss.SSS zzz");
        Date dDob = sdf.parse(dob);
        Long epochDob = dDob.getTime();

        Student s1 = new Student(001, "Singapore", "SG", epochDob, "NUSISS@email.com", "123 NUS ISS CAMPUS");
        students.add(s1);
        Student s2 = new Student(002, "Philippines", "PH", epochDob, "NTU@email.com", "456 NTU CAMPUS");
        students.add(s2);
        Student s3 = new Student(003, "Indonesia", "ID", epochDob, "SIM@email.com", "999 SIM GE CAMPUS");
        students.add(s3);


        //For lits of students
        model.addAttribute("list", students);

        //For time accessed
        model.addAttribute("currTime", (new Date()).toString());

        //For greeting
        Calendar cal = Calendar.getInstance();
        model.addAttribute("currHour", cal.get(Calendar.HOUR_OF_DAY));

        return "studentlist";
    }
}