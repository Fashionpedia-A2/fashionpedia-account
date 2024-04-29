package id.my.fashionpediaapiaccount.service;

import id.my.fashionpediaapiaccount.model.UserProfile;
import id.my.fashionpediaapiaccount.dto.UserProfileRequest;
import id.my.fashionpediaapiaccount.dto.UserProfileResponse;

public interface ProfileService {
    UserProfileResponse getUserProfile(UserProfileRequest request);
    void setUserProfile(UserProfileResponse userProfileDto);
}
