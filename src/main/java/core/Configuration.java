package core;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Configuration.fastSetValue;

public class Configuration {

    public static void setConfiguration() {
        timeout = 15000;
        browserSize = "1920x1080";
        baseUrl = "http://automationpractice.com/index.php";
        fastSetValue = true;
    }

    public static void setRemoteInstance() {
        remote = "http://0.0.0.0:4444/wd/hub";
    }
}
