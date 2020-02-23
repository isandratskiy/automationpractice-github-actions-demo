package pageobjects.fragments;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.AllArgsConstructor;
import model.UserModel;

import static java.lang.String.*;

@AllArgsConstructor
public class PersonalInfoForm {
    private SelenideElement container;

    @Step
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
    }

    private void setBirthDay(UserModel user) {
        this.container.$("select[name='days']").selectOptionByValue(valueOf(user.getDayBirth()));
        this.container.$("select[name='months']").selectOptionByValue(valueOf(user.getMonthBirth()));
        this.container.$("select[name='years']").selectOptionByValue(valueOf(user.getYearBirth()));
    }



}
