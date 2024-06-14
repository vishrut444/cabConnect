package com.example.CabConnect.dto.response;

import jakarta.persistence.Column;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CustomerResponse {

    private String name;

    private int age;

    private String emailId;
}
