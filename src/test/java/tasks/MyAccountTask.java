package tasks;

import appObjects.MyAccountAppObject;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;

import static frameworks.ReportFw.log;
import static frameworks.ScreenshotFw.screenshotCapture;

public class MyAccountTask {
    private WebDriver driver;
    private MyAccountAppObject myAccountAppObject;

    public MyAccountTask(WebDriver driver){
        this.driver = driver;
        this.myAccountAppObject = new MyAccountAppObject(driver);
    }

    public void homeAccount(){
        if(driver.getTitle().equals("My account - My Store")){
            log(Status.PASS, "Validação - O titulo My account correto.");
            myAccountAppObject.getHomeButton().click();
        }else{
            log(Status.ERROR, "Validação - O titulo My account incorreto", screenshotCapture(driver));
        }
    }
}
