package day04_xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_XPathText {
    public static void main(String[] args) throws InterruptedException {

        /*
        A web element can contain text even it is not a link
        you cannot use By.linktext if html element has no link
        but we can write xpath using text

        //tagName[text()='text']
        or
        //*[text()='text']

        if tagName is not important, we can use * (means all tags)
         */


        System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // go to  https://the-internet.herokuapp.com/add_remove_elements/
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        // click "add element" button
        WebElement addButton = driver.findElement(By.xpath("//*[text()='Add Element']"));
        addButton.click();

        // check "delete" button is displayed
        WebElement deleteButton = driver.findElement(By.xpath("//button[text()='Delete']"));

        if (deleteButton.isDisplayed()){
            System.out.println("Delete button is displayed. Test PASSED");
        }else {
            System.out.println("Delete button is not displayed. Test FAILED");
        }

        // click "delete" button
        deleteButton.click();

        // check "add/remove elements" title are displayed.
        WebElement addRemoveTitle = driver.findElement(By.xpath("//*[text()='Add/Remove Elements']"));
        if(addRemoveTitle.isDisplayed()) {
            System.out.println("Add/Remove title is displayed. Test PASSED");
        }else{
            System.out.println("Add/Remove title is not displayed. Test FAILED");
        }

        Thread.sleep(3000);
        driver.quit();
    }
}
