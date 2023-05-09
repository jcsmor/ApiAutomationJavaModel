package pages;

import com.google.gson.Gson;
import common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.support.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static common.BasePage.*;

public class BrowserPage
{
  private final WebDriver driver;
  public List<String> sessionBrowserLogs = new ArrayList<String>();
  public List<String> sessionBrowserExtensionLogs = new ArrayList<String>();

  public BrowserPage(final WebDriver driver)
  {
    this.driver = driver;
    final BasePage base = new BasePage(driver);
  }

  public void saveBrowserLogs()
  {
    final LogEntries logs = getLogs("browser");
    for (final LogEntry line : logs)
    {
      sessionBrowserLogs.add(line.toString());
    }
    System.out.println(sessionBrowserLogs);
  }

  public void saveBrowserPerformanceLogs()
  {
    final LogEntries logs = getLogs("performance");
    int encodedDataSize = 0;
    String encodedDataLength;
    for (final LogEntry line : logs)
    {
      if (line.getMessage().contains("Network.dataReceived"))
      {
        encodedDataLength = line.getMessage().split("encodedDataLength\":")[1].split(",")[0];
        encodedDataSize = encodedDataSize + Integer.parseInt(encodedDataLength);
        System.out.println(encodedDataLength);
      }
    }
    System.out.println(" Total size is : " + encodedDataSize);
  }

  public void injectTestData()
  {
    final int rvalue = (int) (Math.random() * 100);
    final JavascriptExecutor js = (JavascriptExecutor) driver;
    //final String script = "return 'ADD_WALL: "+rvalue+"'";
    final String script0 = "return window.location.href";
    final Object response0 = js.executeScript(script0);
    final String jsonResponse0 = new Gson().toJson(response0);

    final String script1 = "console.error('###_URL: " + jsonResponse0 + " ADD_WALL: " + rvalue + "_###')";
    final Object response1 = js.executeScript(script1);
    //final String jsonResponse1 = new Gson().toJson(response1);
  }

  public void saveBrowserExtensionLogs(final String url)
  {
    final LogEntries logs = getLogs("browser");
    {
      final boolean noErrors = validateStatusError(url, logs);
      if (noErrors)
      {
        validateAddWallExtData(url, logs);
      }
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

  private void validateAddWallExtData(final String url, final LogEntries logs)
  {
    for (final LogEntry line : logs)
    {
      if (line.toString().contains("AD WALL EXTENSION"))
      {
        sessionBrowserExtensionLogs.add(line.toString().split("###_")[1].split("_###")[0]);
        final String sessionString = sessionBrowserExtensionLogs.get(0);
        System.out.println("URL: " + url + " / " + sessionString);
        break;
      }
    }
  }

  public void clearBrowserLogs()
  {
    // Call getLogs to consume all logs and then clear sessionBrowserLogs array
    driver.manage().logs().get("browser");
    sessionBrowserLogs.clear();
  }

  public boolean verifyImageIsBlocked(final By selector)
  {
    final String img_src = find(selector).getAttribute("src");
    for (final String line : sessionBrowserLogs)
    {
      if (line.contains("Failed to load") && line.contains(img_src))
      {
        return true;
      }
    }
    return false;
  }

  public boolean verifyFileIsBlocked(final String file)
  {
    for (final String line : sessionBrowserLogs)
    {
      if (line.contains("Failed to load") && line.contains(file))
      {
        return true;
      }
    }
    return false;
  }

  public boolean verifyJSRefusedToLoad(final String file)
  {
    for (final String line : sessionBrowserLogs)
    {
      if (line.contains("Refused to load the script") && line.contains(file))
      {
        return true;
      }
    }
    return false;
  }

  public boolean verifyJSRefusedToExecute(final String file)
  {
    for (final String line : sessionBrowserLogs)
    {
      if (line.contains("Refused to execute inline script") && line.contains(file))
      {
        return true;
      }
    }
    return false;
  }

  public String getElementBackgroundColor(final By selector)
  {
    final String color = find(selector).getCssValue("background-color");
    return Color.fromString(color).asHex();
  }
}
