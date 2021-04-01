package com.imagehoster.ImageHosterApplication.controller;
import com.imagehoster.ImageHosterApplication.model.User;
import com.imagehoster.ImageHosterApplication.model.UserProfile;
import com.imagehoster.ImageHosterApplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "/users/login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "Login/login_page";
    }
    // POST Request to "/users/login"
    @RequestMapping(method = RequestMethod.POST, value = "/login_success")
    public String loginUser(User user, HttpSession session,Model model)
    {
        User existingUser = userService.login(user);
        if(existingUser == null)
        {
            System.out.println("USER DOES NOT EXIST");
            return "redirect:/users/login";
        } else
            {
            session.setAttribute("LoggedUser", existingUser);
                model.addAttribute("isActive",true);
            System.out.println("USER FOUND!");
            return "redirect:/print_page";
        }
    }
    @RequestMapping(method = RequestMethod.GET, value = "/users/signup")
    public String registration(Model model) {
        User user = new User();
        UserProfile userProfile = new UserProfile();
        user.setUserProfile(userProfile);
        model.addAttribute("user", user);
        return "Signup/signup";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/signup")
    public String userRegistration(User user)
    {
        // Business logic to save the credentials. of the users to teh given database
        userService.registerUser(user);
        return "redirect:/users/login ";
    }
    @RequestMapping(method = RequestMethod.GET, value = "/users/logout")
    public String userLogout(HttpSession session) {
        session.invalidate();
        return "redirect:/users/login ";
    }
}

