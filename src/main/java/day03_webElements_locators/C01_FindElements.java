package day03_webElements_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_FindElements {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        driver.get("https://www.amazon.com");

        //In order to use any web element on a website, we need to introduce that web element to our codes.

       // WebElement amazonSearchBox = driver.findElement(By.id("twotabsearchtextbox"));

        WebElement amazonSearchBox = driver.findElement(By.name("field-keywords"));

        amazonSearchBox.sendKeys("nutella" + Keys.ENTER);


        /*
        Selenium has 8 locators. 6 of them are related to HTML tags and attributes.
        2 of them are specific that we use them to locate webElements that we couldn't find with first 6 elements.

        1- By.id --> mostly unique, try first this
        2- className --> generally used to group web elements that do the same function.
                        If class attribute contains 'space', your locate would give errors.
                        usually className locates more than 1 webElement, that's why
                        save all to --> List<WebElement>, use foreach to write all.
        3- name attribute
        4- tagname --> similar to className (input tag, div tag)
        5- linktext --> usually used with 'a' tag. the text that we write between tag (<a>linktext</a>). use just for links.
        6- partialLinkText --> used like linktext, difference is, no need to use all text but part of the text.
         */


        Thread.sleep(2000);
        driver.quit();
    }
}
