package steps;

import configuration.Configuration;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BrowserPage;
import pages.HomePage;

import java.io.IOException;

import static common.BasePage.*;


public class HomePageSteps
{
  private final HomePage homePage = new HomePage(Configuration.getDriver());


  @And("I validate presence of {int} main menus")
  public void iValidatePresenceOfMainMenus(final int numMenus)
  {
    homePage.validateNumberMenus(numMenus);
  }


  @When("I select main menu {string}")
  public void iSelect(final String elem)
  {
    homePage.overMainMenuElement(elem);
  }

  @And("I select sub menu {string}")
  public void iSelectSubMenu(final String elem)
  {
    homePage.selectSubMenuEl(elem);
  }
}
