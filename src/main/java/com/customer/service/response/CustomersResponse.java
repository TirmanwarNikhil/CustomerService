package com.customer.service.response;

import com.customer.service.dto.CustomerDto;

import java.io.Serializable;
import java.util.List;

public class CustomersResponse implements Serializable {

    List<CustomerDto> customers;

    public List<CustomerDto> getCustomers() {
        return customers;
    }

    public void setCustomers(List<CustomerDto> customers) {
        this.customers = customers;
    }

    @Override
    public String toString() {
        return "CustomersResponse{" +
                "customers=" + customers +
                '}';
    }
}
