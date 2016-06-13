package wsy.web;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import wsy.model.Course;
import wsy.model.StudentCourse;
import wsy.model.User;
import wsy.repository.CourseRepository;
import wsy.repository.UserRepository;
import wsy.service.UserService;

import java.util.Collection;

@Controller
@RequestMapping(path = "/student")
public class StudentController {

    private static Logger logger = Logger.getLogger(LoginController.class.getName());

    @Autowired
    public UserRepository userRepository;

    @Autowired
    public CourseRepository courseRepository;

    @Autowired
    public UserService userService;

    @RequestMapping(path = "/course", method =  RequestMethod.GET)
    public String index(Authentication authentication, Model model)
    {
        String username = authentication.getName();

        User user = userService.loadUserByUsername(username);
        logger.info("the course of user:" + user.getUsername());

        model.addAttribute("title", "我的课程");

        Collection<StudentCourse> studentCourses;
        try {
           studentCourses = user.getStudentProfile().getStudentCourses();
        } catch (NullPointerException e) {
            studentCourses = null;
        }
        model.addAttribute("courses", studentCourses);

        return "student/course";
    }

    @RequestMapping(path = "/choose-course", method =  RequestMethod.GET)
    public String choose(Authentication authentication, Model model)
    {
        String username = authentication.getName();
        User user = userService.loadUserByUsername(username);

        model.addAttribute("title", "选择课程");

        Collection<Course> courses;

        courses = courseRepository.findAll();
        model.addAttribute("courses", courses);

        return "student/choose-course";
    }


}
