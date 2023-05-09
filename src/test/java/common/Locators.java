package common;

import org.openqa.selenium.By;

public class Locators
{
  // Generic
  public static final By INPUT = By.cssSelector("#input");
  // Settings Screen
  public static final By SETTINGS_UI_ROOT = By.tagName("extensions-manager");
  public static final By SETTINGS_MAIN_ROOT = By.cssSelector("extensions-detail-view");
  // Settings UI Extension Selectors
  public static final By ADBLOCK_TOOGLE_INPUT = By.cssSelector("cr-toggle#enableToggle");
}
