package id.my.fashionpediaapiaccount.service;

import id.my.fashionpediaapiaccount.dto.AuthenticationRequest;
import id.my.fashionpediaapiaccount.dto.AuthenticationResponse;
import id.my.fashionpediaapiaccount.dto.RegisterRequest;

public interface AuthService {
    AuthenticationResponse authenticate(AuthenticationRequest request);
    AuthenticationResponse register(RegisterRequest request);
}
