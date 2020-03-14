package driver;

import com.codeborne.selenide.WebDriverProvider;
import lombok.val;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

import static io.github.bonigarcia.wdm.WebDriverManager.firefoxdriver;

public class FirefoxDriverProvider {
    private static FirefoxOptions getOptions() {
        val options = new FirefoxOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-web-security");
        options.setCapability("noProxy", true);
        options.setCapability("enableVNC", true);
        options.setCapability("enableVideo", false);
        options.setAcceptInsecureCerts(true);
        options.setHeadless(false);
        return options;
    }

    static class Remote implements WebDriverProvider {
        private static URL instance;

        @Override
        public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
            return new RemoteWebDriver(instance, getOptions());
        }
    }

    static class Local implements WebDriverProvider {
        @Override
        public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
            firefoxdriver().setup();
            return new FirefoxDriver(getOptions());
        }
    }
}
