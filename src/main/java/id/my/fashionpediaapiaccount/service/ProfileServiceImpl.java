package id.my.fashionpediaapiaccount.service;

import id.my.fashionpediaapiaccount.controller.ProfileController;
import id.my.fashionpediaapiaccount.model.UserProfile;
import id.my.fashionpediaapiaccount.dto.UserProfileResponse;
import id.my.fashionpediaapiaccount.dto.UserProfileRequest;
import id.my.fashionpediaapiaccount.exceptions.NoUserProfileExistException;
import id.my.fashionpediaapiaccount.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import id.my.fashionpediaapiaccount.repository.UserProfileRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {

    private final UserProfileRepository userProfileRepository;

    private static final Logger logger = Logger.getLogger(ProfileServiceImpl.class.getName());

    @Override
    public UserProfileResponse getUserProfile(UserProfileRequest request) {
        logger.info("masuk ke get profile service dengan email: " + request.getEmail());

        Optional<UserProfile> userProfileOptional = userProfileRepository.findByEmail(request.getEmail());
        UserProfile userProfile = userProfileOptional.orElse(null);
        if (userProfile == null) {
            throw new NoUserProfileExistException();
        }

        return UserProfileResponse.builder()
                .id(userProfile.getId())
                .cartId(userProfile.getCartId())
                .userName(userProfile.getUserName())
                .email(userProfile.getEmail())
                .address(userProfile.getAddress())
                .phoneNumber(userProfile.getPhoneNumber())
                .about(userProfile.getAbout())
                .build();
    }

    @Override
    public void setUserProfile(UserProfileResponse userProfileDto) {
        Optional<UserProfile> userProfileOptional = userProfileRepository.findByEmail(userProfileDto.getEmail());
        UserProfile userProfile = userProfileOptional.orElse(null);
        if (userProfile == null) {
            throw new NoUserProfileExistException();
        }

        userProfile.setUserName(userProfileDto.getUserName());
        userProfile.setEmail(userProfileDto.getEmail());
        userProfile.setAddress(userProfileDto.getAddress());
        userProfile.setPhoneNumber(userProfileDto.getPhoneNumber());
        userProfile.setAbout(userProfileDto.getAbout());

        userProfileRepository.save(userProfile);
    }
}