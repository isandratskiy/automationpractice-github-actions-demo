import extensions.BaseSetup;
import lombok.val;
import model.UserModel;
import org.junit.jupiter.api.*;
import pageobjects.pages.MainPage;

import static pageobjects.Page.*;
import static data.AccountLinksEnum.*;
import static org.apache.commons.lang3.StringUtils.*;
import static org.junit.jupiter.api.Assertions.*;
import static pageobjects.pages.MyAccountPage.*;

@BaseSetup
@DisplayName("Account creation")
class MyAccountTest {

    @Test
    @DisplayName("user should see account details after registration flow")
    void shouldDisplayAccountDetails(UserModel user) {
        val accountTitle = user.getFirstName() + SPACE + user.getLastName();

        onPage(MainPage.class)
                .open()
                .clickSignInButton()
                .startCreateAccount(user)
                .registerUser(user);

        assertAll(
                () -> assertEquals(accountTitle, getCustomerTitle()),
                () -> assertTrue(isPresentLink(MY_ADDRESSES)),
                () -> assertTrue(isPresentLink(MY_CREDITS_SLIPS)),
                () -> assertTrue(isPresentLink(MY_PERSONAL_INFO)),
                () -> assertTrue(isPresentLink(ORDER_HISTORY))
        );
    }
}