package com.sasstack.posadvance.util.mapper;

import com.sasstack.posadvance.dto.core.CustomerDto;
import com.sasstack.posadvance.dto.response.ResponseCustomerDto;
import com.sasstack.posadvance.entity.Customer;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    Customer toCustomer(CustomerDto dto);

    ResponseCustomerDto toResponseCustomerDto(Customer customer);

    List<ResponseCustomerDto> toResponseCustomerDtoList(Page<Customer> page);

}
