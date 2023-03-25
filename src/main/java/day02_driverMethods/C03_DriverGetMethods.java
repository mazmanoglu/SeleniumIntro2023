package day02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_DriverGetMethods {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        System.out.println(driver.getWindowHandle()); // it gives a hashcode of the driver, every start will give different codes.

        System.out.println(driver.getWindowHandles()); // If the test open more than 1 tab/window, this will give all hashcodes of them. we can use these codes to relocate between tabs/windows.

        driver.get("https://www.amazom.com");
        System.out.println(driver.getPageSource()); // get all source codes of the page


        driver.quit();
    }
}
