package com.sasstack.posadvance.service;

import com.sasstack.posadvance.dto.request.RequestCustomerDto;
import com.sasstack.posadvance.dto.response.ResponseCustomerDto;
import com.sasstack.posadvance.dto.response.paginated.model.CustomerPaginatedDto;

public interface CustomerService {
    public ResponseCustomerDto createCustomer(RequestCustomerDto dto);

    public ResponseCustomerDto findCustomer(long id);

    public ResponseCustomerDto updateCustomer(long id, RequestCustomerDto dto);

    public void deleteCustomer(long id);

    public CustomerPaginatedDto getAllCustomers(int page, int size, String searchText);

}
 