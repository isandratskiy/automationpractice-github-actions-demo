import extensions.BaseSetup;
import model.UserModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pageobjects.pages.MainPage;

import static core.Page.navigate;
import static core.Page.onPage;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static pageobjects.pages.CheckoutPage.*;

@BaseSetup
public class PlaceOrderTest {

    @BeforeEach
    void setUp(UserModel user) {
        navigate("/", MainPage.class)
                .clickSignInButton()
                .startCreateAccount(user)
                .registerUser(user);
    }

    @Test
    void canPlaceOrderFromProductPage() {
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
