package day02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_driverMethods {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com");
        Thread.sleep(5000); // when we write this, must throw exception (interrupted exception).
        System.out.println("Current url is "+driver.getCurrentUrl());
        System.out.println("Title of the page "+driver.getTitle());


        driver.close();
    }
}
