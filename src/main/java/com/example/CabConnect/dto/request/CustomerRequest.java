package com.example.CabConnect.dto.request;

import com.example.CabConnect.Enum.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerRequest {

    private String name;

    private int age;

    private String emailId;

    private Gender gender;
}
