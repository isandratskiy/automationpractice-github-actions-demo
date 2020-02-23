package pageobjects.fragments;

import com.codeborne.selenide.SelenideElement;
import model.UserModel;

import static java.lang.String.*;

public class PersonalInfoForm extends AccountCreationForm {

    private SelenideElement container;

    public PersonalInfoForm(SelenideElement container) {
        this.container = container;
    }

    public PersonalInfoForm fillPersonalInfo(UserModel user) {
        this.setFirstName(user);
        this.setLastName(user);
        this.setPassword(user);
        this.setBirthDay(user);
        return this;
    }

    private void setFirstName(UserModel user) {
        this.container.$("#customer_firstname").val(user.getFirstName());
    }

    private void setLastName(UserModel user) {
        this.container.$("#customer_lastname").val(user.getLastName());
    }

    private void setPassword(UserModel user) {
        this.container.$("#passwd").val(user.getPassword());
        logger.atInfo().log("User email is : ".concat(user.getPassword()));
    }

    private void setBirthDay(UserModel user) {
        this.container.$("select[name='days']").selectOptionByValue(valueOf(user.getDayBirth()));
        this.container.$("select[name='months']").selectOptionByValue(valueOf(user.getMonthBirth()));
        this.container.$("select[name='years']").selectOptionByValue(valueOf(user.getYearBirth()));
    }



}
