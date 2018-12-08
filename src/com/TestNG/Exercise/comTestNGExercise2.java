package com.TestNG.Exercise;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class comTestNGExercise2 {
  @Test(dataProvider = "dp")
  public void f(Integer n, String s) {
  }

  @DataProvider
  public Object[][] dt_testCase001() {
    return new Object[][] {
      new Object[] { "5", "200", "10" },
      new Object[] { "5", "300", "15" },
    };
  }
}
