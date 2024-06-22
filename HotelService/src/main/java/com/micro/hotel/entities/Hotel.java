package com.micro.hotel.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "hotels")
public class Hotel {

    @Id
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String hotelId;

    private String name;

    private String location;

    private String about;
}
