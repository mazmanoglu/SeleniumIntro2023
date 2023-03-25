package day03_webElements_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C04_LocatorTest {
    public static void main(String[] args) throws InterruptedException {

        /*
        - go to amazon website
        - search 'city bike'
        - write all results
        - click picture of first result
         */

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        driver.get("https://www.amazon.com");

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("city bike" + Keys.ENTER);
        // searchBox.submit(); same result Keys.Enter

        List<WebElement> resultWebElementList = driver.findElements(By.className("sg-col-inner"));
        System.out.println(resultWebElementList.get(0).getText());

        driver.findElement(By.className("s-image")).click();
        // If locate contains more than one element, selenium uses the first element.


        Thread.sleep(2000);
        driver.quit();
    }
}
