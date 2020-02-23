package core;

import io.qameta.allure.Step;
import lombok.SneakyThrows;
import pageobjects.AbstractPage;

import static com.codeborne.selenide.Selenide.*;

public class Page {

    @Step
    public static <T extends AbstractPage> T navigate(String url, Class<T> pageClass) {
        return  open(url, pageClass);
    }

    @SneakyThrows
    public static <T extends AbstractPage> T onPage(Class<T> pageClass) {
        return pageClass.newInstance();
    }
}