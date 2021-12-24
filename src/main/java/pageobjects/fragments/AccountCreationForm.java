package pageobjects.fragments;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.AllArgsConstructor;
import model.UserModel;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.element;

@AllArgsConstructor
public class AccountCreationForm {
    private final SelenideElement container;

    public AccountCreationForm() {
        this.container = element("#account-creation_form");
    }

    private PersonalInfoForm getPersonalInfoForm() {
        return new PersonalInfoForm(
                this.getFormBySubHeading("Your personal information"));
    }

    private AddressForm getAddressForm() {
        return new AddressForm(
                this.getFormBySubHeading("Your address"));
    }

    private SelenideElement getFormBySubHeading(String heading) {
        return this.container.$$(".account_creation > .page-subheading")
                .filterBy(text(heading))
                .first()
                .parent();
    }

    @Step("register user")
    public AccountCreationForm registerUser(UserModel user) {
        this.getPersonalInfoForm().fillPersonalInfo(user);
        this.getAddressForm().fillAddressInfo(user);
        this.container.$("#submitAccount").click();
        return this;
    }
}
