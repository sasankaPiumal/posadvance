package com.sasstack.posadvance.util;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class StandardResponse {
    private int code;
    private String message;
    private Object data;
}
