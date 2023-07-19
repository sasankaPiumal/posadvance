package com.sasstack.posadvance.api;

import com.sasstack.posadvance.db.Database;
import com.sasstack.posadvance.dto.request.RequestCustomerDto;
import com.sasstack.posadvance.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/customer", consumes = {MediaType.APPLICATION_JSON_VALUE})
public class CustomerController {

    @PostMapping()
    public ResponseEntity<StandardResponse> createCustomer(@RequestBody RequestCustomerDto requestCustomerDto) {
        return new ResponseEntity<>(
                new StandardResponse(201, "Customer saved",
                        Database.createCustomer(requestCustomerDto).toString()),
                HttpStatus.CREATED

        );

    }

    @PutMapping
    public String updateCustomer() {
        return "Update Customer";
    }

    @DeleteMapping
    public String deleteCustomer() {
        return "Delete Customer";
    }

    @GetMapping
    public String findCustomer() {
        return "Find Customer";
    }

    @GetMapping("/all")
    public String getAllCustomers() {
        return "Find All Customers";
    }


}
