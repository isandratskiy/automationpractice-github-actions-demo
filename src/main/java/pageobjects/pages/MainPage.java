package pageobjects.pages;

import io.qameta.allure.Step;
import pageobjects.AbstractPage;
import pageobjects.fragments.CategoriesFragment;
import pageobjects.fragments.SearchFragment;

import static com.codeborne.selenide.Selenide.$;
import static core.Page.navigate;

public class MainPage extends AbstractPage {

    @Step("open main page")
    public MainPage open() {
        navigate("/", MainPage.class);
        logger.atInfo().log("navigate to main page");
        return this;
    }

    @Step("click SignIn button")
    public AuthenticationPage clickSignInButton() {
        $(".login").click();
        logger.atInfo().log("click SignIn button");
        return new AuthenticationPage();
    }

    @Step("open '{0}' product category")
    public CategoryPage openCategoryPage(String category) {
        return new CategoriesFragment().getCategoryWith(category);
    }

    public ProductDetailPage openProductPageFromSearch(String query) {
        return new SearchFragment().getFirstProductFromSearch(query);
    }
}