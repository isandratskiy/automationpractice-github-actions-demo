package pageobjects.pages;

import io.qameta.allure.Step;
import lombok.val;
import pageobjects.AbstractPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class MyAccountPage extends AbstractPage {

    @Step
    public static String getCustomerTitle() {
        return $(".account[title*='customer account']").text().trim();
    }

    @Step
    public static boolean isPresentLink(String link) {
        val listContainer = $$(".myaccount-link-list").first();
        return listContainer.$$("li").findBy(text(link)).is(visible);
    }
}
