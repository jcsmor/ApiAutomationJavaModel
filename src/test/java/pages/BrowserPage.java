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

public class BrowserPage
{
  private final WebDriver driver;
  public List<String> sessionBrowserLogs = new ArrayList<String>();
  public List<String> sessionBrowserExtensionLogs = new ArrayList<String>();
  public List<String> sitesList = new ArrayList<String>();

  public BrowserPage(final WebDriver driver)
  {
    this.driver = driver;
    final BasePage base = new BasePage(driver);
  }

  public void clearAllCookies()
  {
    driver.manage().deleteAllCookies();
  }


  public void readSitesFromFile(final String filePath){
    try {
      final FileReader reader = new FileReader(filePath);
      final BufferedReader bufferedReader = new BufferedReader(reader);
      String line;
      while ((line = bufferedReader.readLine()) != null) {
        sitesList.add(line.toString());
      }
      reader.close();
    } catch (final IOException e) {
      e.printStackTrace();
    }
  }

  public void saveBrowserLogs()
  {
    final LogEntries logs = getLogs("browser");
    for (final LogEntry line : logs)
    {
      sessionBrowserLogs.add(line.toString());
    }
    //System.out.println(sessionBrowserLogs);
  }

  public String getPerformanceLogs()
  {
    final LogEntries logs = getLogs("performance");
    for (final LogEntry line : logs)
    {
      sessionBrowserLogs.add(line.toString());
    }
    return sessionBrowserLogs.toString();
  }

  public int getEncodedDataSize() throws IOException
  {
    // encodedDataLength Actual bytes received (might be less than dataLength for compressed encodings).
    final LogEntries logs = getLogs("performance");
    int encodedDataSize = 0;
    String encodedDataLength;
    for (final LogEntry line : logs)
    {
      if (line.getMessage().contains("Network.dataReceived"))
      {
        encodedDataLength = line.getMessage().split("encodedDataLength\":")[1].split(",")[0];
        encodedDataSize = encodedDataSize + Integer.parseInt(encodedDataLength);
        //System.out.println(encodedDataLength);
      }
    }
    System.out.println(" Total size is : " + encodedDataSize);
    return encodedDataSize;
  }

  public void savePerformanceDataToFile(final String LOG_PATH, final String url, final int dataReceived)
  {
    final Date date = new Date();
    final Timestamp timestamp = new Timestamp(date.getTime());

    final String str = timestamp + ", URL:" + url + ", DATA_RECEIVED:" + dataReceived + '\n';
    try
    {
      final File newTextFile = new File(LOG_PATH);
      final FileWriter fw = new FileWriter(newTextFile, true);
      fw.write(str);
      fw.close();
    } catch (final IOException iox)
    {
      iox.printStackTrace();
    }
    waitSomeTime(TINY_TIMEOUT);
  }

  public static void createEmptyFile(final String filename)
  {
    try
    {
      final File newTextFile = new File(filename);
      new FileWriter(newTextFile, false).close();
    } catch (final IOException iox)
    {
      iox.printStackTrace();
    }
  }

  public void savePerformanceResponse(final String str) throws IOException
  {
    final String LOG_PATH = "target/performanceLogs.txt";
    try
    {
      final File newTextFile = new File(LOG_PATH);
      final FileWriter fw = new FileWriter(newTextFile);
      fw.write(str);
      fw.close();
    } catch (final IOException iox)
    {
      iox.printStackTrace();
    }
    waitSomeTime(TINY_TIMEOUT);
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

  public void validateNumberMenus(final int numElements)
  {
    Assert.assertEquals("The number of menus is not 5", numElements, 5);
  }

}
