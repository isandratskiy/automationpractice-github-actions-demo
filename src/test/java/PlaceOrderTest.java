import extensions.BaseSetup;
import model.UserModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pageobjects.pages.MainPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static pageobjects.pages.CheckoutPage.checkoutBankWireStatus;
import static pageobjects.pages.CheckoutPage.checkoutPayCheckStatus;

@BaseSetup
@DisplayName("Order placement")
class PlaceOrderTest {

    @BeforeEach
    void arrange(UserModel user) {
        MainPage.open()
                .clickSignInButton()
                .startCreateAccount(user)
                .registerUser(user);
    }

    @Test
    @DisplayName("user can place order with product from category page")
    void canPlaceOrderFromCategoryPage() {
        MainPage.open()
                .openCategoryPage("Women")
                .getFirstProduct()
                .addToCard()
                .startCheckout()
                .proceedCheckoutSteps()
                .confirmWithBankWire();

        assertEquals("Your order on My Store is complete.", checkoutBankWireStatus());
    }

    @Test
    @DisplayName("user can place order with product from search result")
    void canPlaceOrderFromSearch() {
        MainPage.open()
                .openProductPageFromSearch("shirt")
                .addToCard()
                .startCheckout()
                .proceedCheckoutSteps()
                .confirmWithPayCheck();

        assertEquals("Your order on My Store is complete.", checkoutPayCheckStatus());
    }
}
