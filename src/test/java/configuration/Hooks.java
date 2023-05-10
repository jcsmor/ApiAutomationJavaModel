package configuration;

import io.cucumber.java.Before;

import java.io.IOException;

import pages.BrowserPage;
import steps.BrowserTest;

public final class Hooks
{
  private static boolean skipFlag = false;

  @Before(value = "@AA_ON")
  public void setUpAA_ON() throws IOException
  {
    if (!skipFlag)
    {
      BrowserPage.createEmptyFile(BrowserTest.LOG_PATH_AA_ON);
      skipFlag = true;
    }
  }

  @Before(value = "@AA_OFF")
  public void setUpAA_OFF() throws IOException
  {
    if (!skipFlag)
    {
      BrowserPage.createEmptyFile(BrowserTest.LOG_PATH_AA_OFF);
      skipFlag = true;
    }
  }
}