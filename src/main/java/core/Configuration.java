package core;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Configuration.fastSetValue;
import static java.lang.System.getProperty;
import static org.aeonbits.owner.ConfigFactory.setProperty;

public class Configuration {

    private static final String SITE_LOCALE_PROP = "site.locale";

    public static void buildConfig() {
        setSiteLocaleConfig();
        setSelenideConfiguration();
    }

    private static void setSiteLocaleConfig() {
        setProperty(SITE_LOCALE_PROP, getSiteLocaleProperty());
    }

    private static String getSiteLocaleProperty() {
        return getProperty(SITE_LOCALE_PROP) == null ? "en" : getProperty(SITE_LOCALE_PROP);
    }

    private static void setSelenideConfiguration() {
        timeout = 15000;
        browserSize = "1920x1080";
        baseUrl = "http://automationpractice.com/index.php";
        fastSetValue = true;
    }
}
