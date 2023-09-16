package com.micro.user.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String userId;

    private String name;

    @Email(message = "Email not valid")
    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String phone;

    @Transient
    private List<Rating> ratings = new ArrayList<>();
}
