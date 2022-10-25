package com.cydeo.fidexio.step_definitions;

import com.cydeo.fidexio.pages.LoginPage;
import com.cydeo.fidexio.utilities.BrowserUtility;
import com.cydeo.fidexio.utilities.ConfigurationReader;
import com.cydeo.fidexio.utilities.Driver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;

public class LoginStepDefs {

    LoginPage loginPage = new LoginPage();


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
        String expectedUrl = "menu";
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(expectedUrl));
    }

    @When("posmanager enters invalid credentials")
    public void posmanager_enters_invalid_credentials(Map<String, String> credentials) {

        loginPage.username.sendKeys(credentials.get("username"));
        loginPage.password.sendKeys(credentials.get("password"));
        loginPage.loginButton.click();

    }
    @When("salesmanager enters invalid credentials")
    public void salesmanager_enters_invalid_credentials(Map<String, String> credentials) {

        loginPage.username.sendKeys(credentials.get("username"));
        loginPage.password.sendKeys(credentials.get("password"));
        BrowserUtility.sleep(3);
        loginPage.loginButton.click();


    }
    @Then("users are able to see Wrong login\\/password")
    public void users_are_able_to_see_wrong_login_password() {


        System.out.println("loginPage.wrongMessage.isDisplayed() = " + loginPage.wrongMessage.isDisplayed());

        Assert.assertTrue(loginPage.wrongMessage.getText().equals("Wrong login/password"));

    }

    @When("posmanager blank username and input valid password")
    public void posmanager_blank_username_and_input_valid_password() {
        loginPage.username.sendKeys("");
        loginPage.password.sendKeys(ConfigurationReader.getProperty("posmanager.password"));
        loginPage.loginButton.click();

    }

    @When("salesmanager blank username and input valid password")
    public void salesmanagerBlankUsernameAndInputValidPassword() {
        loginPage.username.sendKeys(ConfigurationReader.getProperty("sales.manager.username"));
        loginPage.password.sendKeys("");
        loginPage.loginButton.click();
    }

    @Then("users are able to see required message")
    public void users_are_able_to_see_required_message() {

        System.out.println("loginPage.requiredMessage.getAttribute(\"required\") = " + loginPage.requiredMessage.getAttribute("required"));

    }


    @When("user input password")
    public void userInputPassword() {
        loginPage.password.sendKeys(ConfigurationReader.getProperty("posmanager.password"));
    }

    @Then("user is able to see the password in bullet sign")
    public void userIsAbleToSeeThePasswordInBulletSign() {

        Assert.assertTrue("User is not able to see....", loginPage.bulletPassword.getAttribute("type").equals("password"));

    }

    @When("user press ENTER keyword after input valid credentials")
    public void user_press_enter_keyword_after_input_valid_credentials(Map<String, String> credentials) {

        loginPage.username.sendKeys(credentials.get("username"));
        loginPage.password.sendKeys(credentials.get("password")+Keys.ENTER);

    }
    @Then("users is able to verify keyword is working correctly")
    public void users_is_able_to_verify_keyword_is_working_correctly() {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.urlContains("menu"));
        String expectedUrl = "menu";
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(expectedUrl));

    }

}
