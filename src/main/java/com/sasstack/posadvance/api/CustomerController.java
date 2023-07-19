package com.sasstack.posadvance.api;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/customer")
public class CustomerController {

    @PostMapping
    public String createCustomer() {
        return "Create Customer";
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
