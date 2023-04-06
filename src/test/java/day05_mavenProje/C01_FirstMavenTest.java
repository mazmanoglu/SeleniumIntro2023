package day05_mavenProje;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class C01_FirstMavenTest {
    public static void main(String[] args) throws InterruptedException {

        //TODO If you use any error on previous packages, use below code to solve it.

        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(ops);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // go to "http://www.amazon.com"
        driver.get("https://www.amazon.com");

        // locate the search box
        WebElement searchBoxElement = driver.findElement(By.id("twotabsearchtextbox"));

        // search "Samsung headphones"
        searchBoxElement.sendKeys("Samsung headphones" + Keys.ENTER);

        // print the number of result
        WebElement numberOfResultElement = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        System.out.println(numberOfResultElement.getText());

        String numberOfResultStr = numberOfResultElement.getText();
        numberOfResultStr = numberOfResultStr.substring(
                (numberOfResultStr.indexOf("of")+3),
                (numberOfResultStr.indexOf("for")-1)
        );
        System.out.println(numberOfResultStr);

        // check the number of result is bigger than 100
        String numberOfResultIsBigger = numberOfResultElement.getText();
        numberOfResultIsBigger = numberOfResultIsBigger.substring(
                (numberOfResultIsBigger.indexOf("of")+3),
                (numberOfResultIsBigger.indexOf("results")-1)
        );
        if (Integer.parseInt(numberOfResultIsBigger)>100){
            System.out.println("Number of the result is bigger than 100. Test PASSED");
        }else {
            System.out.println("Number of the result is NOT bigger than 100. Test FAILED");
        }

        // click first product
        WebElement firstProductElement = driver.findElement(By.xpath("(//img[@data-image-index='1'])[1]"));
        firstProductElement.click();

        // print all titles-headlines
        driver.navigate().back();

        List<WebElement> listOfAllTitles = driver.findElements(By.xpath("//span[@class='a-size-base a-color-base']"));
        for (WebElement eachElement:listOfAllTitles
             ) {
            System.out.println(eachElement.getText());
        }

        Thread.sleep(3000);
        driver.quit();
    }
}
