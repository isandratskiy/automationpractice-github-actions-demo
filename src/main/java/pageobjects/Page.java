package pageobjects;

import com.google.common.flogger.FluentLogger;
import io.qameta.allure.Step;
import lombok.SneakyThrows;

import static com.codeborne.selenide.Selenide.open;
import static com.google.common.flogger.FluentLogger.forEnclosingClass;

public abstract class Page {
    protected static final FluentLogger logger = forEnclosingClass();

    @Step("navigate to page : '{1}' ")
    protected static <T extends Page> T navigate(String url, Class<T> pageClass) {
        logger.atInfo().log("navigate to : \n " + pageClass.getSimpleName());
        return open(url, pageClass);
    }

    @SneakyThrows
    @Step("user at page : {0} ")
    public <T extends Page> T atPage(Class<T> pageClass) {
        return pageClass.newInstance();
    }
}
