package frameworks;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class ScreenshotFw {
    static String path = System.getProperty("user.dir")+File.separator+"screenshots"+File.separator+"ScreenshotFw"+System.nanoTime()+".jpg";

    public static String screenshotCapture(WebDriver driver) {
        try {
            File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileHandler.copy(src, new File(path));
            return path;
        } catch (IOException e) {
            return "Erro capturar de tela: " + e.getMessage();
        }
    }

    public static void screen(WebDriver driver) {
        try {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File(path));
        } catch (IOException e) {
            e.getMessage();
        }
    }
}
