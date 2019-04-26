import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Tests {
    @BeforeTest
    protected void setUp(){
        DriverContext.setUp(OS.ANDROID,"ce011821996350020d","Galaxy s8",false,"app-debug");
        //DriverContext.setUp(OS.IOS,"","iPhone X",true,"AppiumLogin");

    }

    @AfterTest
    protected void tearDown(){
        DriverContext.quitDriver();
    }


    @Test
    protected void test(){
        LoginPage loginPage= new LoginPage();
        loginPage.login("123","123");

    }


}
