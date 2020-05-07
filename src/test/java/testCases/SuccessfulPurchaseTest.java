package testCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
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

    @ParameterizedTest
    @CsvFileSource(resources = "/dados.csv")
    public void purchaseTest(String email, String senha) throws InterruptedException {
        authenticationTask.account(email, senha);
        Thread.sleep(4000);
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }
}
