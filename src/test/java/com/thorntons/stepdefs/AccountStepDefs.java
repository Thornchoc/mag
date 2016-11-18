package com.thorntons.stepdefs;

import com.thorntons.context.ScenarioContext;
import com.thorntons.missions.AccountMissions;
import com.thorntons.model.UserDetails;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import javax.inject.Inject;

import static org.hamcrest.MatcherAssert.assertThat;

public class AccountStepDefs {

    private AccountMissions accountMissions;
    private ScenarioContext context;

    @Inject
    public AccountStepDefs(AccountMissions accountMissions, ScenarioContext context){
        this.accountMissions = accountMissions;
        this.context = context;
    }

    @When("^a registered user$")
    public void a_registered_user() throws Throwable {
        accountMissions.createNewAccount();
        accountMissions.logout();
    }

    @When("^I register with my details$")
    public void i_register_with_my_details() throws Throwable {
        accountMissions.createNewAccount();
    }

    @Then("^my account should be created$")
    public void my_account_should_be_created() throws Throwable {
        accountMissions.logout();
        UserDetails userDetails = context.getUserDetails();
        accountMissions.login(userDetails.getEmail(), userDetails.getPassword());
        assertThat("should see user name", accountMissions.isLoggedIn(userDetails.getFirstName()));
    }



}
