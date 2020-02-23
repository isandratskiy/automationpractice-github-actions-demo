package pageobjects.pages;

import pageobjects.AbstractPage;
import pageobjects.fragments.CartProductFragment;

import static com.codeborne.selenide.Selenide.*;

public class ProductDetailPage extends AbstractPage {

    public CartProductFragment addToCard() {
        $("#add_to_cart").click();
        return new CartProductFragment();
    }
}
