package day02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Example {
    public static void main(String[] args) throws InterruptedException {

        /*
        - go to facebook page
        - verify title equals "facebook", if not write the actual title
        - check url contains "facebook", if not write the actual url
        - go to walmart page
        - check title contains "Walmart.com"
        - turn back to facebook
        - refresh the page
        - maximize the page
        - close the browser
         */

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        driver.get("https://www.facebook.com");

        String actualFacebookTitle = driver.getTitle();
        String expectedFacebookTitle = "facebook";

        String actualFacebookUrl = driver.getCurrentUrl();
        String expectedFacebookUrl = "facebook";



        if (actualFacebookTitle.equals(expectedFacebookTitle)) {
            System.out.println("facebook title test passed");
        }
        else{
            System.out.println("facebook title test failed");
            System.out.println("Actual title : " + actualFacebookTitle);
            System.out.println("Expected title : "+expectedFacebookTitle);
        }

        if (actualFacebookUrl.contains(expectedFacebookUrl)){
            System.out.println("facebook url test passed");
        }
        else {
            System.out.println("facebook url test failed");
            System.out.println("Actual URL : "+actualFacebookUrl);
            System.out.println("Expected URL : "+expectedFacebookUrl);
        }

        Thread.sleep(2000);

        driver.navigate().to("https://www.walmart.com");

        String expectedWalmartTitle = "Walmart.com";
        String actualWalmartTitle = driver.getTitle();

        if (actualWalmartTitle.contains(expectedWalmartTitle)) {
            System.out.println("walmart title test passed");
        }
        else{
            System.out.println("walmart title test failed");
            System.out.println("Actual title : " + actualWalmartTitle);
            System.out.println("Expected title : "+expectedWalmartTitle);
        }


        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);
        driver.navigate().refresh();
        Thread.sleep(2000);
        driver.manage().window().fullscreen();
        Thread.sleep(2000);
        driver.quit();
    }
}
