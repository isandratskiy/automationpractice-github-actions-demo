import extensions.BaseSetup;
import lombok.val;
import model.UserModel;
import org.junit.jupiter.api.*;
import pageobjects.pages.MainPage;

import static core.Page.*;
import static org.apache.commons.lang3.StringUtils.*;
import static org.junit.jupiter.api.Assertions.*;
import static pageobjects.pages.MyAccountPage.*;

@BaseSetup
@DisplayName("Account creation")
public class MyAccountTest {

    @Test
    @DisplayName("user should see account details after registration flow")
    void shouldDisplayAccountDetails(UserModel user) {
        val accountTitle = user.getFirstName() + SPACE + user.getLastName();

        navigate("/", MainPage.class)
                .clickSignInButton()
                .startCreateAccount(user)
                .registerUser(user);

        assertAll(
                () -> assertEquals(accountTitle, getCustomerTitle()),
                () -> assertTrue(isPresentLink("ORDER HISTORY AND DETAILS")),
                () -> assertTrue(isPresentLink("MY CREDIT SLIPS")),
                () -> assertTrue(isPresentLink("MY ADDRESSES")),
                () -> assertTrue(isPresentLink("MY PERSONAL INFORMATION"))
        );
    }
}