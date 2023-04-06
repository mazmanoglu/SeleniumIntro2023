package day02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_FirstTest {
    public static void main(String[] args) {

        /*
        go to amazon webpage
        check page title contains 'amazon'
        check page url contains 'Amazon'
         */

        System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com");

        String expectedTitleContains="amazon";
        String expectedUrlContains="Amazon";

        String actualUrl = driver.getCurrentUrl();
        String actualTitle = driver.getTitle();

        if (actualUrl.contains(expectedUrlContains)){
            System.out.println("Url test passed");
        }
        else{
            System.out.println("Url test failed");
            System.out.println("Actual URL :" + actualUrl + " Expected URL :"+expectedUrlContains);
        }

        if (actualTitle.contains(expectedTitleContains)){
            System.out.println("Title test passed");
        }
        else{
            System.out.println("Title test failed");
            System.out.println("Actual title :" + actualTitle + " Expected title :"+expectedTitleContains);
        }

        // test are failed due to case-sensitive


        // driver.close(); just close the current tab, not browser
        // driver.quit(); close browser

        driver.quit();
    }
}
