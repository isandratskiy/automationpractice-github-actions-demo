package driver;

import com.codeborne.selenide.WebDriverProvider;
import lombok.val;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import javax.annotation.Nonnull;

import static io.github.bonigarcia.wdm.WebDriverManager.firefoxdriver;

public final class FirefoxDriverProvider implements WebDriverProvider {
    private static FirefoxOptions getOptions() {
        val options = new FirefoxOptions();
        options.setAcceptInsecureCerts(true);
        return options;
    }

    @Override
    public WebDriver createDriver(@Nonnull DesiredCapabilities desiredCapabilities) {
        firefoxdriver().setup();
        return new FirefoxDriver(getOptions());
    }
}
