package tasks;

import appObjects.IndexAppObject;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;

import static frameworks.ReportFw.log;
import static frameworks.ScreenshotFw.screenshotCapture;

public class IndexTask {
    private WebDriver driver;
    private IndexAppObject indexAppObject;

    public IndexTask(WebDriver driver){
        this.driver = driver;
        this.indexAppObject = new IndexAppObject(driver);
    }

    public void selectProduct(){
        if(driver.getTitle().equals("My Store")){
            log(Status.PASS, "Validação - O titulo My Store correto.");
            indexAppObject.getProductBlouseButton().click();
        }else {
            log(Status.ERROR, "Validação - O titulo My Store incorreto", screenshotCapture(driver));
        }

    }
}
