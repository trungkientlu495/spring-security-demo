package demo.spring.securitybasic.payload.request;

import lombok.Data;

@Data
public class LoginDTO {
    private String username;
    private String password;
}
