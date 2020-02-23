package pageobjects.pages;

import pageobjects.AbstractPage;
import pageobjects.fragments.AccountCreationForm;

public class RegistrationPage extends AbstractPage {

    public AccountCreationForm getCreateAccountForm() {
        return new AccountCreationForm();
    }
}
