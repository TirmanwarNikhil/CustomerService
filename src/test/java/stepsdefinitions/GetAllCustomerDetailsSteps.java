package stepsdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GetAllCustomerDetailsSteps {

    @Given("I have Customer Details in Database")
    public void i_have_customer_details_in_database() {
        System.out.print("Step 1 : I have Customer Details in Database");
    }

    @When("I search for All Customers details")
    public void i_search_for_all_customers_details() {
        System.out.print("Step 2 : I search for All Customers details");
    }

    @Then("All Customers with their details should be displayed")
    public void all_customers_with_their_details_should_be_displayed() {
        System.out.print("Step 3 : All Customers with their details should be displayed");

    }

}
