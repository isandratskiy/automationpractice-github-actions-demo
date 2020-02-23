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
                .getCreateAccountForm()
                .registerUser(user);
    }

    @Test
    void canPlaceOrderFromProductPage() {
        onPage(MainPage.class)
                .openCategoryPage("Women")
                .getFirstProduct()
                .addToCard()
                .startCheckout()
                .completeCheckoutSteps()
                .confirmWithBankWire();
        assertEquals("Your order on My Store is complete.", checkoutBankWireStatus());
    }

    @Test
    void canPlaceOrderFromSearch() {
        onPage(MainPage.class)
                .openProductPageFromSearch("shirt")
                .addToCard()
                .startCheckout()
                .completeCheckoutSteps()
                .confirmWithPayCheckMethod();
        assertEquals("Your order on My Store is complete.", checkoutPayCheckStatus());
    }
}
