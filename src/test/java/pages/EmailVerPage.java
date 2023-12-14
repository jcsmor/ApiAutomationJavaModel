package pages;

import common.BasePage;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static common.BasePage.*;

public class EmailVerPage
{
  //Page Locators
  private final By EMAIL_INPUT = By.cssSelector("#email");
  private final By SUBMIT_EMAIL_BTN = By.cssSelector("input[type='submit']");


  //
  private final WebDriver driver;

  public EmailVerPage(final WebDriver driver)
  {
    this.driver = driver;
    final BasePage base = new BasePage(driver);
  }

  public void addInvalidEmail(final String invalidEmail)
  {
    sendText(EMAIL_INPUT, invalidEmail);
    find(SUBMIT_EMAIL_BTN).click();
  }

  public void validateErrorMsg()
  {
    final String  errorMsg = getAttributeFromElement("validationMessage", find(EMAIL_INPUT));
    //System.out.println(errorMsg);
    Assert.assertEquals("Validation messages do not match", errorMsg, "A part followed by '@' should not contain the symbol ' '.");
  }
}
