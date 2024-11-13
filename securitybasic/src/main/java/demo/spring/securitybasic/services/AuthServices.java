package demo.spring.securitybasic.services;

import demo.spring.securitybasic.payload.MessageResponse;
import demo.spring.securitybasic.payload.request.LoginDTO;
import demo.spring.securitybasic.payload.request.UserRequest;

public interface AuthServices {
    MessageResponse registerUser(UserRequest userRequest);

    MessageResponse loginUser(LoginDTO loginDTO);
}
