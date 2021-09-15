package com.customer.service.response;

import com.customer.service.dto.CustomerDto;

import java.io.Serializable;

public class CustomerResponse extends BaseResponse implements Serializable {

    private CustomerDto customerResponse;

    public CustomerDto getCustomerResponse() {
        return customerResponse;
    }

    public void setCustomerResponse(CustomerDto customerResponse) {
        this.customerResponse = customerResponse;
    }

    @Override
    public String toString() {
        return "CustomerResponse{" +
                "customerResponse=" + customerResponse +
                '}';
    }
}
