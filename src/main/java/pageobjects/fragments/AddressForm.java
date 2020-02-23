package pageobjects.fragments;

import com.codeborne.selenide.SelenideElement;
import model.UserModel;

import static java.lang.String.valueOf;

public class AddressForm extends AccountCreationForm {

    private SelenideElement container;

    public AddressForm(SelenideElement container) {
        this.container = container;
    }

    public AddressForm fillAddressInfo(UserModel user) {
        this.setFirstName(user);
        this.setLastName(user);
        this.setAddressFirstLine(user);
        this.setAddressSecondLine(user);
        this.setCity(user);
        this.setState(user);
        this.setPostCode(user);
        this.setMobilePhone(user);
        this.setAddressAlias(user);
        return this;
    }

    private void setFirstName(UserModel user) {
        this.container.$("#firstname").val(user.getFirstName());
    }

    private void setLastName(UserModel user) {
        this.container.$("#lastname").val(user.getLastName());
    }

    private void setAddressFirstLine(UserModel user) {
        this.container.$("#address1").val(user.getAddress1());
    }

    private void setAddressSecondLine(UserModel user) {
        this.container.$("#address2").val(user.getAddress2());
    }

    private void setCity(UserModel user) {
        this.container.$("#city").val(user.getCity());
    }

    private void setPostCode(UserModel user) {
        this.container.$("#postcode").val(user.getPostcode());
    }

    private void setMobilePhone(UserModel user) {
        this.container.$("#phone_mobile").val(user.getPhone());
    }

    private void setAddressAlias(UserModel user) {
        this.container.$("#alias").val(user.getAddressAlias());
    }

    private void setState(UserModel user) {
        this.container.$("select[name='id_state']").selectOptionByValue(valueOf(user.getState()));
    }




}
