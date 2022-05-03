package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Inputs {
    WebDriver driver;
    String inputNumbers;
    String inputText;


    @BeforeClass
    public void browserSettings() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/inputs");
    }

//    @Test
//    public void InputsNumbersTest() {
//        inputNumbers = "1234567890";
//        driver.findElement(By.tagName("input")).sendKeys(inputNumbers);
//        String actualNumbers = driver.findElement(By.tagName("input")).getAttribute("value");
//        Assert.assertEquals(actualNumbers, inputNumbers);
//    }

    @Test
    public void InputsTextTest() {
        inputText = "Hello Sasha";
        driver.findElement(By.tagName("input")).sendKeys(inputText);
        String actualSentence = driver.findElement(By.tagName("input")).getText();
        Assert.assertEquals(actualSentence, inputText);

    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }
}
