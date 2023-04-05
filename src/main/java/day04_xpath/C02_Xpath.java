package day04_xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Xpath {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // go to https://www.amazon.com
        driver.get("https://www.amazon.com");

        // make browser maximize and give 15 seconds wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // refresh the page
        driver.navigate().refresh();

        // check page title contains "Spend less"
        String actualTitle = driver.getTitle();
        String expectedWord = "Spend less";

        if (actualTitle.contains(expectedWord)){
            System.out.println("Actual title contains 'Spend less'. Test PASSED");
        }else {
            System.out.println("Actual title does not contain 'Spend less'. Test FAILED");
        }

        // click Gift Cards tab
        driver.findElement(By.linkText("Gift Cards")).click();

        // click Birthday button
        driver.findElement(By.xpath("//img[@alt='Birthday']")).click();

        // click the first product on Best Seller
        driver.findElement(By.xpath("(//img[@alt='Amazon.com eGift Card'])[1]")).click();

        // choose 25$ from Gift Card Details
        driver.findElement(By.xpath("//button[@value=25]")).click();

        // check the product price is 25$
        String expectedPrice = "25$";
        WebElement priceElement = driver.findElement(By.xpath("//span[@class='a-color-price a-text-bold']"));
        //System.out.println(priceElement); // you cannot write directly
        System.out.println(priceElement.getText());

        String actualPrice = priceElement.getText();

        if (actualPrice.equals(expectedPrice)){
            System.out.println("Gift card  price is equal to 25$. Test PASSED");
        }else{
            System.out.println("Gift card price is not equal to 25$. Actual price is "+actualPrice+" Test FAILED" );
        }


        //close the page
        Thread.sleep(3000);
        driver.quit();
    }
}
