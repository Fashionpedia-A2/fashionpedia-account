package id.my.fashionpediaapiaccount.controller;

import id.my.fashionpediaapiaccount.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.logging.Logger;

@Controller
@RequestMapping(path = "/auth")
public class AuthController {

    private static final Logger logger = Logger.getLogger(AuthController.class.getName());

    @Autowired
    private AuthService authService;

    @GetMapping(path = "/login")
    public String loginPage(Model model) {
        logger.info("controller berhasil diakses");
        return "login";
    }

    @GetMapping(path = "/register")
    public String registerPage(Model model) {
        return "register";
    }

    @PostMapping(path = "/login")
    public String login(Model model,
                        @RequestParam(value = "username") String username,
                        @RequestParam(value = "password") String password) {
        if (authService.login(username, password)) {
            model.addAttribute("successful", true);
            return "login";
        }
        model.addAttribute("successful", false);
        return "login";
    }

    @PostMapping(path = "/register")
    public String register(Model model,
                        @RequestParam(value = "username") String username,
                        @RequestParam(value = "password") String password) {
        authService.register(username, password);

        return "redirect:/auth/login";
    }

}
