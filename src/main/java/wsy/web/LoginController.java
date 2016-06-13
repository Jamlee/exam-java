package wsy.web;


import org.apache.log4j.Logger;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    private static Logger logger = Logger.getLogger(LoginController.class.getName());

    @RequestMapping(path = "/login", method =  RequestMethod.GET)
    public String login()
    {
        return "login";
    }
}
