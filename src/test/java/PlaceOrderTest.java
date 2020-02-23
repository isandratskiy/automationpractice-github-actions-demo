import extensions.BaseSetup;
import model.UserModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pageobjects.pages.MainPage;

import static core.Page.onPage;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static pageobjects.pages.CheckoutPage.*;

@BaseSetup
@DisplayName("Order placement")
public class PlaceOrderTest {

    @BeforeEach
    void arrange(UserModel user) {
        onPage(MainPage.class)
                .open()
                .clickSignInButton()
                .startCreateAccount(user)
                .registerUser(user);
    }

    @Test
    @DisplayName("user can place order with product from category page")
    void canPlaceOrderFromCategoryPage() {
        onPage(MainPage.class)
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
        onPage(MainPage.class)
                .openProductPageFromSearch("shirt")
                .addToCard()
                .startCheckout()
                .proceedCheckoutSteps()
                .confirmWithPayCheck();

        assertEquals("Your order on My Store is complete.", checkoutPayCheckStatus());
    }
}
