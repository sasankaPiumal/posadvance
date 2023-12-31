package com.sasstack.posadvance.dto.response;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ResponseCustomerDto {

    private long publicId;

    private String name;

    private String address;

    private double salary;

    private boolean activeState;

}
