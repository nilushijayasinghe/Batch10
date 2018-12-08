package com.TestNG.Exercise;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestCase001 {
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

  @DataProvider
  public Object[][] dt_testCase001() {
    return new Object[][] {
      new Object[] { "5", "200", "10" },
      new Object[] { "5", "300", "15" },};
      }
  
  @Parameters("browser")
  @BeforeMethod()
  public void setUp(String browser) throws Exception{
	  if (browser.equals("chrome")) {
		  System.setProperty("webdriver.chromedriver", "C:\\Users\\fib5\\Desktop\\Batch10\\src\\Libes\\chromedriver.exe");
		  driver = new ChromeDriver();
		  baseUrl = "https://www.katalon.com/";
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }
	  else {
		  System.out.println("Not a valid browser");
	  }
  }
    @Test(dataProvider="dt testCase001")
    public void testCase001(String input1, String input2,String expect) throws Exception {
    driver.get("https://www.calculator.net/");
    driver.findElement(By.linkText("Math Calculators")).click();
    driver.findElement(By.linkText("Percentage Calculator")).click();
    driver.findElement(By.id("cpar1")).click();
    driver.findElement(By.id("cpar1")).clear();
    driver.findElement(By.id("cpar1")).sendKeys("input1");
    driver.findElement(By.id("cpar2")).click();
    driver.findElement(By.id("cpar2")).clear();
    driver.findElement(By.id("cpar2")).sendKeys("input2");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Percentage Calculator'])[3]/following::input[5]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Result: 10'])[1]/following::p[2]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Result: 10'])[1]/following::p[1]")).click();
    assertEquals(driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Result: 10'])[1]/following::b[1]")).getText(), "12");
  }
    
    @AfterMethod()
    public void tearDown1() throws Exception {
      driver.quit();
      String verificationErrorString = verificationErrors.toString();
      if (!"".equals(verificationErrorString)) {
        fail(verificationErrorString);
      }
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
