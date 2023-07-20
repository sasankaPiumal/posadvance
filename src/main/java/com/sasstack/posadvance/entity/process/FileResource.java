package com.sasstack.posadvance.entity.process;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.sql.Blob;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class FileResource {

    @Column(columnDefinition = "LONGBLOB")
    private Blob fileName;

    @Column(columnDefinition = "LONGBLOB")
    private Blob resourceUrl;

    @Column(columnDefinition = "LONGBLOB")
    private Blob directory;

    @Column(columnDefinition = "LONGBLOB")
    private Blob hash;


}
