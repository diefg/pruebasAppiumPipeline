# Appium tests for jenkins

Needed instalation steps

## Get Appium
Follow the steps on the "Get started guide"
[get started](http://appium.io/docs/en/about-appium/getting-started/index.html) 

## Specific OS configuration

## IOS
Follow the steps in "Basic setup"
[IOS SetUp](http://appium.io/docs/en/drivers/ios-xcuitest/index.html) 

## Android
Follow the steps in "Basic setup"
[Android SetUp](http://appium.io/docs/en/drivers/android-uiautomator2/index.html) 

if you got java 8 and android sdk already, you can add this to your ~/.bash_profile and should work right away

```bash
export JAVA_HOME="/Library/Java/JavaVirtualMachines/jdk1.8.0_211.jdk/Contents/H$
export ANDROID_HOME="/Users/itau/Library/Android/sdk"
export PATH=$PATH:$ANDROID_HOME/tools
export PATH=$PATH:$ANDROID_HOME/tools/bin
export PATH=$PATH:$ANDROID_HOME/platform-tools
export PATH=$PATH:$JAVA_HOME/bin
```




