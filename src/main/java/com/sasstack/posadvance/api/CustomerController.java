package com.sasstack.posadvance.api;

import com.sasstack.posadvance.dto.request.RequestCustomerDto;
import com.sasstack.posadvance.service.CustomerService;
import com.sasstack.posadvance.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/v1/customers") //consumes = {MediaType.APPLICATION_JSON_VALUE}
public class   CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @PostMapping()
    public ResponseEntity<StandardResponse> createCustomer(@RequestBody RequestCustomerDto requestCustomerDto) {
        var createdCustomer = customerService.createCustomer(requestCustomerDto);
        return new ResponseEntity<>(
                new StandardResponse(201, "Customer saved",
                        createdCustomer),
                HttpStatus.CREATED

        );

    }

    @PutMapping(
            params = {"id"}
    )
    public ResponseEntity<StandardResponse> updateCustomer(@RequestParam int id, @RequestBody RequestCustomerDto dto)
            {
        var updatedCustomer = customerService.updateCustomer(id, dto);
        return new ResponseEntity<>(
                new StandardResponse(201, "Customer updated!", updatedCustomer),
                HttpStatus.CREATED

        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StandardResponse> deleteCustomer(@PathVariable long id) {
        customerService.deleteCustomer(id);
        return new ResponseEntity<>(
                new StandardResponse(204, "customer deleted!", null),
                HttpStatus.NO_CONTENT

        );
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<StandardResponse> findCustomer(@PathVariable long id) {
        return new ResponseEntity<>(
                new StandardResponse(200, "Success!", customerService.findCustomer(id)),
                HttpStatus.OK
        );
    }

    @GetMapping(
            value = "/all",
            params = {"page", "size", "searchText"}
    )
    public ResponseEntity<StandardResponse> getAllCustomers(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam String searchText) {

        var allCustomers = customerService.getAllCustomers(page, size, searchText);
        return new ResponseEntity<>(
                new StandardResponse(200, "Success!", allCustomers),
                HttpStatus.OK

        );
    }


}
