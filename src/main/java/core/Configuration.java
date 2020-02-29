package core;

import io.qameta.allure.selenide.AllureSelenide;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Configuration.fastSetValue;
import static com.codeborne.selenide.logevents.SelenideLogger.*;
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
        return getProperty(SITE_LOCALE_PROP) == null
                ? "en"
                : getProperty(SITE_LOCALE_PROP);
    }

    private static void setSelenideConfiguration() {
        addListener("allure", new AllureSelenide().screenshots(true).savePageSource(false));
        timeout = 20000;
        browserSize = "1920x1080";
        baseUrl = "http://automationpractice.com/index.php";
        fastSetValue = true;
    }
}
