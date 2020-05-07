package tasks;

import appObjects.AuthenticationAppObject;
import org.openqa.selenium.WebDriver;

public class AuthenticationTask {
    private WebDriver driver;
    private AuthenticationAppObject authenticationAppObject;

    public AuthenticationTask(WebDriver driver){
        this.driver = driver;
        this.authenticationAppObject = new AuthenticationAppObject(driver);
    }

    public void account(String email, String senha){
        authenticationAppObject.getEmailTextField().sendKeys(email);
        authenticationAppObject.getPasswordTextField().sendKeys(senha);
    }
}
