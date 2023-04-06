package day04_xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class C05_RelativeLocators {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //go to webpage https://www.diemol.com/selenium-4-demo/relative-locators-demo.html
        driver.get("https://www.diemol.com/selenium-4-demo/relative-locators-demo.html");

        //use relativeLocators and locate the Boston webElement 3 different ways (right side of London, left side of Berlin

        WebElement london = driver.findElement(By.id("pid5_price"));
        WebElement berlin = driver.findElement(By.id("pid7_price"));

        WebElement bostonFirstWay = driver.findElement(RelativeLocator.with(By.tagName("p")).toRightOf(london).toLeftOf(berlin));
        System.out.println(bostonFirstWay.getAttribute("id"));

        //below the toronto,
        WebElement toronto = driver.findElement(By.id("pid2_price"));
        WebElement bostonSecondWay = driver.findElement(RelativeLocator.with(By.className("ui-li-aside")).below(toronto));
        System.out.println(bostonSecondWay.getAttribute("id"));

        // above mountie and near amsterdam (near is not working)
        WebElement mountie = driver.findElement(By.id("pid10_price"));
        WebElement amsterdam = driver.findElement(By.id("pid9_price"));
        WebElement bostonThirdWay = driver.findElement(RelativeLocator.with(By.tagName("p")).above(mountie));
        System.out.println(bostonThirdWay.getAttribute("id"));


        Thread.sleep(3000);
        driver.quit();
    }
}
