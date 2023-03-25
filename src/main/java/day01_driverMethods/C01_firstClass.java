package day01_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_firstClass {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com");

        /*
            - download selenium files from selenium.dev/download
            - extract zip files
            - download driver file from selenium/dev/download/drivers
            - extract zip file
            - check your browser release version is same downloaded drivers release version
            - create new project, choose maven as build-system
            - make 'resources' under src file, put selenium files and (chrome)driver inside resources
            - choose File/projectstructure/modules/dependencies
            - click '+' and add jar file to the project
            - create a class src/main/java
            - write above codes inside main method
         */
    }
}
