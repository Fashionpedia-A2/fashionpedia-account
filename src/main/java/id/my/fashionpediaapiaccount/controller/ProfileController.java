package id.my.fashionpediaapiaccount.controller;

import id.my.fashionpediaapiaccount.dto.UserProfileRequest;
import id.my.fashionpediaapiaccount.dto.UserProfileResponse;
import id.my.fashionpediaapiaccount.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping("/auth")
public class ProfileController {

    private static final Logger logger = Logger.getLogger(ProfileController.class.getName());

    @Autowired
    private ProfileService profileService;

    @PostMapping("/profile")
    public ResponseEntity<UserProfileResponse> getUserProfile(@RequestBody UserProfileRequest request) {
        logger.info("masuk ke get profile controller dengan email: " + request.getEmail());
        return ResponseEntity.ok(profileService.getUserProfile(request));
    }

    @PutMapping("/profile")
    public ResponseEntity<Void> setUserProfile(@RequestBody UserProfileResponse userProfileDto) {
        logger.info("masuk ke set profile controller dengan email: " + userProfileDto.getEmail());
        profileService.setUserProfile(userProfileDto);
        return ResponseEntity.ok().build();
    }
}