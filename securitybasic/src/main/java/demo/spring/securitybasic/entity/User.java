package demo.spring.securitybasic.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_role",  // Bảng trung gian
            joinColumns = @JoinColumn(name = "user_id"),  // Khóa ngoại tới bảng User
            inverseJoinColumns = @JoinColumn(name = "role_id")  // Khóa ngoại tới bảng Role
    )
    private List<Role> roles;
}
