package steps;

import static common.BasePage.*;
import static pages.BrowserPage.*;

import configuration.Configuration;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import pages.BrowserPage;

import java.io.IOException;

public class BrowserTest
{
  private final BrowserPage browserPage = new BrowserPage(Configuration.getDriver());

  @Given("I go to {string}")
  public void visitUrl(final String url)
  {
    goToUrl(url);
  }


  @And("I get browser logs")
  public void iGetBrowserLogs()
  {
    browserPage.saveBrowserLogs();
  }

  @And("I get browser extension logs")
  public void iGetBrowserExtensionLogs()
  {
    //browserPage.injectTestData();
    browserPage.saveBrowserExtensionLogs("...");
  }

  @Then("I clear browser logs")
  public void cleaBrowserLogs()
  {
    browserPage.clearBrowserLogs();
  }

  @When("I go to {string} and get bytes received")
  public void iGoToAndGetBrowserExtensionLogs(final String url) throws IOException
  {
    goToUrl(url);
    browserPage.saveBrowserPerformanceLogs();
  }
}
