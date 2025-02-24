package configuration;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

import pages.BrowserPage;
import steps.BrowserTest;

public class Configuration
{

  private static WebDriver driver;
  private static final String EXTENSION_FILE = "githubSize.crx";

  @Before
  public static void setUp()
  {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("disable-infobars");
    options.addArguments("--lang=en");
    options.addArguments("--no-sandbox");
    options.addArguments("--disable-dev-shm-usage");
    //options.addArguments("--start-maximized");
    options.addArguments("--disable-popup-blocking");
    WebDriverManager.chromedriver().clearDriverCache().setup();
    //driver = new ChromeDriver(options);

    final LoggingPreferences logPrefs = new LoggingPreferences();
    logPrefs.enable(LogType.BROWSER, Level.ALL);
    options.setCapability(ChromeOptions.LOGGING_PREFS, logPrefs);
    options.addExtensions(new File(EXTENSION_FILE));

    //options.addArguments("--incognito");
    //options.addArguments("--remote-debugging-port=61379");
    //options.addArguments("--remote-allow-origins=http://localhost:61379");

  }



  @After
  public static void TearDown(final Scenario scenario)
  {
    //driver.quit();
  }

  public static WebDriver getDriver()
  {
    return driver;
  }

}
