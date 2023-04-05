package day04_xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Xpath {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        /*
        1) 6 locator we learned before are connected with HTML
        2) Xpath and cssSelector help us to locate all web elements without any tag or attribute
        3) all HTML elements have
         - tag
         - attribute(s)
         - attribute value
         4) xpath and cssSelector are formed by the combination of these 3 items

         //tagName[@attributeName='value']  --> if this not enough
         (//tagName[@attributeName='value'])[number]  -- number shows which one is our unique element
         */


        // go to  https://the-internet.herokuapp.com/add_remove_elements/
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        // click "add element" button
        WebElement addElementButton = driver.findElement(By.xpath("//button[@onclick='addElement()']"));
        addElementButton.click();

        // check "delete" button is displayed
        WebElement deleteButton = driver.findElement(By.xpath("//button[@onclick='deleteElement()']"));

        if (deleteButton.isDisplayed()){
            System.out.println("Delete button is displayed. Test PASSED");
        }else {
            System.out.println("Delete button is not displayed. Test FAILED");
        }

        // click "delete" button
        deleteButton.click();

        // check "add/remove elements" title are displayed.
        WebElement addRemoveTitle = driver.findElement(By.xpath("//h3"));

        if(addRemoveTitle.isDisplayed()) {
            System.out.println("Add/Remove title is displayed. Test PASSED");
        }else{
            System.out.println("Add/Remove title is not displayed. Test FAILED");
        }


        Thread.sleep(3000);
        driver.quit();
    }
}
