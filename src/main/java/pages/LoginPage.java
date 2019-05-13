package pages;

import appiumDriver.DriverContext;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.model.Status;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import reporter.Reports;
import util.Constants;


public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(new AppiumFieldDecorator(DriverContext.getDriver()),this);
    }

    @AndroidFindBy(id=Constants.ANDROID_PKG_ID+":id/input_rut")
    @iOSFindBy(id = "imputRut")
    public MobileElement txtRut;

    @AndroidFindBy(id= Constants.ANDROID_PKG_ID+":id/input_password")
    @iOSFindBy(id = "ImputPass")
    public MobileElement txtClave;

    @AndroidFindBy(id=Constants.ANDROID_PKG_ID+":id/swc_remember_rut")
    @iOSFindBy(id = "Switch")
    public MobileElement switchRecordarRut;

    @AndroidFindBy(id=Constants.ANDROID_PKG_ID+":id/btn_login")
    @iOSFindBy(id = "btnIngresar")
    public MobileElement btnLogin;

    public void login(String usr,String psw){
        try{
            Thread.sleep(3000);
            Reports.addStep("Test iniciado",true, Status.PASSED,false);
            switchRecordarRut.click();
            Thread.sleep(500);
            Reports.addStep("Se hizo clic en switch",true, Status.PASSED,false);
            txtRut.setValue(usr);
            Reports.addStep("Se ingreso rut",true, Status.PASSED,false);
            txtClave.setValue(psw);
            Reports.addStep("Se ingreso password",true, Status.PASSED,false);
            btnLogin.click();
        }catch (NoSuchElementException ex){
            System.out.println("No se encontró un elemento:"+ex.getMessage());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
