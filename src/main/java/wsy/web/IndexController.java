package wsy.web;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

    private static Logger logger = Logger.getLogger(LoginController.class.getName());

    @RequestMapping(path = "/", method =  RequestMethod.GET)
    public String index(Model model)
    {
        model.addAttribute("title", "教师教学反馈系统");
        return "index";
    }
}
