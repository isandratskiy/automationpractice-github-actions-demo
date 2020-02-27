package pageobjects.pages;

import data.AccountLinksEnum;
import io.qameta.allure.Step;
import lombok.val;
import pageobjects.AbstractPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class MyAccountPage extends AbstractPage {

    @Step("check created customer title")
    public static String getCustomerTitle() {
        return $(".account[title*='customer account']").text().trim();
    }

    @Step("check my account link : {0} ")
    public static boolean isPresentLink(AccountLinksEnum title) {
        val listContainer = $$(".myaccount-link-list").first().shouldBe(visible);
        return listContainer.$$("li").findBy(text(title.getTitle())).is(visible);
    }
}
