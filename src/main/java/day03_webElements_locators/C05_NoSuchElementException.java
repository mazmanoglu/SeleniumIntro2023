package day03_webElements_locators;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_NoSuchElementException {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        driver.get("https://www.amazon.com");

        WebElement amazonSearchBox = driver.findElement(By.id("twotabsearchtextbox"));

        amazonSearchBox.sendKeys("nutella");

        /*
        If there is a problem/mistake with the locator in webelements that are located with 'findelement',
        the driver cannot find the requested webelement and throws a NoSuchElementException.

        But 'findelements' list doesn't throw an exception. Result will be 0.
         */

        Thread.sleep(2000);
        driver.quit();
    }
}
