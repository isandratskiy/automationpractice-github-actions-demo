package pageobjects.pages;

import com.codeborne.selenide.SelenideElement;
import data.AccountLinksEnum;
import io.qameta.allure.Step;
import pageobjects.AbstractPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class MyAccountPage extends AbstractPage {

    private static SelenideElement getAccountLinksList() {
        return $$(".myaccount-link-list").first().shouldBe(visible);
    }

    @Step("check created customer title")
    public static String getCustomerTitle() {
        return $(".account[title*='customer account']").text().trim();
    }

    @Step("check my account link : {title} ")
    public static boolean isPresentLink(AccountLinksEnum title) {
        return getAccountLinksList().$$("li").findBy(text(title.getTitle())).is(visible);
    }
}
