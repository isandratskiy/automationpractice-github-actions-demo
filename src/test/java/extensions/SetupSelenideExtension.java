package extensions;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static driver.WebDriverFactory.*;

public class SetupSelenideExtension implements BeforeEachCallback, AfterEachCallback {
    @Override
    public void afterEach(ExtensionContext context) {
        getWebDriver().quit();
    }

    @Override
    public void beforeEach(ExtensionContext context) {
        createDriverInstance();
    }
}
