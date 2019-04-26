import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;



public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(new AppiumFieldDecorator(DriverContext.getDriver()),this);
    }

    @AndroidFindBy(id=Constants.ANDROID_PKG_ID+":id/input_rut")
    @iOSFindBy(id = "imputRut")
    public MobileElement txtRut;

    @AndroidFindBy(id=Constants.ANDROID_PKG_ID+":id/input_password")
    @iOSFindBy(id = "ImputPass")
    public MobileElement txtClave;

    @AndroidFindBy(id=Constants.ANDROID_PKG_ID+":id/swc_remember_rut")
    @iOSFindBy(id = "Switch")
    public MobileElement switchRecordarRut;

    @AndroidFindBy(id=Constants.ANDROID_PKG_ID+":id/btn_login")
    @iOSFindBy(id = "btnIngresar")
    public MobileElement btnLogin;

    void verificarSw() throws NoSuchElementException {
        switchRecordarRut.click();
    }
    void login(String usr,String psw){
        try{
            switchRecordarRut.click();
            Thread.sleep(5000);
            verificarSw();
            txtRut.setValue(usr);
            txtClave.setValue(psw);
            btnLogin.click();
        }catch (NoSuchElementException ex){
            System.out.println("No se encontró un elemento:"+ex.getMessage());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
