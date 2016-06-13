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
@RequestMapping(path = "/teacher")
public class TeacherController {

    private static Logger logger = Logger.getLogger(LoginController.class.getName());

    @Autowired
    public UserRepository userRepository;

    @Autowired
    public CourseRepository courseRepository;

    @Autowired
    public UserService userService;

    @RequestMapping(path = "/student", method =  RequestMethod.GET)
    public String student(Authentication authentication, Model model)
    {
        String username = authentication.getName();

        User user = userService.loadUserByUsername(username);
        logger.info("the course of user:" + user.getUsername());

        model.addAttribute("title", "学生反馈");

        return "teacher/student";
    }

    @RequestMapping(path = "/motion-analysis", method =  RequestMethod.GET)
    public String motion(Authentication authentication, Model model)
    {
        String username = authentication.getName();

        User user = userService.loadUserByUsername(username);
        logger.info("the course of user:" + user.getUsername());

        model.addAttribute("title", "学生情绪分析");

        return "teacher/motion-analysis";
    }


}
