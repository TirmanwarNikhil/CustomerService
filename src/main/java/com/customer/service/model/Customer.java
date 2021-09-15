package com.customer.service.model;

import javax.persistence.*;

@Entity
@Table(name = "Customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer custId;

    @Column(name = "custFName")
    private String custFName;

    @Column(name = "custLName")
    private String custLName;

    @Column(name = "mobileNumber")
    private Long mobileNumber;

    public Customer(Integer custId, String custFName, String custLName, Long mobileNumber) {
        this.custId = custId;
        this.custFName = custFName;
        this.custLName = custLName;
        this.mobileNumber = mobileNumber;
    }

    public Customer() {
    }

    public Customer(String fName, String lName, long mobileNumber) {

    }

    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    public String getCustFName() {
        return custFName;
    }

    public void setCustFName(String custFName) {
        this.custFName = custFName;
    }

    public String getCustLName() {
        return custLName;
    }

    public void setCustLname(String custLname) {
        this.custLName = custLname;
    }

    public Long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(Long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "custId=" + custId +
                ", custFName='" + custFName + '\'' +
                ", custLname='" + custLName + '\'' +
                ", mobileNumber=" + mobileNumber +
                '}';
    }

}
