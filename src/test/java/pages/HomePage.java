package pages;

import com.google.gson.Gson;
import common.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.support.Color;

import java.io.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static common.BasePage.*;

public class HomePage
{
  //Page Locators
  private static final By MAIN_MENUS = By.cssSelector(".navbar-menu .menu_dp-link");
  private static final By MAIN_MENU_PRODUCT = By.cssSelector(".menu_dp-link.is-product");
  public static final By EMAIL_VALIDATION = By.cssSelector("*[href='/email-validation']");


  //
  private final WebDriver driver;

  public HomePage(final WebDriver driver)
  {
    this.driver = driver;
    final BasePage base = new BasePage(driver);
  }

  public void validateNumberMenus(final int numElements)
  {
    final int foundEls = findElements(MAIN_MENUS).toArray().length;
    Assert.assertEquals("The number of menus is not 5", numElements, foundEls);
  }

  public void overMainMenuElement(final String menuEl)
  {
    switch (menuEl)
    {
      case "Product":
        moveToElement(MAIN_MENU_PRODUCT);
        break;
      case "Solutions":
        // code block
        break;
      case "Pricing":
        // code block
        break;
      case "Resources":
        // code block
        break;
      case "Company":
        // code block
        break;
      default:
        // code block
    }
  }

  private boolean validateStatusError(final String url, final LogEntries logs)
  {
    boolean noError = true;
    for (final LogEntry line : logs)
    {
      if (line.toString().contains("status of"))
      {
        final String myStatusCode = line.toString().split("status of ")[1].substring(0, 3);
        System.out.println(url + " : Error Page with status code of " + myStatusCode);
        noError = false;
        break;
      }
    }
    return noError;
  }

  public void selectSubMenuEl(final String elem)
  {
    switch (elem)
    {
      case "Email Validation":
        find(EMAIL_VALIDATION).click();
        break;
      case "Solutions":
        // code block
        break;
      default:
        // code block
    }
  }
}
