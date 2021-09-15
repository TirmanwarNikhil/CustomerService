package stepsdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UpdateCustomerSteps {

    @Given("I have Customer Details tobe update")
    public void i_have_customer_details_tobe_update() {
       System.out.println("Step 1 : I have Customer Details tobe update ");
    }

    @When("I try to update Customer detail")
    public void i_try_to_update_customer_detail() {
        System.out.println("Step 2 : I try to update Customer detail ");
    }

    @Then("Customer details record should be updated in Database")
    public void customer_details_record_should_be_updated_in_database() {
        System.out.println("Step 3 : Customer details record should be updated in Database ");
    }


}
