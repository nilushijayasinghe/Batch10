package com.example.xpath;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestCase004 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\fib5\\Desktop\\Batch10\\src\\Libes\\chromedriver.exe" );
	  driver = new ChromeDriver();
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testCase004() throws Exception {
    driver.get("http://newtours.demoaut.com/mercurysignon.php");
    driver.findElement(By.xpath("userName")).click();
    driver.findElement(By.xpath("userName")).clear();
    driver.findElement(By.xpath("userName")).sendKeys("nilushi1991");
    driver.findElement(By.xpath("password")).click();
    driver.findElement(By.xpath("password")).clear();
    driver.findElement(By.xpath("password")).sendKeys("nilushi@123");
    driver.findElement(By.xpath("register")).submit();
    driver.findElement(By.xpath("fromPort")).click();
    new Select(driver.findElement(By.xpath("fromPort"))).selectByVisibleText("London");
    driver.findElement(By.xpath("fromPort")).click();
    driver.findElement(By.xpath("toMonth")).click();
    new Select(driver.findElement(By.xpath("toMonth"))).selectByVisibleText("December");
    driver.findElement(By.xpath("toMonth")).click();
    driver.findElement(By.xpath("toPort")).click();
    new Select(driver.findElement(By.xpath("toPort"))).selectByVisibleText("New York");
    driver.findElement(By.xpath("toPort")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Preferences'])[1]/following::font[3]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Airline:'])[1]/preceding::input[2]")).click();
    driver.findElement(By.xpath("airline")).click();
    new Select(driver.findElement(By.xpath("airline"))).selectByVisibleText("Blue Skies Airlines");
    driver.findElement(By.xpath("airline")).click();
    driver.findElement(By.xpath("findFlights")).click();
    driver.findElement(By.xpath("//table[2]/tbody/tr/td")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='RETURN'])[1]/following::td[2]")).click();
    driver.findElement(By.xpath("//table[2]/tbody/tr/td/table")).click();
    assertEquals(driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='RETURN'])[1]/following::font[1]")).getText(), "New York to London");
    driver.findElement(By.linkText("SIGN-OFF")).click();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
