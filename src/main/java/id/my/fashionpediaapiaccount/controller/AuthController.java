package id.my.fashionpediaapiaccount.controller;

import id.my.fashionpediaapiaccount.dto.AuthenticationRequest;
import id.my.fashionpediaapiaccount.dto.AuthenticationResponse;
import id.my.fashionpediaapiaccount.dto.RegisterRequest;
import id.my.fashionpediaapiaccount.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.logging.Logger;

@CrossOrigin(origins = "*", allowedMethods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/auth")
public class AuthController {

    private static final Logger logger = Logger.getLogger(AuthController.class.getName());

    @Autowired
    private AuthService authService;

    @CrossOrigin
    @PostMapping(path = "/login")
    public ResponseEntity<AuthenticationResponse> login (
            @RequestBody AuthenticationRequest request
    ) {
        logger.info("masuk ke login controller dengan email: " + request.getEmail());
        return ResponseEntity.ok(authService.authenticate(request));
    }

    @CrossOrigin
    @PostMapping(path = "/register")
    public ResponseEntity<AuthenticationResponse> register (
            @RequestBody RegisterRequest request
    ) {
        logger.info("masuk ke register controller dengan email: " + request.getEmail());
        return ResponseEntity.ok(authService.register(request));
    }


}
