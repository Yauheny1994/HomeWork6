package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;


public class AddRemoveElements {
    WebDriver driver;

    @BeforeClass
    public void browserSettings() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void addTwoElementsAndRemoveOneElementTest() {
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        driver.findElement(By.xpath("//button[text()=\"Delete\"]")).click();
        List<WebElement> numberOfElements = driver.findElements(By.xpath("//button[text()='Add Element']"));
        int expectedNumberOfElements = 1;
        int actualNumberOfElements = numberOfElements.size();
        Assert.assertEquals(expectedNumberOfElements, actualNumberOfElements);
    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }

}
