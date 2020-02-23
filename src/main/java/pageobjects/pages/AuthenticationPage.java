package pageobjects.pages;

import io.qameta.allure.Step;
import lombok.val;
import model.UserModel;
import pageobjects.AbstractPage;

import static com.codeborne.selenide.Selenide.*;
import static org.apache.commons.lang3.StringUtils.*;

public class AuthenticationPage extends AbstractPage {

    public MyAccountPage loginAs(UserModel user) {
        val loginForm = $("#login_form");
        loginForm.$("#email").val(user.getEmail());
        loginForm.$("#passwd").val(user.getPassword());
        logger.atInfo().log(
                "Login as : \n ".concat(user.getEmail() + LF + user.getPassword())
        );
        return new MyAccountPage();
    }

    @Step
    public RegistrationPage startCreateAccount(UserModel user) {
        val accountForm = $("#create-account_form");
        accountForm.$("input[name='email_create']").val(user.getEmail());
        accountForm.$("#SubmitCreate").click();
        logger.atInfo().log(
                "User email is : \n ".concat(user.getEmail())
        );
        return new RegistrationPage();
    }
}
