package demo.spring.securitybasic.controller;

import demo.spring.securitybasic.payload.RequestHandler;
import demo.spring.securitybasic.payload.request.LoginDTO;
import demo.spring.securitybasic.payload.request.UserRequest;
import demo.spring.securitybasic.services.Impl.AuthServicesImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@AllArgsConstructor
public class AuthController {
    private final AuthServicesImpl authServices;
    @PostMapping("/register")
    public ResponseEntity<Object> registerUser(@RequestBody UserRequest userRequest) {
        return RequestHandler.generate(HttpStatus.OK,RequestHandler.SUCCESS,authServices.registerUser(userRequest));
    }

    @PostMapping("/login")
    public ResponseEntity<Object> loginUser(@RequestBody LoginDTO loginDTO) {
        return RequestHandler.generate(HttpStatus.OK,RequestHandler.SUCCESS,authServices.loginUser(loginDTO));
    }
}
