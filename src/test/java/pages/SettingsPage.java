package pages;

import common.BasePage;

import org.openqa.selenium.*;

import static common.BasePage.*;
import static common.Locators.*;

public class SettingsPage
{
  private final WebDriver driver;

  public SettingsPage(final WebDriver driver)
  {
    this.driver = driver;
    final BasePage base = new BasePage(driver);
  }

  public SearchContext expandShadowElement(final WebElement element)
  {
    return (SearchContext) ((JavascriptExecutor) driver).executeScript("return arguments[0].shadowRoot", element);
  }

  // Expand elements up to the Adblock shadow root in order to access elements inside it
  public SearchContext getAdblockShadowRoot()
  {
    final SearchContext shadow_root1 = expandShadowElement(find(SETTINGS_UI_ROOT));
    final SearchContext shadow_root2 = expandShadowElement(shadow_root1.findElement(SETTINGS_MAIN_ROOT));
    //SearchContext shadow_root3 = expandShadowElement(shadow_root2.findElement(SETTINGS_BASIC_PAGE_ROOT));
    return shadow_root2;
  }

  // Check if text is found at least once in an entry of a list of elements in the Adblock shadow DOM
  public Boolean verifyStringIsPresentInAList(final String string, final By locator)
  {
    for (final WebElement item : getAdblockShadowRoot().findElements(locator))
    {
      final String text = item.getText().trim();
      if (text.equals(string))
      {
        return true;
      }
    }
    return false;
  }

}
