import extensions.BaseSetup;
import lombok.val;
import model.UserModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pageobjects.pages.MainPage;

import static data.AccountLinksEnum.*;
import static org.apache.commons.lang3.StringUtils.SPACE;
import static org.junit.jupiter.api.Assertions.*;
import static pageobjects.pages.MyAccountPage.getCustomerTitle;
import static pageobjects.pages.MyAccountPage.isPresentLink;

@BaseSetup
@DisplayName("Account creation")
class MyAccountTest {

    @Test
    @DisplayName("user should see account details after registration flow")
    void shouldDisplayAccountDetails(UserModel user) {
        val accountTitle = user.getFirstName() + SPACE + user.getLastName();

        MainPage.open()
                .clickSignInButton()
                .startCreateAccount(user)
                .registerUser(user);

        assertAll("All account links should be displayed.",
                () -> assertEquals(accountTitle, getCustomerTitle()),
                () -> assertTrue(isPresentLink(MY_ADDRESSES)),
                () -> assertTrue(isPresentLink(MY_CREDITS_SLIPS)),
                () -> assertTrue(isPresentLink(MY_PERSONAL_INFO)),
                () -> assertTrue(isPresentLink(ORDER_HISTORY)));
    }
}