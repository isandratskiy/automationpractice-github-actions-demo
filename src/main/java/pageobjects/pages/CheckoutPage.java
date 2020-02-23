package pageobjects.pages;

import io.qameta.allure.Step;
import pageobjects.AbstractPage;

import static com.codeborne.selenide.Selenide.$;

public class CheckoutPage extends AbstractPage {

    @Step
    public static String checkoutBankWireStatus() {
        return $("[class='cheque-indent']").text().trim();
    }

    @Step
    public static String checkoutPayCheckStatus() {
        return $("[class='alert alert-success']").text().trim();
    }

    private void agreeTerms() {
        $("#uniform-cgv").click();
    }

    private void proceedSummaryStep() {
        $("a[class*='btn-default standard-checkout']").click();
    }

    private void proceedAddressStep() {
        $("button[name='processAddress']").click();
    }

    private void completeShippingStep() {
        this.agreeTerms();
        $("button[name='processCarrier']").click();
    }

    private void confirmOrder() {
        $("#cart_navigation > button[type='submit']").click();
    }

    @Step
    public void confirmWithBankWire() {
        $(".bankwire").click();
        this.confirmOrder();
    }

    @Step
    public void confirmWithPayCheck() {
        $(".cheque").click();
        this.confirmOrder();
    }

    @Step
    public CheckoutPage proceedCheckoutSteps() {
        this.proceedSummaryStep();
        this.proceedAddressStep();
        this.completeShippingStep();
        return this;
    }
}
