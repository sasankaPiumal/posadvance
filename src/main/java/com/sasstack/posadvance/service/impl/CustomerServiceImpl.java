package com.sasstack.posadvance.service.impl;

import com.sasstack.posadvance.dto.core.CustomerDto;
import com.sasstack.posadvance.dto.request.RequestCustomerDto;
import com.sasstack.posadvance.dto.response.ResponseCustomerDto;
import com.sasstack.posadvance.dto.response.paginated.model.CustomerPaginatedDto;
import com.sasstack.posadvance.entity.Customer;
import com.sasstack.posadvance.exception.EntryNotFoundException;
import com.sasstack.posadvance.repo.CustomerRepo;
import com.sasstack.posadvance.service.CustomerService;
import com.sasstack.posadvance.util.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepo customerRepo;

    private final CustomerMapper customerMapper;

    @Autowired
    public CustomerServiceImpl(CustomerRepo customerRepo, CustomerMapper customerMapper) {
        this.customerRepo = customerRepo;
        this.customerMapper = customerMapper;
    }


    @Override
    public ResponseCustomerDto createCustomer(RequestCustomerDto dto) {
        CustomerDto customerDto = new CustomerDto(
                0,
                new Random().nextInt(10001),
                dto.getName(),
                dto.getAddress(),
                dto.getSalary(),
                true,
                null,
                null,
                null,
                null
        );
//        Customer customer = new Customer(
//                customerDto.getId(),
//                customerDto.getPublicId(),
//                customerDto.getName(),
//                customerDto.getAddress(),
//                customerDto.getSalary(),
//                customerDto.isActiveState(),
//                null
//        );

        Customer customer = customerMapper.toCustomer(customerDto);
        customerRepo.save(customer);
        return customerMapper.toResponseCustomerDto(customer);
    }

    @Override
    public ResponseCustomerDto findCustomer(long id) {
        Optional<Customer> selectedCustomer = customerRepo.findByPublicId(id);
        if (selectedCustomer.isPresent()) {
            return customerMapper.toResponseCustomerDto(selectedCustomer.get());
        }
        throw new EntryNotFoundException("Not Found!");
    }

    @Override
    public ResponseCustomerDto updateCustomer(long id, RequestCustomerDto dto) {
        Optional<Customer> selectedCustomer = customerRepo.findByPublicId(id);
        if (selectedCustomer.isPresent()) {
            selectedCustomer.get().setName(dto.getName());
            selectedCustomer.get().setAddress(dto.getAddress());
            selectedCustomer.get().setSalary(dto.getSalary());

            customerRepo.save(selectedCustomer.get());
            return customerMapper.toResponseCustomerDto(selectedCustomer.get());
        } else {
            throw new EntryNotFoundException("Not found!");
        }

    }

    @Override
    public void deleteCustomer(long id) {
        customerRepo.deleteByPublicIdIs(id);
    }

    @Override
    public CustomerPaginatedDto getAllCustomers(int page, int size, String searchText) {
        Page<Customer> customers = customerRepo.searchAllByAddressAndName(searchText, PageRequest.of(page, size));
        List<ResponseCustomerDto> customerDtoList = customerMapper.toResponseCustomerDtoList(customers);          //new ArrayList<>();
        long responseCount = customerRepo.countDataBySearchText(searchText);
        for (Customer c : customers) {
            customerDtoList.add(new ResponseCustomerDto(
                    c.getPublicId(),
                    c.getName(),
                    c.getAddress(),
                    c.getSalary(),
                    c.isActiveState()
            ));
        }
        return new CustomerPaginatedDto(responseCount, customerDtoList);
    }
}
