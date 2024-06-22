package com.micro.rating.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
//With mongodb instead of using @Entity we should use @Document
@Document("ratings")
public class Rating {
    // By Default in mongodb ids are auto generated
    @Id
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String ratingId;
    private String userId;
    private String hotelId;
    private Integer rating;
    private String feedback;
}
