package com.customer.service.businessdelegate.impl;

import com.customer.service.businessdelegate.ICustomerService;
import com.customer.service.dto.CustomerDto;
import com.customer.service.mapper.ModelToDtoMapper;
import com.customer.service.model.Customer;
import com.customer.service.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<CustomerDto> getAllCustomers() {


        Customer customer1 = new Customer( 0 , "NIKHIL","TIRMANWAR",9765922341L);
        Customer customer2 = new Customer( 0 , "SUHAS","LONARKAR",9765922342L);
        Customer customer3 = new Customer( 0 , "ANIL","DEVARINTI",9765922343L);

        customerRepository.save(customer1);
        customerRepository.save(customer2);
        customerRepository.save(customer3);

       List<Customer> customers =  customerRepository.findAll();

       List<CustomerDto> customerDtos =  ModelToDtoMapper.customersToCustomersDto(customers);

       System.out.println("CUSTOMERS :" +customerDtos);

       return customerDtos;
    }

    @Override
    public CustomerDto getCustomer(Long mobileNumber) {

        Customer customer = customerRepository.findByMobileNumber(mobileNumber);

        CustomerDto dto = ModelToDtoMapper.customerToCustomerDto(customer);

        return dto;
    }

    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {

        CustomerDto dto = new CustomerDto();
        Customer customerModel = ModelToDtoMapper.customerDtoToCustomer(customerDto);
        Customer customer = customerRepository.save(customerModel);

        dto = ModelToDtoMapper.customerToCustomerDto(customer);

        return dto;
    }

    @Override
    public CustomerDto updateCustomer(CustomerDto customerDto) {

        CustomerDto dto = new CustomerDto();
        Customer customerModel = ModelToDtoMapper.customerDtoToCustomer(customerDto);
        Customer customer = customerRepository.save(customerModel);

        dto = ModelToDtoMapper.customerToCustomerDto(customer);

        return dto;
    }

    @Override
    public Boolean deleteCustomer(Long mobileNumber) {
        customerRepository.deleteByMobileNumber(mobileNumber);
        Boolean result = customerRepository.existsByMobileNumber(mobileNumber);
        return result;
    }
}

