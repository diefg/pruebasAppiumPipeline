package reporter;

import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.StepResult;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import appiumDriver.DriverContext;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.UUID;

public class Reports {

    public static void addStep(String descripcion, Boolean screenshot, Status status, Boolean fatal) {
        if (screenshot) {
            String uuid = UUID.randomUUID().toString();
            StepResult result = new StepResult().setName(descripcion).setStatus(status);
            Allure.getLifecycle().startStep(uuid, result);
            reportScreenshot();
            Allure.getLifecycle().stopStep(uuid);
        } else {
            String uuid = UUID.randomUUID().toString();
            StepResult result = new StepResult().setName(descripcion).setStatus(status);
            Allure.getLifecycle().startStep(uuid, result);
            Allure.getLifecycle().stopStep(uuid);
        }
        System.out.println("[reporter.Reports]"+descripcion);
        if (fatal) {
            //reportScreenshot();
            Assert.fail(descripcion);
        }
    }

    public static void addStep(String descripcion, Status status, Boolean fatal){
        addStep( descripcion,  false,  status,  fatal);
    }

    public static void addStep(String descripcion,Boolean screenshot, Status status){
        addStep( descripcion,  screenshot,  status,  false);
    }
    private static void reportScreenshot() {
        File scrFile;
        scrFile = ((TakesScreenshot) DriverContext.getDriver()).getScreenshotAs(OutputType.FILE);
        File screenshot = new File(scrFile.getPath());
        InputStream imagen;
        try {
            imagen = new FileInputStream(screenshot);
            Allure.addAttachment("Imagen adjunta", imagen);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void genericFail(NoSuchElementException ex, Boolean fatal) {
        addStep("No se encontró un elemento: " + ex.getMessage(), true, Status.FAILED, true);
    }
}
