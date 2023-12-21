package steps;

import configuration.Configuration;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.RepoPage;


public class RepoPageSteps
{
  private final RepoPage repoPage = new RepoPage(Configuration.getDriver());

  @And("I validate presence of plugin file size elements")
  public void iValidatePresenceOfPluginFileSizeElements()
  {
    repoPage.validatePresenceFSPlugin();
  }

  @Then("I validate all file sizes show correct file size format")
  public void iValidateAllFileSizesShowCorrectFileSizeFormat()
  {
    repoPage.validateFileSizeFormat();
  }
}
