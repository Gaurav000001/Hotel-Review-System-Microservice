package com.micro.user.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.*;

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
    @Size(min = 10, max = 10, message = "Phone Number should be of 10 digits")
    private String phone;

    @Transient
    private List<Rating> ratings;
}
