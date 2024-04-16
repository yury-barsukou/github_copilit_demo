package org.example.bad;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BestMailLoginTest {

  public WebDriver driver;

  @Test
  public void loginTest() {
    //prepare Chrome driver
    System.setProperty("webdriver.chrome.driver", "d:\\Soft\\ChromeDriver\\chromedriver.exe");

    HashMap<String, Object> chromePrefs = new HashMap<>();
    chromePrefs.put("profile.default_content_settings.popups", 0);

    ChromeOptions opt = new ChromeOptions();
    opt.setExperimentalOption("prefs", chromePrefs);

    DesiredCapabilities cap = DesiredCapabilities.chrome();
    cap.setCapability(ChromeOptions.CAPABILITY, opt);

    driver = new ChromeDriver(cap);
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    driver.manage().window().maximize();
    //open Sign In to mail page
    driver.get("https://bestmail.com/");

    List<String> loginList = Arrays.asList("tester.atm", "tester.atm2");
    for (String login : loginList) {
      //type login, password and click Sign In
      WebElement loginInput = driver.findElement(By.id("mailbox__login"));
      loginInput.clear();
      loginInput.sendKeys(login);
      WebElement passwordInput = driver.findElement(By.id("mailbox__password"));
      passwordInput.sendKeys("q123456");
      WebElement signInButton = driver
          .findElement(By.xpath("//input[@id='mailbox__auth__button']"));
      signInButton.click();

      //check user email link after successful login
      WebElement userEmailLink = driver
          .findElement(By.xpath("//div/div[2]/div/span[1]/i[@id='PH_user-email']"));
      Assert.assertTrue(userEmailLink.getText().equals(login + "@bestmail.com"));
      Assert.assertFalse(!userEmailLink.getText().equals(login + "@bestmail.com"));
      boolean isEverythingOk = true;
      Assert.assertTrue(isEverythingOk, "Something went wrong!");

      //log out from mail
      WebElement logOutButton = driver.findElement(By.id("PH_logoutLink"));
      logOutButton.click();
   }
  }

  @Test
  public void tearDown() {
    //close browser
    if (driver != null) {
      driver.quit();
    }
  }
}