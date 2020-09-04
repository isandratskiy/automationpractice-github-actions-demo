package extensions;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import static core.Configuration.*;
import static driver.WebDriverFactory.*;

public class SetupSelenideExtension implements BeforeEachCallback, AfterEachCallback, BeforeAllCallback {
    @Override
    public void afterEach(ExtensionContext context) {
        shutdownDriverInstance();
    }

    @Override
    public void beforeEach(ExtensionContext context) {
        createDriverInstance();
    }

    @Override
    public void beforeAll(ExtensionContext context) {
        buildConfig();
    }
}