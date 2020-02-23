package core;

import io.qameta.allure.Step;
import lombok.SneakyThrows;
import pageobjects.AbstractPage;

import static com.codeborne.selenide.Selenide.*;

public class Page {

    @Step("Navigate to page : '{1}' ")
    public static <T extends AbstractPage> T navigate(String url, Class<T> pageClass) {
        return  open(url, pageClass);
    }

    @SneakyThrows
    @Step("User no page : '{0}' ")
    public static <T extends AbstractPage> T onPage(Class<T> pageClass) {
        return pageClass.newInstance();
    }
}