package com.cydeo.fidexio.step_definitions;

import com.cydeo.fidexio.pages.LoginPage;
import com.cydeo.fidexio.utilities.ConfigurationReader;
import com.cydeo.fidexio.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginStepDefs {

    LoginPage loginPage=new LoginPage();


    @Given("User is on the login page")
    public void user_is_on_the_login_page() {

        Driver.getDriver().get(ConfigurationReader.getProperty("url"));

    }
    @When("posmanager inputs username {string}")
    public void posmanager_inputs_username(String string) {

        loginPage.username.sendKeys(ConfigurationReader.getProperty("posmanager.username"));

    }
    @When("posmanager inputs password {string}")
    public void posmanager_inputs_password(String string) {

        loginPage.password.sendKeys(ConfigurationReader.getProperty("posmanager.password"));
    }

    @And("posmanager click log in button")
    public void posmanagerClickLogInButton() {

        loginPage.loginButton.click();
    }

    @When("salesmanager inputs username {string}")
    public void salesmanager_inputs_username(String string) {

        loginPage.username.sendKeys(ConfigurationReader.getProperty("sales.manager.username"));

    }
    @When("salesmanager inputs password {string}")
    public void salesmanager_inputs_password(String string) {
        loginPage.password.sendKeys(ConfigurationReader.getProperty("sales.manager.password"));

    }

    @And("salesmanager click log in button")
    public void salesmanagerClickLogInButton() {

        loginPage.loginButton.click();
    }

    @Then("user is able to see menu")
    public void userIsAbleToSeeMenu() {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.urlContains("menu"));
        String expectedUrl="menu";
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(expectedUrl));
    }


}
