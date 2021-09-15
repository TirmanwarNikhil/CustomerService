package stepsdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GetCustomerDetailsByMobileNumberSteps {

    @Given("I have Customer Mobile Number")
    public void i_have_customer_mobile_number() {

        System.out.println("Step 1 : I have Customer Mobile Number");

    }

    @When("I search Customer detail with MobileNumber {string}")
    public void i_search_customer_detail_with_mobile_number(String mobileNumber) {

        System.out.println("Step 2 : I search Customer Detail with MobileNumber : " + mobileNumber);


    }
    @Then("Customer with First Name {string} should be displayed")
    public void customer_with_first_name_should_be_displayed(String fName) {

        System.out.println("Step 3 : Customer with First Name :" + fName +"Should be Displayed." );


    }


}
