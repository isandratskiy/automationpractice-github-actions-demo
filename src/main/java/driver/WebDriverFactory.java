package driver;

import lombok.SneakyThrows;
import lombok.val;

import java.net.URL;

import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static driver.WebDriverFactory.Browser.*;
import static java.lang.System.getProperty;
import static org.apache.commons.lang3.StringUtils.EMPTY;

public class WebDriverFactory {
    private static final String BROWSER_PROPERTY = "browser";

    public static void createDriverInstance() {
        switch (getBrowserProperty()) {
            case "chrome.remote":
                REMOTE_CHROME.start();
                break;
            case "firefox.remote":
                REMOTE_FIREFOX.start();
                break;
            case "firefox.local":
                LOCAL_FIREFOX.start();
                break;
            case "chrome.local":
                LOCAL_CHROME.start();
                break;
            default:
                LOCAL_CHROME.start();
        }
    }

    public static void shutdownDriverInstance() {
        getWebDriver().quit();
    }

    private static String getBrowserProperty() {
        return getProperty(BROWSER_PROPERTY) == null
                ? EMPTY
                : getProperty(BROWSER_PROPERTY);
    }

    @SneakyThrows
    private static void setRemoteInstance(Class clazz) {
        val field = clazz.getDeclaredField("instance");
        field.setAccessible(true);
        field.set(null, new URL("http://0.0.0.0:4444/wd/hub"));
    }

    enum Browser {
        REMOTE_CHROME {
            @Override
            void start() {
                Class clazz = ChromeDriverProvider.Remote.class;
                setRemoteInstance(clazz);
                browser = clazz.getName();
            }
        },
        REMOTE_FIREFOX {
            @Override
            void start() {
                Class clazz = FirefoxDriverProvider.Remote.class;
                setRemoteInstance(clazz);
                browser = clazz.getName();
            }
        },
        LOCAL_CHROME {
            @Override
            void start() {
                browser = ChromeDriverProvider.Local.class.getName();
            }
        },
        LOCAL_FIREFOX {
            @Override
            void start() {
                browser = FirefoxDriverProvider.Local.class.getName();
            }
        };

        abstract void start();
    }
}
