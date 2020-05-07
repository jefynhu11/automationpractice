package testCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import tasks.AuthenticationTask;

public class SuccessfulPurchaseTest {
    private WebDriver driver;
    private AuthenticationTask authenticationTask;

    @BeforeEach
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        authenticationTask = new AuthenticationTask(driver);
    }

    @Test
    public void purchaseTest() throws InterruptedException {
        authenticationTask.account();
        Thread.sleep(4000);
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }
}
