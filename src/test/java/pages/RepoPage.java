package pages;

import common.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.LinkedList;
import java.util.List;

import static common.BasePage.*;

public class RepoPage
{
  //Page Locators
  private static final By FILE_SIZE_ELS = By.cssSelector(".github-repo-size-div");

  //
  private final WebDriver driver;

  public RepoPage(final WebDriver driver)
  {
    this.driver = driver;
    final BasePage base = new BasePage(driver);
  }

  public void validatePresenceFSPlugin()
  {
    Assert.assertTrue("File size plugin elements are not visible", isElementDisplayed(FILE_SIZE_ELS));
    isElementDisplayed(FILE_SIZE_ELS);
  }

  public void validateFileSizeFormat()
  {
    final List<WebElement> fileSizes = findElements(FILE_SIZE_ELS);
    getFileSizeList(fileSizes);
    //validateFSFormat();
  }

  private List<String> getFileSizeList(final List<WebElement> fileSizes){
    final List<String> fileSizesList = new LinkedList<>();

    for (final WebElement fs : fileSizes)
    {
      final String myFileSize = fs.getText().toString();
      if (!myFileSize.contains("···"))
      {
        fileSizesList.add(myFileSize);
      }
    }
    System.out.println(fileSizesList);
    return fileSizesList;
  }

//  private void validateFSFormat()
//  {
//    final Pattern pattern = Pattern.compile('/^(\\d*\\.?\\d+)(?(?=[KMGT])([KMGT])(?:i?B)?|B?)$/i');
//    final Matcher matcher = pattern.matcher(EXAMPLE_TEST);
//    https://www.vogella.com/tutorials/JavaRegularExpressions/article.html
//  }

  private boolean checkFormat (final String s){
    final Pattern pattern = Pattern.compile("\\d{3}");
    final Matcher matcher = pattern.matcher(s);
    if (matcher.find()){
      return true;
    }
    return false;
  }



}
