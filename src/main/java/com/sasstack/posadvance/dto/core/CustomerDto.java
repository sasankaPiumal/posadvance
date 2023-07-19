package com.sasstack.posadvance.dto.core;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {


    private long id;

    private long publicId;

    private String name;

    private String address;

    private double salary;

    private boolean activeState;
}
