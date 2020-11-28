package driver;

import com.codeborne.selenide.WebDriverProvider;
import lombok.val;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import javax.annotation.Nonnull;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public final class ChromeDriverProvider implements WebDriverProvider {
    private static ChromeOptions getOptions() {
        val options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        return options;
    }

    @Override
    public WebDriver createDriver(@Nonnull DesiredCapabilities desiredCapabilities) {
        chromedriver().setup();
        return new ChromeDriver(getOptions());
    }
}
