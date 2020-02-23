package pageobjects.fragments;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ProductFragment {
    private SelenideElement container;

    @Step
    public CartProductFragment addToCard() {
        this.container.$("a[class*='add_to_cart']").click();
        return new CartProductFragment();
    }
}
