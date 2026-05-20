package com.projeto.ecommerce.entities;

import com.projeto.ecommerce.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserService {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name;
    @Column(unique = true)
    private String email;
    private String photo;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role roles;
    @OneToMany(mappedBy = "client")
    private List<OrderEntity> orders = new ArrayList<>();
}
