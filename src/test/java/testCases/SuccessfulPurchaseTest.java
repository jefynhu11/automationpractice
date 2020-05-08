package testCases;

import frameworks.BaseTestFw;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import tasks.AuthenticationTask;

import static frameworks.BaseTestFw.getDriver;
import static frameworks.ReportFw.setUpConfigure;
import static frameworks.ReportFw.setUpStart;

public class SuccessfulPurchaseTest extends BaseTestFw {
    private WebDriver driver = getDriver();
    private AuthenticationTask authenticationTask;

    @BeforeEach
    public void setUp(){
        setUpConfigure("Automação", "AutomationPractice");
        setUpStart("Compra com sucesso");
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        authenticationTask = new AuthenticationTask(driver);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/dados.csv")
    public void purchaseTest(String email, String senha) throws InterruptedException {
        authenticationTask.account(email, senha);
        Thread.sleep(2000);
    }

}
