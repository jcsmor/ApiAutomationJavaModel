package common;

import com.google.common.net.UrlEscapers;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class BasePage
{
  private static WebDriver driver;
  private static final int TIMEOUT = 24;
  public static final int MEDIUM_TIMEOUT = 12;
  public static final int SMALL_TIMEOUT = 6;
  public static final int TINY_TIMEOUT = 3;
  public static final int MAX_CYCLES = 11;

  public BasePage(final WebDriver driver)
  {
    BasePage.driver = driver;
  }


  public static void waitForCondition(final ExpectedCondition condition, final int timeout)
  {
    final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
    wait.until(condition);
  }

  public static void waitForCondition(final ExpectedCondition condition)
  {
    waitForCondition(condition, TIMEOUT);
  }

  public static WebElement find(final By locator)
  {
    return find(locator, 0);
  }

  public static WebElement find(final By locator, final int index)
  {
    waitForCondition(ExpectedConditions.presenceOfElementLocated(locator));
    final List<WebElement> elements = driver.findElements(locator);
    if (elements.size() > 1)
    {
      return elements.get(index);
    }
    else
    {
      return elements.get(0);
    }
  }

  public static List<WebElement> findElements(final By locator)
  {
    List<WebElement> elements = null;
    try
    {
      waitForCondition(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
      elements = driver.findElements(locator);
    }
    catch (final NoSuchElementException e)
    {
      System.err.println("Element with " + locator + " locator not found");
    }
    return elements;
  }

  public static boolean isElementDisplayed(final By selector)
  {
    try
    {
      waitForCondition(ExpectedConditions.visibilityOfElementLocated(selector));
      waitForCondition(ExpectedConditions.elementToBeClickable(selector));
      return true;
    }
    catch (final Exception e)
    {
      return false;
    }
  }

  public static boolean isElementNotDisplayed(final By selector)
  {
    try
    {
      waitForCondition(ExpectedConditions.invisibilityOfElementLocated(selector));
      return true;
    }
    catch (final Exception e)
    {
      return false;
    }
  }

  public static String getElementText(final By selector)
  {
    final WebElement element = find(selector);
    return element.getText();
  }

  public static void getPageSource()
  {
    System.out.println(driver.getPageSource());
  }

  public static Boolean isTextPresent(final By selector, final String text)
  {
    final WebElement element = find(selector);
    try
    {
      waitForCondition(ExpectedConditions.textToBePresentInElement(element, text));
      return true;
    }
    catch (final Exception e)
    {
      return false;
    }
  }

  public static String getAttributeFromElement(final String attribute, final WebElement element)
  {
    //System.out.println(element.getAttribute(attribute));
    return element.getAttribute(attribute);
  }

//    public static List<String> getLogs(final String logType) {
//        List<String> logs = new ArrayList<String>();
//        for(LogEntry entry: driver.manage().logs().get(logType.toLowerCase())){
//            logs.add(entry.getMessage());
//        }
//        return logs;
//    }

  public static void goToUrl(final String url)
  {
    driver.get(url);
  }

  public static void moveToElement(final By selector)
  {
    final WebElement element = find(selector);
    final Actions actions = new Actions(driver);
    actions.moveToElement(element);
    actions.perform();
  }

  public static int getNumberOfWindows()
  {
    return driver.getWindowHandles().size();
  }

  public static void switchToFrame(final By locator)
  {
    waitForCondition(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
  }

  public static void switchToMainContent()
  {
    driver.switchTo().defaultContent();
  }

  public static String encodeURL(final String baseUrl, final String query)
  {
    final String encodedString = UrlEscapers.urlFragmentEscaper().escape(query);
    return baseUrl + encodedString;
  }

  public static void waitSomeTime(final int time)
  {
    for (int i = 0; i < time; i++)
    {
      try
      {
        Thread.sleep(1000);
      }
      catch (final InterruptedException e)
      {
        e.printStackTrace();
      }
    }
  }

  public static void switchToWindow(final int window)
  {
    final Set<String> AllWindowHandles = driver.getWindowHandles();
    final String WantedWindow = (String) AllWindowHandles.toArray()[window];
    driver.switchTo().window(WantedWindow);
  }

  public static LogEntries getLogs(final String logType)
  {
    return driver.manage().logs().get(logType.toLowerCase());
  }



}
