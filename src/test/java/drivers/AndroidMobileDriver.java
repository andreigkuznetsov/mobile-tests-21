package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.DeviceHost;
import helpers.EmulationHelper;
import helpers.BrowserStackHelper;
import helpers.LocalHelper;
import helpers.SelenoidHelper;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import javax.annotation.Nonnull;

import static config.ProjectData.*;
import static utils.FileUtils.getAbsolutePath;

public class AndroidMobileDriver implements WebDriverProvider {
    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull DesiredCapabilities desiredCapabilities) {
        if (deviceHost().equals(DeviceHost.BROWSERSTACK)) {
            return getBrowserStackMobileDriver(desiredCapabilities);
        }

        if (deviceHost().equals(DeviceHost.EMULATION)) {
            return getEmulationMobileDriver(desiredCapabilities);
        }

        if (deviceHost().equals(DeviceHost.LOCAL)) {
            return getLocalMobileDriver(desiredCapabilities);
        }

        return getSelenoidMobileDriver(desiredCapabilities);
    }

    public AndroidDriver<WebElement> getEmulationMobileDriver(@Nonnull DesiredCapabilities desiredCapabilities) {
        desiredCapabilities.setCapability("platformName", emulationConfig.platformName());
        desiredCapabilities.setCapability("deviceName", emulationConfig.deviceName());
        desiredCapabilities.setCapability("version", emulationConfig.version());
        desiredCapabilities.setCapability("locale", "en");
        desiredCapabilities.setCapability("language", "en");
        desiredCapabilities.setCapability("appPackage", "org.wikipedia.alpha");
        desiredCapabilities.setCapability("appActivity", "org.wikipedia.main.MainActivity");
        desiredCapabilities.setCapability("app", getAbsolutePath(emulationConfig.appURL()));

        return new AndroidDriver<>(EmulationHelper.getEmulationServerUrl(), desiredCapabilities);
    }

    public AndroidDriver<WebElement> getLocalMobileDriver(@Nonnull DesiredCapabilities desiredCapabilities) {
        desiredCapabilities.setCapability("platformName", localConfig.platformName());
        desiredCapabilities.setCapability("deviceName", localConfig.deviceName());
        desiredCapabilities.setCapability("version", localConfig.version());
        desiredCapabilities.setCapability("locale", "en");
        desiredCapabilities.setCapability("language", "en");
        desiredCapabilities.setCapability("appPackage", "org.wikipedia.alpha");
        desiredCapabilities.setCapability("appActivity", "org.wikipedia.main.MainActivity");
        desiredCapabilities.setCapability("app", getAbsolutePath(localConfig.appURL()));

        return new AndroidDriver<>(LocalHelper.getLocalServerUrl(), desiredCapabilities);
    }

    public AndroidDriver<WebElement> getSelenoidMobileDriver(@Nonnull DesiredCapabilities desiredCapabilities) {
        desiredCapabilities.setCapability("platformName", selenoidConfig.platformName());
        desiredCapabilities.setCapability("deviceName", selenoidConfig.deviceName());
        desiredCapabilities.setCapability("version", selenoidConfig.version());
        desiredCapabilities.setCapability("locale", "en");
        desiredCapabilities.setCapability("language", "en");
        desiredCapabilities.setCapability("appPackage", "org.wikipedia.alpha");
        desiredCapabilities.setCapability("appActivity", "org.wikipedia.main.MainActivity");
        desiredCapabilities.setCapability("app", selenoidConfig.appURL());

        desiredCapabilities.setCapability("enableVNC", true);
        desiredCapabilities.setCapability("enableVideo", true);

        return new AndroidDriver<>(SelenoidHelper.getSelenoidServerUrl(), desiredCapabilities);
    }

    public AndroidDriver<WebElement> getBrowserStackMobileDriver(DesiredCapabilities desiredCapabilities) {
        desiredCapabilities.setCapability("browserstack.user", browserStackConfig.browserStackUsername());
        desiredCapabilities.setCapability("browserstack.key", browserStackConfig.browserStackPassword());

        desiredCapabilities.setCapability("project", "First Java Project");
        desiredCapabilities.setCapability("build", "Android");
        desiredCapabilities.setCapability("name", "Java Android");
        desiredCapabilities.setCapability("autoGrantPermissions", "true");

        desiredCapabilities.setCapability("device", browserStackConfig.device());
        desiredCapabilities.setCapability("osVersion", browserStackConfig.os_version());
        desiredCapabilities.setCapability("app", browserStackConfig.app());

        return new AndroidDriver<>(BrowserStackHelper.getBrowserstackUrl(), desiredCapabilities);
    }
}
