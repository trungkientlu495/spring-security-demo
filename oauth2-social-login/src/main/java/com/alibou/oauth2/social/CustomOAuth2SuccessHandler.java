package com.alibou.oauth2.social;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import java.io.IOException;
import java.util.Map;

public class CustomOAuth2SuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException {
        OAuth2AuthenticationToken authToken = (OAuth2AuthenticationToken) authentication;
        OAuth2User user = authToken.getPrincipal();
//        Map<String, Object> attributes = user.getAttributes();
//        attributes.forEach((key, value) -> System.out.println(key + ": " + value));
        // Lấy thông tin người dùng từ GitHub
        String email = user.getAttribute("email");
        String name = user.getAttribute("name");
        System.out.println("EMAILLLL "+email+" "+name);
        // Xử lý logic lưu thông tin người dùng hoặc chuyển hướng
        response.sendRedirect("/home");
    }
}
