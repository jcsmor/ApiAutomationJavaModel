package steps;

import static common.Locators.*;
import static common.BasePage.*;

import configuration.Configuration;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import pages.SettingsPage;

public class SettingsTest
{
  private final SettingsPage settingsPage = new SettingsPage(Configuration.getDriver());

  @Given("I go to AdBlocking Settings")
  public void goToAdblockingSettings()
  {
    goToUrl("chrome://extensions/?id=cfhdojbkjhnklbpkdaibdccddilifddb");
    //goToUrl("chrome-extension://cfhdojbkjhnklbpkdaibdccddilifddb/options.html");
  }

  @Then("I verify ABP is enabled")
  public void verifyAbpIsEnabled()
  {
    final SearchContext adblock_shadow_root = settingsPage.getAdblockShadowRoot();
    final WebElement custom_subscriptions_menu_item = adblock_shadow_root.findElement(ADBLOCK_TOOGLE_INPUT);
    //custom_subscriptions_menu_item.click();
    Assert.assertEquals("ABP is disabled", "true", getAttributeFromElement("checked", custom_subscriptions_menu_item));
  }

  @Then("I disable ABP")
  public void disableAbp()
  {
    final SearchContext adblock_shadow_root = settingsPage.getAdblockShadowRoot();
    final WebElement custom_subscriptions_menu_item = adblock_shadow_root.findElement(ADBLOCK_TOOGLE_INPUT);
    custom_subscriptions_menu_item.click();
    Assert.assertNull("ABP is enabled", getAttributeFromElement("checked", custom_subscriptions_menu_item));
  }

  @Then("I wait some time")
  public void iWaitSomeTime()
  {
    waitSomeTime(MEDIUM_TIMEOUT);
  }

  @Then("I wait until extensions are installed")
  public void iWaitUntilExtensionInstalled()
  {
    waitSomeTime(SMALL_TIMEOUT);
    switchToWindow(0);
  }

}
