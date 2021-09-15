package stepsdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateCustomerSteps {


    @Given("I have Customer Details")
    public void i_have_customer_details() {
        System.out.println("Step 1 : I have Customer Details");

    }

    @When("I Receive Customer Details")
    public void i_receive_customer_details() {
        System.out.println("Step 2 : I Receive Customer Details");

    }

    @Then("I should insert record in Database")
    public void i_should_insert_record_in_database() {
        System.out.println("Step 3 : I should insert record in Database");

    }


}
