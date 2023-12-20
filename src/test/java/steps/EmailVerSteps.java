package steps;

import configuration.Configuration;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.BrowserPage;
import pages.EmailVerPage;


public class EmailVerSteps
{
  private final EmailVerPage emailVPage = new EmailVerPage(Configuration.getDriver());
  private final BrowserPage browserPage = new BrowserPage(Configuration.getDriver());

  @When("I enter a invalid email")
  public void iEnterAInvalidEmail()
  {
    emailVPage.addInvalidEmail("request@hotmail.com");
  }

  @Then("I validate browser log status {string}")
  public void iValidateBrowserLogStatus(final String status)
  {
    browserPage.validateLogStatus(status);
  }

  @Then("I see a error message")
  public void iSeeAErrorMessage()
  {
    emailVPage.validateErrorMsg();
  }
}
