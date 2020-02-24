package pageobjects;

import com.google.common.flogger.FluentLogger;
import io.qameta.allure.Step;
import lombok.SneakyThrows;

import static com.codeborne.selenide.Selenide.*;
import static com.google.common.flogger.FluentLogger.forEnclosingClass;

public abstract class Page {
    private static final FluentLogger logger = forEnclosingClass();

    @Step("navigate to page : '{1}' ")
    public static <T extends AbstractPage> T navigate(String url, Class<T> pageClass) {
        logger.atInfo().log(
                "navigate to : \n ".concat(pageClass.getSimpleName())
        );
        return  open(url, pageClass);
    }

    @SneakyThrows
    public static <T extends AbstractPage> T onPage(Class<T> pageClass) {
        return pageClass.newInstance();
    }
}