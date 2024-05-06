import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class SeleniumTesting
{
    @Test
    void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver(options);
        ////loading and opening webdriver and chrome driver and getting the website
        driver.get("https://www.dominos.co.in/");//opening the website
        driver.manage().window().maximize();
        //testing the order menu element
        driver.findElement(By.cssSelector("#top-header > ul > li:nth-child(1) > a")).click();
       //testing the subcategories elements
        driver.findElement(By.cssSelector("#our-menu > ul > li:nth-child(2) > a")).click();
        //scrolling the page
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500);");
        //testing the order now button on each option
        driver.findElement(By.cssSelector("#non-veg-pizzas > div > div > div:nth-child(1) > div > a")).click();
        //testing the pickup/dine in option
        driver.findElement(By.cssSelector("#__next > div > div:nth-child(1) > div.mn-cnt > div > div.bdy-cntnt > div.bdy-cntnt-srch > div > div.sc-ifAKCX.GJoqw > div:nth-child(2) > label > span.checkmark")).click();
        WebElement few = driver.findElement(By.cssSelector("#__next > div > div:nth-child(1) > div.mn-cnt > div > div.bdy-cntnt > div.bdy-cntnt-srch > div > div.srch-cnt-srch > input"));
        driver.close();
    }
}