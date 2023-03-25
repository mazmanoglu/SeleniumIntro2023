package day03_webElements_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_WebElementMethods {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        driver.get("https://www.amazon.com");

        WebElement amazonSearchBox = driver.findElement(By.id("twotabsearchtextbox"));
        amazonSearchBox.sendKeys("nutella");
        Thread.sleep(1000);
        amazonSearchBox.clear();
        Thread.sleep(1000);
        amazonSearchBox.sendKeys("city bike");

        System.out.println(amazonSearchBox.getSize()); //(784, 38)
        System.out.println(amazonSearchBox.getTagName()); //input
        System.out.println(amazonSearchBox.getAttribute("name"));
        System.out.println(amazonSearchBox.getRect().getDimension());
        System.out.println(amazonSearchBox.isDisplayed()); // gorunuyor mu? true/false
        System.out.println(amazonSearchBox.isEnabled()); //kullanilabilir mi? it could be disabled result--> true/false
        amazonSearchBox.isSelected(); // use for checkbox and radiobuttons


        Thread.sleep(2000);
        driver.quit();
    }
}
