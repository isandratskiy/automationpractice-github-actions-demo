package pageobjects.fragments;

import com.codeborne.selenide.SelenideElement;
import pageobjects.pages.CheckoutPage;

import static com.codeborne.selenide.Selenide.*;

public class CartProductFragment {

    private SelenideElement container;

    public CartProductFragment() {
        this.container = $("div[id=layer_cart]");
    }

    public CheckoutPage startCheckout() {
        this.container.$("a[title$='checkout']").click();
        return new CheckoutPage();
    }


}
