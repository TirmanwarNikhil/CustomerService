package com.customer.service.util;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.customer.service.dto.CustomerDto;
import com.customer.service.exception.CustomerNotFoundException;
import com.customer.service.exception.MobileNumberInvalidException;
import com.customer.service.exception.ValidationErrorCode;
import com.customer.service.exception.ValidationException;
import com.customer.service.model.Customer;
import com.customer.service.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerValidator {

        private static final Logger logger = LoggerFactory.getLogger(CustomerValidator.class);

        @Autowired
        private CustomerRepository customerRepository;

        /**
         * Method to validate Customer Request
         *
         * @param dto
         * @return
         */
        public boolean validateCustomerRequest(CustomerDto dto) {

            logger.debug("validateCustomerRequest Start ,  \n for request : ", dto);

            boolean isValidCustomerRequest = false;

            boolean isValidFirstName = validateString(dto.getCustFName());
            boolean isValidLastName = validateString(dto.getCustFName());
            boolean isValidMobileNumber = validateMobileNumber(dto.getMobileNumber());
            boolean isUniqueRequest = uniqueRequestCheck(dto);

            if (isValidFirstName && isValidLastName &&  isValidMobileNumber && !isUniqueRequest) {
                isValidCustomerRequest = true;
            }

            logger.debug("validateCustomerRequest End ,  \n with result : ", isValidCustomerRequest);
            return isValidCustomerRequest;

        }

        private boolean uniqueRequestCheck(CustomerDto dto) {

            Customer customer = customerRepository.findByMobileNumber(dto.getMobileNumber());
            if (customer != null) {
                return true;
            }
            return false;
        }

        /**
         * Method to validate Customer Update Request
         *
         * @param dto
         * @return
         */
        public boolean validateCustomerUpdateRequest(CustomerDto dto) {

            logger.debug("validateCustomerUpdateRequest Start ,  \n for request : ", dto);

            boolean isValidCustomerRequest = false;

            boolean isValidFirstName = validateString(dto.getCustFName());
            boolean isValidLastName = validateString(dto.getCustLname());
            boolean isValidMobileNumber = validateMobileNumber(dto.getMobileNumber());
            boolean isMobileNumberExists = false;
            Customer customer = new Customer();

            if(isValidMobileNumber) {
                customer = customerRepository.findByMobileNumber(dto.getMobileNumber());
                if(customer != null) {
                    isMobileNumberExists = true;
                }else {
                    ResultCode error = ResultCode.INVALID_CUSTOMER_PROFILE;
                    throw new CustomerNotFoundException(error.getCode(), error.getStatus(), error.getMessage());
                }
            }

            if (isValidFirstName && isValidLastName && isMobileNumberExists) {
                isValidCustomerRequest = true;
            }

            logger.debug("validateCustomerUpdateRequest End ,  \n with result : ", isValidCustomerRequest);
            return isValidCustomerRequest;

        }

        private boolean isMobileNumberExists(Long mobileNumber) {

            boolean exixts = customerRepository.existsByMobileNumber(mobileNumber);
            return exixts;

        }

        /**
         * Common method to validate FirstName and LastName for New Customer create
         * request This method validates : string cannot be empty, can contain only
         * letters, and length not exceed 20 in size
         *
         * @param name
         * @return
         */
        private static boolean validateString(String name) {

            boolean isStringValid = false;
            boolean areOnlyChars = false;

            areOnlyChars = areAllChars(name);
            if (areOnlyChars) {
                if (name.length() <= 20) {
                    isStringValid = true;
                }
            }

            if (isStringValid) {
                return isStringValid;
            } else {
                throw new ValidationException(ValidationErrorCode.NAME_MANDATORY.getCode(),
                        ValidationErrorCode.NAME_MANDATORY.getMessage());
            }

        }

        private static boolean areAllChars(String str) {
            Pattern p = Pattern.compile("^[a-zA-Z]+");
            Matcher m = p.matcher(str);
            boolean b = m.matches();
            return b;
        }

        /**
         * Method to validate Email
         *
         * @param email
         * @return
         */
        private static boolean validateEmail(String email) {

            final String EMAIL_REGEX = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";
            Pattern pattern;
            Matcher matcher;
            pattern = Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE);
            boolean isEmailValid = false;
            matcher = pattern.matcher(email);
            isEmailValid = matcher.matches();

            if (isEmailValid) {
                return isEmailValid;
            } else {
                throw new ValidationException(ValidationErrorCode.EMAIL_INVALID.getCode(),
                        ValidationErrorCode.EMAIL_INVALID.getMessage());
            }

        }

        /**
         * Method to validate Mobile Number
         *
         * @param mobileNumber
         * @return
         */
        public boolean validateMobileNumber(Long mobileNumber) {

            logger.debug("validateMobileNumber Start ,  \n for mobileNumber : ", mobileNumber);
            if (mobileNumber.toString().matches("\\d{10}"))
                return true;
            else {
                ResultCode error = ResultCode.INVALID_MOBILE_NUMBER;
                throw new MobileNumberInvalidException(error.getCode(), error.getStatus(), error.getMessage());
            }
        }
    }




