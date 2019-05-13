package appiumDriver;

import io.appium.java_client.AppiumDriver;
import util.OS;

public class DriverContext {
    private static DriverManager driverManager= new DriverManager();
    public static void setUp(OS os, String udId, String deviceName, Boolean emulador, String urlAppiumServer, String nameFile){
        driverManager.resolveDriver(os,  udId,  deviceName,  emulador,  urlAppiumServer, nameFile);
    }
    public static void setUp(OS os, String udId, String deviceName, Boolean emulador, String nameFile){
        driverManager.resolveDriver(os,  udId,  deviceName,  emulador, nameFile);
    }
    public static AppiumDriver getDriver(){
        return driverManager.getDriver();
    }
    public static void quitDriver(){
        driverManager.getDriver().quit();
    }
}
