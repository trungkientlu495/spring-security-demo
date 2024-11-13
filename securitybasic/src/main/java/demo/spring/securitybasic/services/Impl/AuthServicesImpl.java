package demo.spring.securitybasic.services.Impl;

import demo.spring.securitybasic.config.exceptions.CustormExceptions;
import demo.spring.securitybasic.entity.Role;
import demo.spring.securitybasic.entity.User;
import demo.spring.securitybasic.payload.MessageResponse;
import demo.spring.securitybasic.payload.mapstructs.UserMapper;
import demo.spring.securitybasic.payload.request.LoginDTO;
import demo.spring.securitybasic.payload.request.UserRequest;
import demo.spring.securitybasic.repository.UserRepo;
import demo.spring.securitybasic.services.AuthServices;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class AuthServicesImpl implements AuthServices {
    private final UserRepo userRepo;
    private final AuthenticationManager authenticationManager;
    @Override
    public MessageResponse registerUser(UserRequest userRequest) {
        try{
            if(userRequest==null) throw new CustormExceptions("User is empty");
            User user = UserMapper.INSTANCE.toUserEntity(userRequest);
            user.setPassword(new BCryptPasswordEncoder().encode(userRequest.getPassword()));
            List<Role> roles = new ArrayList<>();
            Role role = new Role();
            role.setName("USER");
            roles.add(role);
            user.setRoles(roles);
            userRepo.save(user);
            return new MessageResponse("Create user success",200);
        }catch (Exception e){
            return new MessageResponse("Create user failed",400);
        }
    }

    @Override
    public MessageResponse loginUser(LoginDTO loginDTO) {
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getUsername()
                        , loginDTO.getPassword()));
        return null;
    }
}
