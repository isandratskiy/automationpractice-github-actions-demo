package pageobjects.pages;

import static com.codeborne.selenide.Selenide.$;

public class CheckoutPage {

    public static String checkoutBankWireStatus() {
        return $("[class='cheque-indent']").text().trim();
    }

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

    public void confirmWithBankWire() {
        $(".bankwire").click();
        this.confirmOrder();
    }

    public void confirmWithPayCheckMethod() {
        $(".cheque").click();
        this.confirmOrder();
    }

    public CheckoutPage completeCheckoutSteps() {
        this.proceedSummaryStep();
        this.proceedAddressStep();
        this.completeShippingStep();
        return this;
    }
}
