package id.my.fashionpediaapiaccount.service;

import id.my.fashionpediaapiaccount.dto.AuthenticationRequest;
import id.my.fashionpediaapiaccount.dto.AuthenticationResponse;
import id.my.fashionpediaapiaccount.dto.RegisterRequest;
import id.my.fashionpediaapiaccount.exceptions.UserAlreadyExistException;
import id.my.fashionpediaapiaccount.model.User;
import id.my.fashionpediaapiaccount.model.UserProfile;
import id.my.fashionpediaapiaccount.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    @Override
    public AuthenticationResponse register(RegisterRequest request)  {
        var checkUser = userRepository.findByEmail(request.getEmail()).orElse(null);

        if(checkUser != null) {
            throw new UserAlreadyExistException();
        }

        var user = User.builder()
                .active(true)
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .userProfile(UserProfile.builder()
                        .userName(request.getUserName())
                        .email(request.getEmail())
                        .address(request.getAddress())
                        .phoneNumber(request.getPhoneNumber())
                        .about(request.getAbout())
                        .build())
                .build();

        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder().token(jwtToken).build();
    }

}
