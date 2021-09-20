package com.customer.service.controller;

import java.util.List;
import com.customer.service.businessdelegate.ICustomerService;
import com.customer.service.dto.CustomerDto;
import com.customer.service.response.CustomerResponse;
import com.customer.service.response.CustomersResponse;
import com.customer.service.util.CustomerValidator;
import com.customer.service.util.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "CustomerController")
@RestController
public class CustomerController {

	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	ICustomerService customerService;

	@Autowired
	CustomerValidator customerValidator;

	@ApiOperation(value = "Get list of Customers in the System ", response = ResponseEntity.class, tags = "getCustomers")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Suceess|OK"),
			@ApiResponse(code = 401, message = "not authorized!"), 
			@ApiResponse(code = 403, message = "forbidden!!!"),
			@ApiResponse(code = 404, message = "not found!!!") })

	@RequestMapping(value = "/getCustomers")
	public ResponseEntity<CustomersResponse> getCustomers()
	{

		logger.debug("getCustomers Start ,  \n for All Customers : ");

		List<CustomerDto> customerDtos = customerService.getAllCustomers();

		 CustomersResponse customersResponse = new CustomersResponse();
		 customersResponse.setCustomers(customerDtos);

		logger.debug("getCustomers End , All Customers : ", customersResponse.toString());

		return new ResponseEntity<CustomersResponse>(customersResponse, HttpStatus.OK);

	}

	@ApiOperation(value = "Get specific Customer in the System ", response = CustomerResponse.class, tags = "getCustomer")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Suceess|OK"),
			@ApiResponse(code = 401, message = "not authorized!"),
			@ApiResponse(code = 403, message = "forbidden!!!"),
			@ApiResponse(code = 404, message = "not found!!!") })

	@RequestMapping(value = "/getCustomer/{mobileNumber}")
	public ResponseEntity<CustomerResponse> getCustomer(@PathVariable(value = "mobileNumber") Long mobileNumber) {

		CustomerDto retrievedCustomerDto = customerService.getCustomer(mobileNumber);

		CustomerResponse customerResponse = new CustomerResponse();

		if (retrievedCustomerDto.getCustId() != null) {
			customerResponse.setCustomerResponse(retrievedCustomerDto);
			customerResponse.setCode(ResultCode.SUCCESS_GET_CUSTOMER.getCode());
			customerResponse.setStatus(ResultCode.SUCCESS_GET_CUSTOMER.getStatus());
			customerResponse.setMessage(ResultCode.SUCCESS_GET_CUSTOMER.getMessage());
			return new ResponseEntity<CustomerResponse>(customerResponse, HttpStatus.OK);
		} else {
			customerResponse.setCode(ResultCode.FAILURE_GET_CUSTOMER.getCode());
			customerResponse.setStatus(ResultCode.FAILURE_GET_CUSTOMER.getStatus());
			customerResponse.setMessage(ResultCode.FAILURE_GET_CUSTOMER.getMessage());
			return new ResponseEntity<CustomerResponse>(customerResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}



/*

		customerResponse.setCustomerResponse(customerDto);

		return new ResponseEntity<CustomerResponse>(customerResponse, HttpStatus.OK);

*/

		//return students.stream().filter(x -> x.getName().equalsIgnoreCase(name)).collect(Collectors.toList()).get(0);
	}

	@ApiOperation(value = "Create Customer in the System ", response = CustomerResponse.class, tags = "createCustomer")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Suceess|OK"),
			@ApiResponse(code = 401, message = "not authorized!"),
			@ApiResponse(code = 403, message = "forbidden!!!"),
			@ApiResponse(code = 404, message = "not found!!!") })
	@RequestMapping(value = "/createCustomer/")
	public ResponseEntity<CustomerResponse> createCustomer(@RequestBody CustomerDto customerDto){

		CustomerDto createdCustomer;

		CustomerResponse customerResponse = new CustomerResponse();

		createdCustomer = customerService.createCustomer(customerDto);

		customerResponse.setCustomerResponse(createdCustomer);

		return new ResponseEntity<CustomerResponse>(customerResponse, HttpStatus.CREATED);

	}


/*

	@ApiOperation(value = "Update Customer in the System ", response = CustomerResponse.class, tags = "updateCustomer")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Suceess|OK"),
			@ApiResponse(code = 401, message = "not authorized!"),
			@ApiResponse(code = 403, message = "forbidden!!!"),
			@ApiResponse(code = 404, message = "not found!!!") })
	@RequestMapping(value = "/updateCustomer/")
	public ResponseEntity<CustomerResponse> updateCustomer(@RequestBody CustomerDto customerDto){


		CustomerDto updatedCustomer;

		CustomerResponse customerResponse = new CustomerResponse();

		updatedCustomer = customerService.createCustomer(customerDto);

		customerResponse.setCustomerResponse(updatedCustomer);

		return new ResponseEntity<CustomerResponse>(customerResponse, HttpStatus.CREATED);

	}



	@ApiOperation(value = "Delete Customer in the System ", response = CustomerResponse.class, tags = "deleteCustomer")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Suceess|OK"),
			@ApiResponse(code = 401, message = "not authorized!"),
			@ApiResponse(code = 403, message = "forbidden!!!"),
			@ApiResponse(code = 404, message = "not found!!!") })
	@RequestMapping(value = "/deleteCustomer/{mobileNumber}")
	public ResponseEntity<Boolean> deleteCustomer(@PathVariable Long mobileNumber){

		Boolean result = customerService.deleteCustomer(mobileNumber);

		return new ResponseEntity<Boolean>(result, HttpStatus.OK);

	}*/
}
