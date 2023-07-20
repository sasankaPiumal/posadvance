package com.sasstack.posadvance.dto.response.paginated.model;

import com.sasstack.posadvance.dto.response.ResponseCustomerDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CustomerPaginatedDto {

    private long dataCount;

    private List<ResponseCustomerDto> list;
}
