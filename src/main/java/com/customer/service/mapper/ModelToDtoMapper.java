package com.customer.service.mapper;

import com.customer.service.dto.CustomerDto;
import com.customer.service.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class ModelToDtoMapper {


    public static List<CustomerDto> customersToCustomersDto(List<Customer> customers) {

        List<CustomerDto> dtos = new ArrayList<>();

        if (null != customers) {

            for (Customer customer : customers) {

                CustomerDto dto = new CustomerDto();
                dto.setCustId(customer.getCustId());
                dto.setCustFName(customer.getCustFName());
                dto.setCustLname(customer.getCustLName());
                dto.setMobileNumber(customer.getMobileNumber());
                dtos.add(dto);
            }

        }
        return dtos;
    }


    public static CustomerDto customerToCustomerDto(Customer customer) {

        CustomerDto dto = new CustomerDto();
        if (null != customer) {
            dto.setCustId(customer.getCustId());
            dto.setCustFName(customer.getCustFName());
            dto.setCustLname(customer.getCustLName());
            dto.setMobileNumber(customer.getMobileNumber());

        }
        return dto;
    }

    public static Customer customerDtoToCustomer(CustomerDto customerDto) {

        Customer customer = new Customer();

        if(null != customerDto){
            customer.setCustId(0);
            customer.setCustFName(customerDto.getCustFName());
            customer.setCustLname(customerDto.getCustLname());
            customer.setMobileNumber(customerDto.getMobileNumber());
        }
         return  customer;
    }
}