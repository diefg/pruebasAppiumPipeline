import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.qameta.allure.Epic;
import io.qameta.allure.Link;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;


public class Tests {
    @BeforeTest
    protected void setUp(){
        DriverContext.setUp(OS.ANDROID,"","Pixel 2 api 27",true,"app-debug");
        //DriverContext.setUp(OS.IOS,"","iPhone X",true,"AppiumLogin");

    }

    @AfterTest
    protected void tearDown(){
        DriverContext.quitDriver();
    }


    @Test(description = "Test de aplicacion")
    @Story("APP-101")
    @Epic("FEATURE-1")
    @Link("appium-jira.com/APP-101")
    protected void test(){
       CP_01 cp_01=new CP_01();
       cp_01.pruebaLogin();
    }
    @Test(description = "Test que pasa")
    protected void testOk(){
        Assert.assertTrue(true,"Hola yo soy un test que pasa :)");
    }

    @Test(description = "Test que no pasa")
    protected void testNOk(){
        Assert.assertFalse(true,"Hola yo soy un test que no pasa :(");
    }

    @Test(description = "Test roto")
    protected void testBroken(){
        Boolean nulo=null;
        Assert.assertTrue(nulo,"Hola yo estoy roto *w*");
    }
    @Test(description = "Test ignorado")
    @Ignore
    protected void testSkipped(){
        Assert.assertTrue(true,"Hola no me pescan :(");

    }


}
