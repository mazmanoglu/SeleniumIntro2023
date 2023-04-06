package day05_mavenProje;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C02_ZeroTest {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(ops);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // go to http://zero.webappsecurity.com
        driver.get("http://zero.webappsecurity.com");

        // click 'Sign-in' button
        WebElement firstSignInButton = driver.findElement(By.xpath("//button[@id='signin_button']"));
        firstSignInButton.click();

        // write "username" as login
        WebElement logInElement = driver.findElement(By.id("user_login"));
        logInElement.sendKeys("username");

        // write "password" as password
        WebElement passwordElement = driver.findElement(By.xpath("//input[@id='user_password']"));
        passwordElement.sendKeys("password");

        // click 'Sign in' button
        WebElement secondSignInButtonElement = driver.findElement(By.xpath("//input[@name='submit']"));
        secondSignInButtonElement.click();

        // go to the page 'pay bills'
        driver.navigate().back();
        WebElement onlineBankingMenuButtonElement = driver.findElement(By.xpath("//li[@id='onlineBankingMenu']"));
        onlineBankingMenuButtonElement.click();

        WebElement payBillsButtonElement = driver.findElement(By.xpath("//span[@id='pay_bills_link']"));
        payBillsButtonElement.click();

        // write any number as amount
        WebElement amountTextBoxElement = driver.findElement(By.xpath("//input[@id='sp_amount']"));
        amountTextBoxElement.sendKeys("300");

        // write '2020-09-10' as date
        WebElement dateElement = driver.findElement(By.xpath("//input[@id='sp_date']"));
        dateElement.sendKeys("2020-09-10");

        // click pay button
        WebElement payButtonElement = driver.findElement(By.xpath("//input[@id='pay_saved_payees']"));
        payButtonElement.click();

        // check "The payment was successfully submitted." is written.
        WebElement paymentSubmittedTextElement = driver.findElement(By.id("alert_content"));

        String actualPaymentSubmitText = paymentSubmittedTextElement.getText();
        String expectedPaymentSubmitText = "The payment was successfully submitted.";

        if (actualPaymentSubmitText.equals(expectedPaymentSubmitText)){
            System.out.println("Successfully submitted text is displayed. Test PASSED");
        }else{
            System.out.println("Successfully submitted text is NOT displayed.Test FAILED");
        }


        Thread.sleep(2000);
        driver.quit();
    }
}
