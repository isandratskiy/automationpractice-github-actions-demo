package pageobjects.fragments;

import com.codeborne.selenide.SelenideElement;
import com.google.common.flogger.FluentLogger;
import io.qameta.allure.Step;
import model.UserModel;
import pageobjects.pages.RegistrationPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.google.common.flogger.FluentLogger.forEnclosingClass;

public class AccountCreationForm extends RegistrationPage {
    protected static final FluentLogger logger = forEnclosingClass();

    private SelenideElement container;

    public AccountCreationForm() {
        this.container = element("#account-creation_form");
    }

    private PersonalInfoForm getPersonalInfoForm() {
        return new PersonalInfoForm(
                this.getFormBySubHeading("Your personal information")
        );
    }

    private AddressForm getAddressForm() {
        return new AddressForm(
                this.getFormBySubHeading("Your address")
        );
    }

    @Step
    public AccountCreationForm registerUser(UserModel user) {
        this.getPersonalInfoForm().fillPersonalInfo(user);
        this.getAddressForm().fillAddressInfo(user);
        this.container.$("#submitAccount").click();
        return this;
    }

    private SelenideElement getFormBySubHeading(String heading) {
        return this.container.$$(".account_creation > .page-subheading")
                .filterBy(text(heading))
                .first()
                .parent();
    }
}
