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
import java.net.MalformedURLException;
import java.util.logging.Level;

public class Configuration
{

  private static WebDriver driver;
  private static final String EXTENSION_FILE = "abp.crx";

  @Before
  public static void setUp() throws MalformedURLException
  {
    WebDriverManager.chromedriver().setup();
    final ChromeOptions options = new ChromeOptions();

    final LoggingPreferences logPrefs = new LoggingPreferences();
    logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
    options.setCapability(ChromeOptions.LOGGING_PREFS, logPrefs);

    //options.setLogLevel(ChromeDriverLogLevel.ALL);
    options.addExtensions(new File(EXTENSION_FILE));

//    options.addArguments("--no-sandbox");
//    options.addArguments("--disable-dev-shm-usage");
    options.addArguments("--remote-debugging-port=61379");
    options.addArguments("--remote-allow-origins=http://localhost:61379");

    driver = new ChromeDriver(options);
  }

  @After
  public static void TearDown(final Scenario scenario)
  {
//    final File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//    final String baseFileName = scenario.getName().replaceAll(":", "").replaceAll("\\s+", "").replaceAll("\\W", "");
//    try
//    {
//      FileUtils.copyFile(screenshot, new File("target/" + baseFileName + ".png"));
//    }
//    catch (final IOException e)
//    {
//      System.out.println(e.getMessage());
//    }
    driver.quit();
  }

  public static WebDriver getDriver()
  {
    return driver;
  }

}
