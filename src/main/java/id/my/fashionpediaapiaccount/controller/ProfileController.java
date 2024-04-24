package id.my.fashionpediaapiaccount.controller;

import id.my.fashionpediaapiaccount.model.UserProfile;
import id.my.fashionpediaapiaccount.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.support.NullValue;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.logging.Logger;

@Controller
@RequestMapping(path = "/profile")
public class ProfileController {

    private static final Logger logger = Logger.getLogger(ProfileController.class.getName());

    @Autowired
    private ProfileService profileService;

    @GetMapping(path = "/view")
    public String profilePage(Model model) {
        return "profile";
    }

    @PostMapping(path = "/view")
    public String view(Model model,
                        @RequestParam(value = "username") String username) {
        UserProfile userProfile = profileService.get(username);
        model.addAttribute("successful", false);
        return "profile";
    }

    @PostMapping(path = "/edit")
    public String edit(Model model,
                        @RequestParam(value = "username") String username,
                        @RequestParam(value = "phoneNumber") String phoneNumber,
                        @RequestParam(value = "address") String address,
                        @RequestParam(value = "about") String about) {
        profileService.set(phoneNumber, about, address);

        return "redirect:/profile/view";
    }

}
