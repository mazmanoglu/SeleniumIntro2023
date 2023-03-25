package day02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_DriverManageMethods {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)); //The searching time we give the driver to find the elements he is looking for. If the driver couldn't find within this time, it gives error.

        driver.get("https://www.amazon.com");
        driver.manage().window().fullscreen();
        System.out.println("fullscreen position " + driver.manage().window().getPosition());
        System.out.println("fullscreen size " + driver.manage().window().getSize());

        Thread.sleep(3000);

        driver.manage().window().maximize();
        System.out.println("maximize position " + driver.manage().window().getPosition());
        System.out.println("maximize size " + driver.manage().window().getSize());

        Thread.sleep(3000);

        driver.manage().window().minimize();
        System.out.println("minimize position " + driver.manage().window().getPosition());
        System.out.println("minimize size " + driver.manage().window().getSize());


        /*
        fullscreen position (0, 0)
        fullscreen size (1536, 864)
        maximize position (-8, -8)
        maximize size (1552, 832)
        minimize position (9, 9)
        minimize size (1051, 798)
         */

    }
}
