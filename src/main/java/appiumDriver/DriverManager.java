package appiumDriver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import util.OS;


import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

class DriverManager {
    private DesiredCapabilities capabilities = new DesiredCapabilities();
    private AppiumDriver driver;
    private WebDriver webDriver;
    private File root = new File("apps");
    protected void resolveDriver(OS os, String udId, String deviceName, Boolean emulador, String fileName) {
        resolveDriver(os, udId, deviceName, emulador, "http://127.0.0.1:4723/wd/hub",fileName);
    }
    protected void resolveDriver(OS os, String udId, String deviceName, Boolean emulador, String urlAppiumServer, String nameFile) {
        URL server = null;
        try {
            server = new URL(urlAppiumServer);

        } catch (Exception e) {
            e.printStackTrace();
        }
        File app;
        if (os == OS.ANDROID) {
            app = new File(root, nameFile+".apk");
            capabilities.setCapability("deviceName", deviceName);
            if (!emulador) {
                capabilities.setCapability(MobileCapabilityType.UDID, udId);
            }
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
            capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
            //capabilities.setCapability("appPackage",util.Constants.ANDROID_PKG_ID);
            //capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"cl.itau.login.feature.login.LoginActivity");
            driver = new AndroidDriver(server, capabilities);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } else {
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.IOS);
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
            if (!emulador) {
                capabilities.setCapability(MobileCapabilityType.UDID, udId);
                app = new File(root, nameFile+".ipa");
            } else {
                app = new File(root, nameFile+".app");
                //capabilities.setCapability("platformVersion", "12.1");
            }
            capabilities.setCapability("xcodeSigningId", "");
            capabilities.setCapability("xcodeOrgId", "iPhone Developer");
            capabilities.setCapability(IOSMobileCapabilityType.AUTO_ACCEPT_ALERTS, "true");
            capabilities.setCapability(IOSMobileCapabilityType.AUTO_DISMISS_ALERTS, "true");
            capabilities.setCapability(IOSMobileCapabilityType.ALLOW_TOUCHID_ENROLL, true);
            capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
            driver = new IOSDriver(server, capabilities);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
    }

    protected AppiumDriver getDriver() {
        return driver;
    }

    protected void setDriver(AppiumDriver driver) {
        this.driver = driver;
    }

    protected Dimension getScreenSize() {
        return driver.manage().window().getSize();
    }



}
