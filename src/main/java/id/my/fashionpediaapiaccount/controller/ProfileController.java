package id.my.fashionpediaapiaccount.controller;

import id.my.fashionpediaapiaccount.dto.UserProfileRequest;
import id.my.fashionpediaapiaccount.dto.UserProfileResponse;
import id.my.fashionpediaapiaccount.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    private static final Logger logger = Logger.getLogger(ProfileController.class.getName());

    @Autowired
    private ProfileService profileService;

    @PostMapping("/")
    public ResponseEntity<UserProfileResponse> getUserProfile(@RequestBody UserProfileRequest request) {
        return ResponseEntity.ok(profileService.getUserProfile(request));
    }

    @PutMapping("/")
    public ResponseEntity<Void> setUserProfile(@RequestBody UserProfileResponse userProfileDto) {
        profileService.setUserProfile(userProfileDto);
        return ResponseEntity.ok().build();
    }
}