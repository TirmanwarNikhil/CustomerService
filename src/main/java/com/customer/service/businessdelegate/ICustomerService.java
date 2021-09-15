package com.customer.service.businessdelegate;

import com.customer.service.dto.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICustomerService {

   List<CustomerDto> getAllCustomers();
   CustomerDto getCustomer(Long mobileNumber);
   CustomerDto createCustomer(CustomerDto customerDto);
   CustomerDto updateCustomer(CustomerDto customerDto);

   Boolean deleteCustomer(Long mobileNumber);
}
