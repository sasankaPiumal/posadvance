package com.sasstack.posadvance.db;

import com.sasstack.posadvance.dto.core.CustomerDto;
import com.sasstack.posadvance.dto.request.RequestCustomerDto;
import com.sasstack.posadvance.dto.response.ResponseCustomerDto;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;

public class Database {

    public static ArrayList<CustomerDto> customerTable = new ArrayList<>();

    public static ResponseCustomerDto createCustomer(RequestCustomerDto dto) {
        CustomerDto customerDto = new CustomerDto(
                new Random().nextInt(10001),
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
        customerTable.add(customerDto);

        return new ResponseCustomerDto(
                customerDto.getPublicId(),
                customerDto.getName(),
                customerDto.getAddress(),
                customerDto.getSalary(),
                customerDto.isActiveState()
        );
    }

    public static ResponseCustomerDto findCustomer(int id) throws ClassNotFoundException {
        Optional<CustomerDto> selectedCustomer = customerTable.stream().filter(e->e.getPublicId() == id).findFirst();
        if (selectedCustomer.isPresent()){

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

    @PutMapping
    public String updateCustomer() {
        return "Update Customer";
    }

    @DeleteMapping
    public String deleteCustomer() {
        return "Delete Customer";
    }

}
