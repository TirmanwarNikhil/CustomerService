package com.customer.service.dto;

public class CustomerDto {


    private Integer custId;
    private String custFName;
    private String custLname;
    private Long mobileNumber;

    public CustomerDto(Integer custId, String custFName, String custLname, Long mobileNumber) {
        this.custId = custId;
        this.custFName = custFName;
        this.custLname = custLname;
        this.mobileNumber = mobileNumber;
    }

    public CustomerDto(String custFName, String custLname, Long mobileNumber) {
        this.custFName = custFName;
        this.custLname = custLname;
        this.mobileNumber = mobileNumber;
    }

    public CustomerDto() {
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

    public String getCustLname() {
        return custLname;
    }

    public void setCustLname(String custLname) {
        this.custLname = custLname;
    }

    public Long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(Long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Override
    public String toString() {
        return "CustomerDto{" +
                "custId=" + custId +
                ", custFName='" + custFName + '\'' +
                ", custLname='" + custLname + '\'' +
                ", mobileNumber=" + mobileNumber +
                '}';
    }

}
