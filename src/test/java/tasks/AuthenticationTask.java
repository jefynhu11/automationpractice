package tasks;

import appObjects.AuthenticationAppObject;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;

import static frameworks.ReportFw.log;
import static frameworks.ScreenshotFw.screenshotCapture;

public class AuthenticationTask {
    private WebDriver driver;
    private AuthenticationAppObject authenticationAppObject;

    public AuthenticationTask(WebDriver driver){
        this.driver = driver;
        this.authenticationAppObject = new AuthenticationAppObject(driver);
    }

    public void account(String email, String senha){
        if(driver.getTitle().equals("Login - My Store")) {
            log(Status.PASS, "Validação - O titulo Login correto.");
            authenticationAppObject.getEmailTextField().sendKeys(email);
            authenticationAppObject.getPasswordTextField().sendKeys(senha);
            authenticationAppObject.getSignInButton().click();
        } else {
            log(Status.ERROR, "Validação - O titulo Login incorreto", screenshotCapture(driver));
        }
    }
}
