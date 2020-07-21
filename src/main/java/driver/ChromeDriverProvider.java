package driver;

import com.codeborne.selenide.WebDriverProvider;
import lombok.val;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public final class ChromeDriverProvider implements WebDriverProvider {
    private static ChromeOptions getOptions() {
        val options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.setHeadless(true);
        options.setAcceptInsecureCerts(true);
        return options;
    }

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
        chromedriver().setup();
        return new ChromeDriver(getOptions());
    }
}
