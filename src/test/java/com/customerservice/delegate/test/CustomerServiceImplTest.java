package com.customerservice.delegate.test;

import com.customer.service.businessdelegate.impl.CustomerServiceImpl;
import com.customer.service.dto.CustomerDto;
import com.customer.service.mapper.ModelToDtoMapper;
import com.customer.service.model.Customer;
import com.customer.service.repository.CustomerRepository;
import io.swagger.models.Model;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

//@RunWith(SpringRunner.class)
@RunWith(PowerMockRunner.class)
@PrepareForTest(ModelToDtoMapper.class)
public class CustomerServiceImplTest {

    @InjectMocks
    private CustomerServiceImpl customerService;

    @Mock
    private CustomerRepository customerRepository;

    private CustomerDto customerDto;

    private Customer customer;

    private List<Customer> customers = new ArrayList<Customer>();

    List<CustomerDto> dtos = new ArrayList<CustomerDto>();

    @Before
    public void setUp() {
        customer = new Customer(101, "NIKHIL", "TIRMANWAR", 9765922341L);
        customerDto = new CustomerDto(101, "NIKHIL", "TIRMANWAR", 9765922341L);
        customers.add(new Customer(102, "SUHAS", "LONARKAR", 9765922342l));
        customers.add(new Customer(103, "ANIL", "DEVARITNI", 9765922343l));
        customers.add(new Customer(104, "JOHN", "CARTON", 9765922344l));
    }

    @Test
   public void testFindCustomer() {

        when(customerRepository.findByMobileNumber(Mockito.anyLong())).thenReturn(customer);


        PowerMockito.mockStatic(ModelToDtoMapper.class);

        PowerMockito.when(ModelToDtoMapper.customerToCustomerDto(customer)).thenReturn(customerDto);

        CustomerDto response = customerService.getCustomer(9765922341L);

        Integer testCustId = 101;

        assertEquals(testCustId, response.getCustId());

        assertNotNull(response);


   }

}
