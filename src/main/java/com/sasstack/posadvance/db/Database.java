package com.sasstack.posadvance.db;

import com.sasstack.posadvance.dto.core.CustomerDto;
import com.sasstack.posadvance.dto.request.RequestCustomerDto;
import com.sasstack.posadvance.dto.response.ResponseCustomerDto;
import com.sasstack.posadvance.dto.response.paginated.model.CustomerPaginatedDto;
import com.sasstack.posadvance.util.StandardResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.ArrayList;
import java.util.List;
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
        Optional<CustomerDto> selectedCustomer = customerTable.stream().filter(e -> e.getPublicId() == id).findFirst();
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

    @PutMapping
    public static ResponseCustomerDto updateCustomer(int id, RequestCustomerDto dto) throws ClassNotFoundException {
        Optional<CustomerDto> selectedCust = customerTable.stream().filter(e -> e.getPublicId() == id).findFirst();
        if (selectedCust.isPresent()) {
            selectedCust.get().setName(dto.getName());
            selectedCust.get().setAddress(dto.getAddress());
            selectedCust.get().setSalary(dto.getSalary());

            return new ResponseCustomerDto(
                    selectedCust.get().getPublicId(),
                    selectedCust.get().getName(),
                    selectedCust.get().getAddress(),
                    selectedCust.get().getSalary(),
                    selectedCust.get().isActiveState()
            );

        }
        throw new ClassNotFoundException();


    }

    @DeleteMapping
    public static void deleteCustomer(int id) {
        Optional<CustomerDto> selected = customerTable.stream().filter(e -> e.getPublicId() == id).findFirst();
        if (selected.isPresent()) {
            customerTable.remove(selected.get());
            return;
        }
    }

    //---------------------------------------
    public static CustomerPaginatedDto getAllCustomers(int page,int size,String searchText){
        List<ResponseCustomerDto> list = new ArrayList<>();
        for (CustomerDto d: customerTable) {
            list.add(new ResponseCustomerDto(
                    d.getPublicId(),
                    d.getName(),
                    d.getAddress(),
                    d.getSalary(),
                    d.isActiveState()
            ));
        }
        return new CustomerPaginatedDto(customerTable.size(), list);
    }

}
