package demo.spring.securitybasic.payload;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class RequestHandler {
    public static final String SUCCESS = "OK";
    public static final String FAIL = "FAIL";
    public static ResponseEntity<Object> generate(HttpStatus status,String message,Object data) {
        Map<String, Object> map = new HashMap<>();
        map.put("status", status.value());
        map.put("data", data);
        map.put("message", message);
        return new ResponseEntity<>(map,status);
    }
}
