package pageobjects.pages;

import io.qameta.allure.Step;
import pageobjects.AbstractPage;

import static com.codeborne.selenide.Selenide.$;

public class CheckoutPage extends AbstractPage {

    @Step("check Bank Wire payment status")
    public static String checkoutBankWireStatus() {
        return $("[class='cheque-indent']").text().trim();
    }

    @Step("check Pay Check payment status")
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

    @Step("confirm Bank Wire payment method")
    public void confirmWithBankWire() {
        logger.atInfo().log("confirm Bank Wire payment method");
        $(".bankwire").click();
        this.confirmOrder();
    }

    @Step("confirm Pay Check payment method")
    public void confirmWithPayCheck() {
        logger.atInfo().log("confirm Bank Wire payment method");
        $(".cheque").click();
        this.confirmOrder();
    }

    @Step("proceed checkout steps")
    public CheckoutPage proceedCheckoutSteps() {
        logger.atInfo().log("proceed checkout steps");
        this.proceedSummaryStep();
        this.proceedAddressStep();
        this.completeShippingStep();
        return this;
    }
}
