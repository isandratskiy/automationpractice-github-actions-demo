package pageobjects.fragments;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.AllArgsConstructor;
import pageobjects.pages.CheckoutPage;

import static com.codeborne.selenide.Selenide.*;

@AllArgsConstructor
public class CartProductFragment {
    private SelenideElement container;

    public CartProductFragment() {
        this.container = $("div[id=layer_cart]");
    }

    @Step("start checkout")
    public CheckoutPage startCheckout() {
        this.container.$("a[title$='checkout']").click();
        return new CheckoutPage();
    }


}
