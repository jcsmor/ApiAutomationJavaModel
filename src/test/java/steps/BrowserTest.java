package steps;

import static common.BasePage.*;

import configuration.Configuration;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pages.BrowserPage;

import java.io.IOException;

public class BrowserTest
{
  private final BrowserPage browserPage = new BrowserPage(Configuration.getDriver());
  private int dataReceived = 0;
  private String url;
  public static final String LOG_PATH_AA_ON = "target/AA_ON.txt";
  public static final String LOG_PATH_AA_OFF = "target/AA_OFF.txt";

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

  @And("I get and save performance browser logs")
  public void iGetPerformanceBrowserLogs() throws IOException
  {
    final String perfLogs = browserPage.getPerformanceLogs();
    browserPage.savePerformanceResponse(perfLogs);
  }

  @And("I get browser extension logs")
  public void iGetBrowserExtensionLogs()
  {
    browserPage.saveBrowserExtensionLogs("...");
  }

  @Then("I clear browser logs")
  public void cleaBrowserLogs()
  {
    browserPage.clearBrowserLogs();
  }

  @When("I go to {string} and get bytes received")
  public void iGoToAndGetBrowserExtensionLogs(final String myUrl) throws IOException
  {
    goToUrl(myUrl);
    dataReceived  = browserPage.getEncodedDataSize();
    url = myUrl;
  }

  @Then("I save AA enabled data performance values")
  public void iSaveAAEnabledDataPerformanceValues()
  {
    browserPage.savePerformanceDataToFile(LOG_PATH_AA_ON, url, dataReceived);
  }

  @Then("I save AA disabled data performance values")
  public void iSaveAADisabledDataPerformanceValues()
  {
    browserPage.savePerformanceDataToFile(LOG_PATH_AA_OFF, url, dataReceived);
  }
}
