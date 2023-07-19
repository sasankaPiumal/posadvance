package com.sasstack.posadvance.api;

import com.sasstack.posadvance.db.Database;
import com.sasstack.posadvance.dto.request.RequestCustomerDto;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/customer")
public class CustomerController {

    @PostMapping()
    public String createCustomer(@RequestBody RequestCustomerDto requestCustomerDto) {
        return Database.createCustomer(requestCustomerDto).toString();

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
