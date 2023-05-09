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
import org.openqa.selenium.chrome.ChromeDriverLogLevel;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

public class Configuration
{

  private static WebDriver driver;

  @Before
  public static void setUp() throws MalformedURLException
  {
    WebDriverManager.chromedriver().setup();
    final ChromeOptions options = new ChromeOptions();
    options.setLogLevel(ChromeDriverLogLevel.OFF);
    options.addExtensions(new File("abp.crx"));
    //options.addExtensions(new File("add_wall.crx"));
    //options.addArguments("--no-sandbox");
    //options.addArguments("--disable-dev-shm-usage");
    driver = new ChromeDriver(options);
  }

  @After
  public static void TearDown(final Scenario scenario)
  {
    final File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    final String baseFileName = scenario.getName().replaceAll(":", "").replaceAll("\\s+", "").replaceAll("\\W", "");
    try
    {
      FileUtils.copyFile(screenshot, new File("target/" + baseFileName + ".png"));
    }
    catch (final IOException e)
    {
      System.out.println(e.getMessage());
    }
    driver.quit();
  }

  public static WebDriver getDriver()
  {
    return driver;
  }

}
