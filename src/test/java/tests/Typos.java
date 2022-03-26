package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Typos {
    WebDriver driver;
    String actualText;
    String expectedText;


    @BeforeClass
    public void browserSettings() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void checkCorrectTextTest() {
        driver.get("http://the-internet.herokuapp.com/typos");
        actualText = driver.findElement(By.xpath("//p[2]")).getText();
        expectedText = "Sometimes you'll see a typo, other times you won't.";
        Assert.assertEquals(actualText, expectedText);
    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }
}

