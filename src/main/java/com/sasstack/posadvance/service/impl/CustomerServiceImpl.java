package com.sasstack.posadvance.service.impl;

import com.sasstack.posadvance.dto.core.CustomerDto;
import com.sasstack.posadvance.dto.request.RequestCustomerDto;
import com.sasstack.posadvance.dto.response.ResponseCustomerDto;
import com.sasstack.posadvance.dto.response.paginated.model.CustomerPaginatedDto;
import com.sasstack.posadvance.entity.Customer;
import com.sasstack.posadvance.repo.CustomerRepo;
import com.sasstack.posadvance.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepo customerRepo;

    @Autowired
    public CustomerServiceImpl(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
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
        Customer customer = new Customer(
                customerDto.getId(),
                customerDto.getPublicId(),
                customerDto.getName(),
                customerDto.getAddress(),
                customerDto.getSalary(),
                customerDto.isActiveState(),
                null
        );
        customerRepo.save(customer);
        return new ResponseCustomerDto(
                customerDto.getPublicId(),
                customerDto.getName(),
                customerDto.getAddress(),
                customerDto.getSalary(),
                customerDto.isActiveState()
        );

    }

    @Override
    public ResponseCustomerDto findCustomer(long id) throws ClassNotFoundException {
        Optional<Customer> selectedCustomer = customerRepo.findByPublicId(id);
        if (selectedCustomer.isPresent()) {
            return new ResponseCustomerDto(
                    selectedCustomer.get().getPublicId(),
                    selectedCustomer.get().getName(),
                    selectedCustomer.get().getAddress(),
                    selectedCustomer.get().getSalary(),
                    selectedCustomer.get().isActiveState()
            );
        }
        throw new ClassNotFoundException();
    }

    @Override
    public ResponseCustomerDto updateCustomer(long id, RequestCustomerDto dto) throws ClassNotFoundException {
        Optional<Customer> selectedCustomer = customerRepo.findByPublicId(id);
        if (selectedCustomer.isPresent()) {
            selectedCustomer.get().setName(dto.getName());
            selectedCustomer.get().setAddress(dto.getAddress());
            selectedCustomer.get().setSalary(dto.getSalary());

            customerRepo.save(selectedCustomer.get());

            return new ResponseCustomerDto(
                    selectedCustomer.get().getPublicId(),
                    selectedCustomer.get().getName(),
                    selectedCustomer.get().getAddress(),
                    selectedCustomer.get().getSalary(),
                    selectedCustomer.get().isActiveState()

            );
        } else {
            throw new ClassNotFoundException();
        }

    }

    @Override
    public void deleteCustomer(long id) {
        customerRepo.deleteByPublicIdIs(id);
    }

    @Override
    public CustomerPaginatedDto getAllCustomers(int page, int size, String searchText) {
//        Page<Customer> customers = customerRepo.findAll(PageRequest.of(page, size));
        Page<Customer> customers = customerRepo.searchAllByAddressOrName(searchText,PageRequest.of(page, size));
        List<ResponseCustomerDto> list = new ArrayList<>();
//        long recordCount = customerRepo.count();
        long finalCount = customerRepo.countDataWithSearchText(searchText);
        for (Customer d : customers) {
            list.add(new ResponseCustomerDto(
                    d.getPublicId(),
                    d.getName(),
                    d.getAddress(),
                    d.getSalary(),
                    d.isActiveState()
            ));
        }

        return new CustomerPaginatedDto(finalCount, list);
    }
}
