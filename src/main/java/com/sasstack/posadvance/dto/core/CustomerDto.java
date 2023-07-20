package com.sasstack.posadvance.dto.core;

import lombok.*;

import java.sql.Blob;

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

    //=========================
    private Blob fileName;

    private Blob resourceUrl;

    private Blob directory;

    private Blob hash;
    //=========================
}
