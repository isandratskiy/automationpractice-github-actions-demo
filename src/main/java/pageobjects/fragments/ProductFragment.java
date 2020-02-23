package pageobjects.fragments;

import com.codeborne.selenide.SelenideElement;
import pageobjects.pages.CategoryPage;

public class ProductFragment extends CategoryPage {

    private SelenideElement container;

    public ProductFragment(SelenideElement container) {
        this.container = container;
    }

    public CartProductFragment addToCard() {
        this.container.$("a[class*='add_to_cart']").click();
        return new CartProductFragment();
    }
}
