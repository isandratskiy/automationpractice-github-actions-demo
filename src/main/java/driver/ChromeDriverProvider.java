package driver;

import com.codeborne.selenide.WebDriverProvider;
import lombok.val;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.HashMap;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static java.util.Arrays.*;

public class ChromeDriverProvider {

    private static ChromeOptions getOptions() {
        val options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-gpu");
        options.setExperimentalOption("excludeSwitches", asList("enable-automation"));
        options.setExperimentalOption("useAutomationExtension", false);
        options.setExperimentalOption("prefs", disablePasswordManager());
        options.setCapability("noProxy", true);
        options.setCapability("enableVNC", true);
        options.setCapability("enableVideo", false);
        options.setAcceptInsecureCerts(true);
        options.setHeadless(false);
        return options;
    }

    private static HashMap<String, Boolean> disablePasswordManager() {
        val preference = new HashMap<String, Boolean>();
        preference.put("credentials_enable_service", false);
        preference.put("profile.password_manager_enabled", false);
        return preference;
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
            chromedriver().setup();
            return new ChromeDriver(getOptions().setHeadless(true));
        }
    }
}
