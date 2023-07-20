package com.sasstack.posadvance.api;

import com.sasstack.posadvance.db.Database;
import com.sasstack.posadvance.dto.request.RequestCustomerDto;
import com.sasstack.posadvance.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/customers") //consumes = {MediaType.APPLICATION_JSON_VALUE}
public class CustomerController {

    @PostMapping()
    public ResponseEntity<StandardResponse> createCustomer(@RequestBody RequestCustomerDto requestCustomerDto) {
        return new ResponseEntity<>(
                new StandardResponse(201, "Customer saved",
                        Database.createCustomer(requestCustomerDto).toString()),
                HttpStatus.CREATED

        );

    }

    @PutMapping(
            params = {"id"}

    )
    public ResponseEntity<StandardResponse> updateCustomer(@RequestParam int id, @RequestBody RequestCustomerDto dto)
            throws ClassNotFoundException {
        var updatedCustomer = Database.updateCustomer(id, dto);
        return new ResponseEntity<>(
                new StandardResponse(201, "Customer updated!", updatedCustomer),
                HttpStatus.CREATED

        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StandardResponse> deleteCustomer(@PathVariable int id) {
        Database.deleteCustomer(id);
        return new ResponseEntity<>(
                new StandardResponse(204, "customer deleted!", null),
                HttpStatus.NO_CONTENT

        );
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<StandardResponse> findCustomer(@PathVariable int id) throws ClassNotFoundException {
        return new ResponseEntity<>(
                new StandardResponse(200, "Success", Database.findCustomer(id)),
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

        return new ResponseEntity<>(
                new StandardResponse(200, "Success!", Database.getAllCustomers(page,size,searchText)),
                HttpStatus.OK

        );
    }


}
