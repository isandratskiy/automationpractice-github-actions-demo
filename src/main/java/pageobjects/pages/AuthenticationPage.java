package pageobjects.pages;

import io.qameta.allure.Step;
import lombok.val;
import model.UserModel;
import pageobjects.Page;
import pageobjects.fragments.AccountCreationForm;

import static com.codeborne.selenide.Selenide.$;
import static org.apache.commons.lang3.StringUtils.LF;

public class AuthenticationPage extends Page {

    @Step("start to login")
    public MyAccountPage loginAs(UserModel user) {
        val loginForm = $("#login_form");
        loginForm.$("#email").val(user.getEmail());
        loginForm.$("#passwd").val(user.getPassword());
        logger.atInfo().log(
                "login as : \n ".concat(user.getEmail() + LF + user.getPassword()));
        return new MyAccountPage();
    }

    @Step("start to create account")
    public AccountCreationForm startCreateAccount(UserModel user) {
        val accountForm = $("#create-account_form");
        accountForm.$("input[name='email_create']").val(user.getEmail());
        accountForm.$("#SubmitCreate").click();
        logger.atInfo().log(
                "create user with email : \n ".concat(user.getEmail()));
        return new AccountCreationForm();
    }
}
