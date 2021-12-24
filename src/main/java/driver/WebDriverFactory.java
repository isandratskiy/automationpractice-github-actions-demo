package driver;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.WebDriverRunner.*;
import static java.lang.System.getProperty;
import static org.apache.commons.lang3.StringUtils.EMPTY;

public final class WebDriverFactory {
    private static final String BROWSER_PROPERTY = "browser";

    public static void createDriverInstance() {
        switch (getBrowserProperty()) {
            case "chrome.remote":
                Browser.REMOTE_CHROME.start();
                break;
            case "firefox.remote":
                Browser.REMOTE_FIREFOX.start();
                break;
            case "firefox.local":
                Browser.LOCAL_FIREFOX.start();
                break;
            default:
                Browser.LOCAL_CHROME.start();
        }
    }

    public static void shutdownDriverInstance() {
        getWebDriver().quit();
    }

    private static String getBrowserProperty() {
        return getProperty(BROWSER_PROPERTY, EMPTY);
    }

    private static void setRemoteCapabilities() {
        browserCapabilities.setCapability("noProxy", true);
        browserCapabilities.setCapability("enableVNC", true);
        browserCapabilities.setCapability("enableVideo", false);
    }

    private static void setRemoteInstance() {
        remote = "http://0.0.0.0:4444/wd/hub";
    }

    private enum Browser {
        REMOTE_CHROME {
            @Override
            void start() {
                setRemoteCapabilities();
                setRemoteInstance();
                browser = CHROME;
            }
        },
        REMOTE_FIREFOX {
            @Override
            void start() {
                setRemoteCapabilities();
                setRemoteInstance();
                browser = FIREFOX;
            }
        },
        LOCAL_CHROME {
            @Override
            void start() {
                browser = ChromeDriverProvider.class.getName();
            }
        },
        LOCAL_FIREFOX {
            @Override
            void start() {
                browser = FirefoxDriverProvider.class.getName();
            }
        };

        abstract void start();
    }
}
