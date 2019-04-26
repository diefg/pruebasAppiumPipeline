import io.appium.java_client.AppiumDriver;

public class DriverContext {
    private static DriverManager driverManager= new DriverManager();
    static void setUp(OS os, String udId, String deviceName, Boolean emulador, String urlAppiumServer,String nameFile){
        driverManager.resolveDriver(os,  udId,  deviceName,  emulador,  urlAppiumServer, nameFile);
    }
    static void setUp(OS os, String udId, String deviceName, Boolean emulador,String nameFile){
        driverManager.resolveDriver(os,  udId,  deviceName,  emulador, nameFile);
    }
    static AppiumDriver getDriver(){
        return driverManager.getDriver();
    }

    static void quitDriver(){
        driverManager.getDriver().quit();
    }
}
