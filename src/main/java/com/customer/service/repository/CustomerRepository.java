package com.customer.service.repository;

import com.customer.service.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByMobileNumber(Long mobileNumber);

    /**
     * Database call to delete customer details by MobileNumber
     *
     * @param mobileNumber
     * @return
     */
    public boolean deleteByMobileNumber(Long mobileNumber);

   /**
     * Database call to check existence of customer by mobileNumber
     *
     * @param mobileNumber
     * @return
     */
    public boolean existsByMobileNumber(Long mobileNumber);
    // List<Customer> findAll();

}
