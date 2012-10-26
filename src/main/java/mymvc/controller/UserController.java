package mymvc.controller;

import mymvc.domain.User;
import mymvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(@RequestParam(value = "message", required = false) String message, ModelMap model) {
        User user = new User();
        model.addAttribute("user", user);
        model.addAttribute("message", message);
        return "user/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String doLogin(@ModelAttribute("user") User user, HttpSession session, ModelMap model) {
        User currentUser;
        if ((currentUser = userService.exist(user)) != null) {
            model.addAttribute("currentUser", currentUser);
            session.setAttribute("loginUser", currentUser);
            return "redirect:welcome";
        } else {
            model.addAttribute("message", "Login failed.");
            return "redirect:login";
        }
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welcome(HttpSession session, ModelMap model) {
        if (authCheck(session, model)) return "redirect:login";

        model.addAttribute("currentUser", (User) session.getAttribute("loginUser"));
        return "user/welcome";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session, ModelMap modelMap) {
        session.invalidate();
        return "redirect:login";
    }

    private boolean authCheck(HttpSession session, ModelMap model) {
        if (session.getAttribute("loginUser") == null) {
            model.addAttribute("message", "Please login first.");
            session.invalidate();
            return true;
        }
        return false;
    }

}
