package pageobjects.pages;

import io.qameta.allure.Step;
import pageobjects.AbstractPage;
import pageobjects.fragments.CartProductFragment;

import static com.codeborne.selenide.Selenide.$;

public class ProductDetailPage extends AbstractPage {

    @Step("add product to cart")
    public CartProductFragment addToCard() {
        $("#add_to_cart").click();
        return new CartProductFragment();
    }
}
