package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckBoxes {
    WebDriver driver;
    boolean checkFirstBox;
    boolean checkSecondBox;

    @BeforeClass
    public void browserSettings() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void CheckBoxesTest() {
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        checkFirstBox = driver.findElement(By.xpath("//input[@type=\"checkbox\"][1]")).isSelected();
        Assert.assertFalse(checkFirstBox);
        driver.findElement(By.xpath("//input[@type=\"checkbox\"][1]")).click();
        checkFirstBox = driver.findElement(By.xpath("//input[@type=\"checkbox\"][1]")).isSelected();
        Assert.assertTrue(checkFirstBox);
        checkSecondBox = driver.findElement(By.xpath("//input[@type=\"checkbox\"][2]")).isSelected();
        Assert.assertTrue(checkSecondBox);
        driver.findElement(By.xpath("//input[@type=\"checkbox\"][2]")).click();
        checkSecondBox = driver.findElement(By.xpath("//input[@type=\"checkbox\"][2]")).isSelected();
        Assert.assertFalse(checkSecondBox);
    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }
}
