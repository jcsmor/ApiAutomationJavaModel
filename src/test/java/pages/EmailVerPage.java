package pages;

import common.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static common.BasePage.*;

public class EmailVerPage
{
  //Page Locators
  private final By EMAIL_INPUT = By.cssSelector("#email");
  private final By SUBMIT_EMAIL_BTN = By.cssSelector("input[type='submit']");
  private final By ERROR_MSG = By.cssSelector(".error-text");


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
    //final String errorMsg = getAttributeFromElement("validationMessage", find(EMAIL_INPUT));
    final String errorMsg = find(ERROR_MSG).getText();

    //System.out.println(errorMsg);
    Assert.assertEquals("Validation messages do not match", errorMsg, "Apologies, but only corporate emails are accepted. Please try again using a business email address.");
  }
}
