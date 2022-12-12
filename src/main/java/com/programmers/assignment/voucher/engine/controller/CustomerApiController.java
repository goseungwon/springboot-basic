package com.programmers.assignment.voucher.engine.controller;

import com.programmers.assignment.voucher.common.response.CommonResponse;
import com.programmers.assignment.voucher.engine.model.Customer;
import com.programmers.assignment.voucher.engine.service.CustomerService;
import com.programmers.assignment.voucher.util.dto.CustomerDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class CustomerApiController {

    private final CustomerService service;

    public CustomerApiController(CustomerService service) {
        this.service = service;
    }

    @GetMapping("/api/customers")
    public CommonResponse<List<Customer>> customerList() {
        var customers = service.findCustomers();
        return new CommonResponse<>(customers);
    }

    @GetMapping("/api/customers/{customerUuid}")
    public CommonResponse<Customer> customerDetails(@PathVariable UUID customerUuid) {
        var customer = service.findCustomerByUuid(customerUuid);
        return new CommonResponse<>(customer);
    }

    @PostMapping("/api/customers")
    public CommonResponse<Customer> createCustomer(CustomerDto customerDto) {
        var customer = service.createCustomer(customerDto);
        return new CommonResponse<>(customer);
    }
}
