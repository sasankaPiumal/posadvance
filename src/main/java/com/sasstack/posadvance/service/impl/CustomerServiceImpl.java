package com.sasstack.posadvance.service.impl;

import com.sasstack.posadvance.dto.request.RequestCustomerDto;
import com.sasstack.posadvance.dto.response.ResponseCustomerDto;
import com.sasstack.posadvance.dto.response.paginated.model.CustomerPaginatedDto;
import com.sasstack.posadvance.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {
    @Override
    public ResponseCustomerDto createCustomer(RequestCustomerDto dto) {
        return null;
    }

    @Override
    public ResponseCustomerDto findCustomer(long id) {
        return null;
    }

    @Override
    public ResponseCustomerDto updateCustomer(long id, RequestCustomerDto dto) {
        return null;
    }

    @Override
    public void deleteCustomer(long id) {

    }

    @Override
    public CustomerPaginatedDto getAllCustomers(int page, int size, String searchText) {
        return null;
    }
}
