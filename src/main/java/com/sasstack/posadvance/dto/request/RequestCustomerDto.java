package com.sasstack.posadvance.dto.request;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class RequestCustomerDto {

    private String name;
    private String address;
    private double salary;
}
