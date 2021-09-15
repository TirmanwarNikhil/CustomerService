package stepsdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DeleteCustomerSteps {



    @Given("I have Customer Details in Database and MobileNumber")
    public void i_have_customer_details_in_database_and_mobile_number() {
        System.out.println("Step 1 : I have Customer Details in Database and MobileNumber");
    }

    @When("I try to delete Customer")
    public void i_try_to_delete_customer() {
        System.out.println("Step 2 : I try to delete Customer");
    }

    @Then("Respective customer record should be deactivated in Database")
    public void respective_customer_record_should_be_deactivated_in_database() {
        System.out.println("Step 3 : Respective customer record should be deactivated in Database");
    }

}
