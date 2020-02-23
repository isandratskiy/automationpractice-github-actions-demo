package driver;

import static com.codeborne.selenide.Configuration.*;
import static driver.WebDriverFactory.Browser.*;
import static java.lang.System.getProperty;
import static org.apache.commons.lang3.StringUtils.*;

public class WebDriverFactory {
    private static final String BROWSER_PROPERTY = "browser";

    public static void createDriverInstance() {
        switch (getBrowserProperty()) {
            case "chrome":
                CHROME.start();
                break;
            case "firefox":
                FIREFOX.start();
                break;
            default: LOCAL_CHROME.start();
        }
    }

    enum Browser {
        CHROME {
            @Override
            void start() {
                setConfiguration();
                setRemoteInstance();
                setRemoteCapabilities();
                browser = "chrome";
            }
        },
        FIREFOX {
            @Override
            void start() {
                setConfiguration();
                setRemoteInstance();
                setRemoteCapabilities();
                browser = "firefox";
            }
        },
        LOCAL_CHROME {
            @Override
            void start() {
                setConfiguration();
                browser = ChromeDriverProvider.class.getName();
            }
        };

        abstract void start();
    }

    private static String getBrowserProperty() {
        return getProperty(BROWSER_PROPERTY) == null
                ? EMPTY
                : getProperty(BROWSER_PROPERTY);
    }

    private static void setConfiguration() {
        timeout = 15000;
        browserSize = "1920x1080";
        baseUrl = "http://automationpractice.com/index.php";
        fastSetValue = true;
    }

    private static void setRemoteInstance() {
        remote = "http://0.0.0.0:4444/wd/hub";
    }

    private static void setRemoteCapabilities() {
        browserCapabilities.acceptInsecureCerts();
        browserCapabilities.setCapability("noProxy", true);
        browserCapabilities.setCapability("enableVNC", true);
        browserCapabilities.setCapability("enableVideo", false);
    }
}
