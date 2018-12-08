package com.example.xpath;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestCase003 {
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
  public void testCase003() throws Exception {
    driver.get("http://newtours.demoaut.com/mercurysignon.php");
    driver.findElement(By.xpath("//input[@name='userName']")).click();
    driver.findElement(By.xpath("//input[@name='userName')")).sendKeys("nilushi1991");
    driver.findElement(By.xpath("//input[@name='password']")).click();
    driver.findElement(By.xpath("//input[@name='password')")).sendKeys("nilushi@123");
    driver.findElement(By.xpath("register")).submit();
    driver.findElement(By.xpath("fromPort")).click();
    new Select(driver.findElement(By.xpath("fromPort"))).selectByVisibleText("London");
    driver.findElement(By.xpath("fromPort")).click();
    driver.findElement(By.xpath("toPort")).click();
    new Select(driver.findElement(By.name("toPort"))).selectByVisibleText("New York");
    driver.findElement(By.xpath("toPort")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Preferences'])[1]/following::font[3]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Airline:'])[1]/preceding::input[2]")).click();
    driver.findElement(By.xpath("airline")).click();
    new Select(driver.findElement(By.name("airline"))).selectByVisibleText("Blue Skies Airlines");
    driver.findElement(By.xpath("airline")).click();
    driver.findElement(By.xpath("findFlights")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='DEPART'])[1]/following::td[2]")).click();
    assertEquals(driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='DEPART'])[1]/following::font[1]")).getText(), "London to New York");
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
