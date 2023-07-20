package com.sasstack.posadvance.entity;

import com.sasstack.posadvance.entity.process.FileResource;
import lombok.*;

import javax.persistence.*;
import java.sql.Blob;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true,nullable = false)
    private long publicId;

    private String name;

    private String address;

    private double salary;

    @Column(columnDefinition = "TINYINT default 0")
    private boolean activeState;

    @Embedded
    private FileResource fileResource;
}
